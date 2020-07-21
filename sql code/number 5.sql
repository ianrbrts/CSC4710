select distinct tags,
group_concat(distinct email) as allemail, 
count(distinct video.email)
from testdb.video 
group by tags
having count(distinct email) >= (select count(distinct email) - 1 from testdb.users) /*subtracting 1 for root user*/