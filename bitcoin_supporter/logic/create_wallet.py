from logic.utility import generate_private_key, get_public_key, private_key_to_wif, private_key_to_address

import uuid

def create_wallet(query_params):
   if 'password' in query_params and 'api_code' in query_params and len(query_params['password']) >= 10:
      wallet_info = {}

      random_uuid = uuid.uuid4()
      wallet_info['guid'] = str(random_uuid)

      private_key = generate_private_key()
      wallet_info['private_key'] = private_key_to_wif(private_key)
      wallet_info['public_key'] = get_public_key(private_key)
      wallet_info['address'] = private_key_to_address(private_key)
      return wallet_info
   return None
