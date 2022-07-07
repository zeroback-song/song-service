create database songv1;
create user 'songv1'@'localhost' identified by '12345678';
GRANT ALL PRIVILEGES ON songv1.* TO 'songv1'@'localhost';
FLUSH PRIVILEGES;
use songv1;


