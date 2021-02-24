create database examples default character set utf8;

grant all on examples.* to 'examples'@'%' identified by '3x4mpl35';

commit;

flush privileges;
