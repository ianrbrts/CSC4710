select distinct t1.comedian 
from testdb.video t1
group by comedian 
order by count(comedian) desc 
limit 1

