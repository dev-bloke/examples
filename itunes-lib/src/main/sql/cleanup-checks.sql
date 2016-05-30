select title, artist, count(*) from recording group by title, artist having count(*) > 1;

select distinct file_type from recording;

select distinct title, artist, file_type from recording where file_type != 'Apple Lossless audio file' order by file_type, artist, title;

select title, artist from recording 
where file_type != 'Apple Lossless audio file' 
and directory like '%ALAC%'
order by file_type, artist, title;