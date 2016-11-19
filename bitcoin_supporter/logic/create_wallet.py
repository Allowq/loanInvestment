import psycopg2, uuid

from urlparse import urlparse, parse_qs
from logic.utility import generate_private_key, get_public_key, private_key_to_wif, private_key_to_address

def check_api_valid(api_code, db_connection):
    cursor = db_connection.cursor()
    try:
        cursor.execute('SELECT id FROM api_codes WHERE api_code = %s', (api_code,))
        return cursor.fetchall()
    except psycopg2.Error as ex:
        print 'Error in check_api_valid(): ' + str(ex)
    raise { 'error' : 2008, 'message' : 'Service not responding' }

def check_wallets_is_limit(api_code_id, db_connection):
    cursor = db_connection.cursor()
    try:
        cursor.execute('SELECT api_code_id FROM wallets WHERE api_code_id = %s', (api_code_id,))
        return cursor.fetchall()
    except psycopg2.Error as ex:
        print 'Error in check_wallets_is_limit(): ' + str(ex)
    raise { 'error' : 2012, 'message' : 'Service not responding' }

def register_new_wallet(wallet_info, db_connection):
    cursor = db_connection.cursor()
    try:
        cursor.execute('''INSERT INTO wallets VALUES (%s, crypt(%s, gen_salt('bf', 8)), %s, %s)''', (
            wallet_info['guid'],
            wallet_info['password'],
            wallet_info['api_code_id'][0],
            wallet_info['address'],
        ))
    except Exception as ex:
        print 'Error in register_new_service(): ' + str(ex)
        raise { 'error' : 2010, 'message' : 'Service is unavailable' }

def create_wallet(user_info, db_connection):
    query_params = parse_qs(urlparse(user_info).query)
    if query_params:
        for key, value in query_params.iteritems():
            query_params[key] = value[0]
        if 'password' in query_params and 'api_code' in query_params and len(query_params['password']) >= 10:
            wallet = {}
            try:
                wallet['api_code_id'] = check_api_valid(query_params['api_code'], db_connection)
            except Exception as ex:
                return ex
            if not wallet['api_code_id']:
                return {'error': 2009, 'message': 'Api code not registred'}
            if len(check_wallets_is_limit(wallet['api_code_id'][0], db_connection)) > 5:
                return {'error': 2011, 'message': 'Limit of wallets been exhausted'}

            random_uuid = uuid.uuid4()
            wallet['guid'] = str(random_uuid)
            private_key = generate_private_key()
            wallet['address'] = private_key_to_address(private_key)
            wallet['password'] = query_params['password']

            try:
                register_new_wallet(wallet, db_connection)
            except Exception as ex:
                return ex
            del wallet['api_code_id']
            wallet['private_key'] = private_key_to_wif(private_key)
            wallet['public_key'] = get_public_key(private_key)
            return wallet

    return {'error': 2000, 'message': 'Invalid parameters for create wallet'}
