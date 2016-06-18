mysql -uroot;
create database bookish;
create user 'bookish-admin'@'localhost' IDENTIFIED by 'password';
GRANT all privileges ON bookish.* TO 'bookish-admin'@'localhost' WITH GRANT OPTION;
