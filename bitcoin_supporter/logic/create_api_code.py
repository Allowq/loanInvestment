import psycopg2

from urlparse import urlparse, parse_qs
from logic.utility import generate_api_code

def check_api_exist(name, db_connection):
    cursor = db_connection.cursor()
    try:
        cursor.execute('SELECT 1 FROM api_codes WHERE name_of_service = %s', (name,))
        return cursor.fetchone()
    except psycopg2.Error as ex:
        print 'Error in check_api_exist(): ' + str(ex)
    raise { 'error' : 2002, 'message' : 'Service not responding' }



def register_new_service(service_info, db_connection):
    api_code = generate_api_code()
    cursor = db_connection.cursor()
    try:
        cursor.execute('INSERT INTO api_codes VALUES (DEFAULT, %s, %s, %s, %s, %s)', (
            api_code,
            service_info['name'],
            service_info['email'],
            service_info['url'],
            service_info['description'])
        )
    except psycopg2.Error as ex:
        print 'Error in register_new_service(): ' + str(ex)
        return { 'error' : 2003, 'message' : 'Service is unavailable' }
    return { 'api_code' : api_code }

def create_api_code(service_info, db_connection):
    query_params = parse_qs(urlparse(service_info).query)
    if query_params:
        for key, value in query_params.iteritems():
            query_params[key] = value[0]
        if not 'name' in query_params:
            return { 'error' : 2004, 'message' : 'Name of service not defined' }

        try:
            if check_api_exist(query_params['name'], db_connection):
                return { 'error' : 2005, 'message' : 'Current url is registred' }
        except Exception as ex:
            return ex

        if not 'description' in query_params:
            query_params['description'] = ''

        try:
            return register_new_service(query_params, db_connection)
        except Exception as ex:
            return ex
    return {'error': 2006, 'message' : 'Invalid parameters for registration'}



