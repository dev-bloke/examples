create database if not exists recordings default character set utf8;

grant all on recordings.* to 'recordings'@'%' identified by 'r3c0rd1ng5';

flush privileges;

use recordings;

create table if not exists recording (
  id int primary key not null auto_increment,
  title varchar(255),
  artist varchar(255),
  year int,
  compilation boolean,
  directory varchar(255),
  directory_size int,
  disc_count int,
  file_type varchar(64),
  time varchar(8),
  time_ms int
);

create table if not exists song (
  id int primary key not null auto_increment,
  recording_id int,
  artist varchar(255),
  bit_rate int,
  comments varchar(255),
  disc_no int,
  file_name varchar(255),
  file_size int,
  file_type varchar(64),
  name varchar(255),
  sample_rate int,
  track_no int,
  time varchar(8),
  time_ms int,
  year int
);