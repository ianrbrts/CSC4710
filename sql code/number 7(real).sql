select email, count(email) as count
from (
	select email, count(email), RANK() over (order by count(email) desc) as rk
    from testdb.video
    group by email
    ) t
where rk = 1
group by email