use examples;

create table recordings (
    id int primary key not null auto_increment,
    year int,
    artist varchar(64),
    title varchar(128)
);

create table songs (
    id int primary key not null auto_increment,
    recording_id int,
    duration varchar(8),
    title varchar(128)
);

create index recording_songs on songs(recording_id);

create table vehicles (
    make varchar(16),
    model varchar(32),
    doors int,
    vehicle_type varchar(16),
    primary key (make, model)
);
