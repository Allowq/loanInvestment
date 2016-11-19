from http_server.HTTPServer import BitcoinHttpServer
from database.prepare_db import DatabaseUtil

import argparse

def main():
    parser = argparse.ArgumentParser(description='bitcoin supporter service')
    parser.add_argument('--port', '-p', type=int,   default=1337,           help='Bitcoin HTTP Server Port')
    parser.add_argument('--ip',   '-i', type=str,   default='localhost',    help='Bitcoin HTTP Server IP')
    args = parser.parse_args()

    db_provider = DatabaseUtil(reset=False)
    server = BitcoinHttpServer(args.ip, args.port, db_provider.db_connection)
    print 'HTTP Bitcoin Support Server Running...'
    server.start()
    server.waitForThread()

if __name__ == '__main__':
    main()