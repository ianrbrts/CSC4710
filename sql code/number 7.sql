select email,
count(email) as freq
from testdb.video
group by email
order by freq desc
limit 1