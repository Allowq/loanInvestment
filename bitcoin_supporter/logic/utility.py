import uuid, random, os
import ecdsa, ecdsa.der, ecdsa.util, hashlib

b58 = '123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz'

def generate_api_code():
   array = bytearray(random.getrandbits(8) for _ in xrange(16))
   x = uuid.UUID(bytes=str(array))
   return str(x)

def base58encode(n):
   result = ''
   while n > 0:
      result = b58[n%58] + result
      n /= 58
   return result

def base58decode(s):
   result = 0
   for i in range(0, len(s)):
      result = result * 58 + b58.index(s[i])
   return result

def base58CheckEncode(version, payload):
   s = chr(version) + payload
   checksum = hashlib.sha256(hashlib.sha256(s).digest()).digest()[0:4]
   result = s + checksum
   leadingZeros = count_leading_chars(result, '\0')
   return '1' * leadingZeros + base58encode(base256decode(result))

def base58CheckDecode(s):
   leadingOnes = count_leading_chars(s, '1')
   s = base256encode(base58decode(s))
   result = '\0' * leadingOnes + s[:-4]
   chk = s[-4:]
   checksum = hashlib.sha256(hashlib.sha256(result).digest()).digest()[0:4]
   assert(chk == checksum)
   version = result[0]
   return result[1:]

def base256encode(n):
   result = ''
   while n > 0:
      result = chr(n % 256) + result
      n /= 256
   return result

def base256decode(s):
   result = 0
   for c in s:
      result = result * 256 + ord(c)
   return result

def count_leading_chars(s, ch):
   count = 0
   for c in s:
      if c == ch:
         count += 1
      else:
         break
   return count

def private_key_to_wif(key_hex):
   return base58CheckEncode(0x80, key_hex.decode('hex'))

def wif_to_private_key(s):
   b = base58CheckDecode(s)
   return b.encode('hex')

def private_key_to_public_key(s):
   sk = ecdsa.SigningKey.from_string(s.decode('hex'), curve=ecdsa.SECP256k1)
   vk = sk.verifying_key
   return ('\04' + sk.verifying_key.to_string()).encode('hex')

def public_key_to_address(s):
   ripemd160 = hashlib.new('ripemd160')
   ripemd160.update(hashlib.sha256(s.decode('hex')).digest())
   return base58CheckEncode(0, ripemd160.digest())

def private_key_to_address(s):
   return public_key_to_address(private_key_to_public_key(s))

def generate_private_key():
   return os.urandom(32).encode('hex')

def get_public_key(private_key):
   return private_key_to_public_key(private_key)

# private_key = generate_private_key()
# print private_key
# wif = private_key_to_wif(private_key)
# pk = wif_to_private_key(wif)
# print str(pk)

'''
print "Secret Exponent (Uncompressed) : %s " % generate_private_key()
print "Private Key     : %s " % private_key_to_wif(generate_private_key())
print "Address         : %s " % private_key_to_address(generate_private_key())
'''