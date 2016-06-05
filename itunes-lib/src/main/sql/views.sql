create or replace view old_recording as
select o.*, concat(o.artist, '|', o.title) artist_title
from old_recordings.recording o;

create or replace view artist_title as
select concat(r.artist, '|', r.title) artist_title
from recording r;

create or replace view missing_recording as
select o.artist, o.title
from old_recording o
where o.artist_title not in (
    select r.artist_title from recording r
);

create or replace view location_file_type as
select 'ALAC' location, r.file_type, count(*) recordings
from recording r
where directory like '%ALAC/%'
group by r.file_type
union
select 'AAC' location, r.file_type, count(*)
from recording r
where directory like '%AAC/%'
group by r.file_type
union
select 'Download' location, r.file_type, count(*)
from recording r
where directory like '%Downloads/%'
group by r.file_type
;