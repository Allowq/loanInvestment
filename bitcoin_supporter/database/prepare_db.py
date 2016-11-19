import psycopg2

from psycopg2.extensions import ISOLATION_LEVEL_AUTOCOMMIT, ISOLATION_LEVEL_READ_COMMITTED

class DatabaseUtil():
    def __exit__(self, exc_type, exc_val, exc_tb):
        self.db_connection.close()

    def __init__(self,
                 user = 'postgres',
                 password ='postgres',
                 host='localhost',
                 port=5432,
                 db_name='bitcoin_db',
                 reset=False
                 ):
        try:
            if reset:
                self.db_connection = psycopg2.connect(user=user,
                                                      password=password,
                                                      host=host,
                                                      port=port,
                                                      database='postgres')
                self.db_connection.set_isolation_level(ISOLATION_LEVEL_AUTOCOMMIT)
            else:
                self.db_connection = psycopg2.connect(user=user,
                                                      password=password,
                                                      host=host,
                                                      port=port,
                                                      database=db_name)
                self.db_connection.set_isolation_level(ISOLATION_LEVEL_AUTOCOMMIT)
        except psycopg2.Error as ex:
            print 'Error in DatabaseUtil.__init__(): ' + str(ex)
            raise 1001
        if reset:
            self.reset_database(db_name)
            self.create_database(user, password, host, port, db_name)
            self.create_api_codes_table()
            self.create_wallets_table()



    def create_database(self, user, password, host, port, db_name):
        cursor = self.db_connection.cursor()
        try:
            cursor.execute('CREATE DATABASE ' + str(db_name) + ' OWNER postgres')
        except psycopg2.Error as ex:
            print 'Error in DatabaseUtil.create_database(): ' + str(ex)
            raise 1002
        try:
            self.db_connection.close()
            self.db_connection = psycopg2.connect(user=user,
                                                  password=password,
                                                  host=host,
                                                  port=port,
                                                  database=db_name)
            self.db_connection.set_isolation_level(ISOLATION_LEVEL_AUTOCOMMIT)
            cursor = self.db_connection.cursor()
            cursor.execute('CREATE EXTENSION pgcrypto')
        except psycopg2.Error as ex:
            print 'Error in DatabaseUtil.create_database(): ' + str(ex)
            raise 1003



    def reset_database(self, db_name):
        cursor = self.db_connection.cursor()
        try:
            cursor.execute('DROP DATABASE ' + db_name)
        except psycopg2.Error as ex:
            print 'Warning in DatabaseUtil.reset_database():' + str(ex)
        cursor.close()



    def create_api_codes_table(self):
        cursor = self.db_connection.cursor()
        try:
            cursor.execute(
                '''CREATE TABLE api_codes
                (
                    id serial PRIMARY KEY,
                    api_code VARCHAR(36) NOT NULL,
                    name_of_service VARCHAR(20) NOT NULL,
                    email_owner VARCHAR(40) NOT NULL,
                    url_service VARCHAR(40) NOT NULL,
                    description VARCHAR(255) DEFAULT ''
                )'''
            )
        except psycopg2.Error as ex:
            print 'Error in DatabaseUtil.create_api_codes_table(): ' + str(ex)
            raise 1004
        cursor.close()



    def create_wallets_table(self):
        cursor = self.db_connection.cursor()
        try:
            cursor.execute(
                '''CREATE TABLE wallets
                (
                    guid VARCHAR(36) PRIMARY KEY,
                    password TEXT NOT NULL,
                    api_code_id INT NOT NULL,
                    address VARCHAR(34) NOT NULL
                )'''
            )
        except psycopg2.Error as ex:
            print 'Error in DatabaseUtil.create_wallets_table(): ' + str(ex)
            raise 1005
        cursor.close()

if __name__ == '__main__':
    db_provider = DatabaseUtil(reset=True)