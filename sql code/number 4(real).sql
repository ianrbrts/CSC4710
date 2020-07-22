select comedian, count(comedian) as count
from (
	select comedian, count(comedian), RANK() over (order by count(comedian) desc) as rk
    from testdb.video
    group by comedian
    ) t
where rk = 1
group by comedian