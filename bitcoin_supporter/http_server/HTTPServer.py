from BaseHTTPServer import BaseHTTPRequestHandler, HTTPServer
from SocketServer import ThreadingMixIn

from logic.create_wallet import create_wallet
from logic.create_api_code import create_api_code

import threading, re, json

class HTTPRequestHandler(BaseHTTPRequestHandler):
    def do_POST(self):
        if None != re.search('/bitcoin_supporter/api/create_wallet/*', self.path):
            self.send_response(200)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
            wallet_response = create_wallet(self.path, self.server.db_connection)
            self.wfile.write(json.dumps(wallet_response))

        elif None != re.search('/bitcoin_supporter/api/api_code*', self.path):
            self.send_response(200)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
            api_response = create_api_code(self.path, self.server.db_connection)
            self.wfile.write( json.dumps(api_response) )
        else:
            self.send_response(403)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
        return

    # def do_GET(self):
    #     if None != re.search('/bitcoin_supporter/api/create_wallet/*', self.path):
    #         self.send_response(200)
    #         self.send_header('Content-Type', 'application/json')
    #         self.end_headers()
    #         wallet_response = create_wallet(self.path, self.server.db_connection)
    #         self.wfile.write(json.dumps(wallet_response))
    #
    #     elif None != re.search('/bitcoin_supporter/api/api_code*', self.path):
    #         self.send_response(200)
    #         self.send_header('Content-Type', 'application/json')
    #         self.end_headers()
    #         api_response = create_api_code(self.path, self.server.db_connection)
    #         self.wfile.write( json.dumps(api_response) )
    #     else:
    #         self.send_response(403)
    #         self.send_header('Content-Type', 'application/json')
    #         self.end_headers()
    #     return

class ThreadedHTTPServer(ThreadingMixIn, HTTPServer):
    allow_reuse_address = True

    def shutdown(self):
        self.socket.close()
        HTTPServer.shutdown(self)

class BitcoinHttpServer():
    def __init__(self, ip, port, db_connection):
        self.server = ThreadedHTTPServer((ip,port), HTTPRequestHandler)
        self.server.db_connection = db_connection

    def start(self):
        self.server_thread = threading.Thread(target=self.server.serve_forever)
        self.server_thread.daemon = True
        self.server_thread.start()

    def waitForThread(self):
        while self.server_thread.is_alive:
            try:
                self.server_thread.join(600)
            except KeyboardInterrupt:
                break

    def stop(self):
        self.server.shutdown()
        self.waitForThread()