select v1.comedian, count(v1.comedian) as freq from testdb.video v1
where not exists (select v2.comedian, count(comedian) from testdb.video v2 having count(v1.comedian)=count(v2.comedian))
group by comedian
order by count(comedian) desc
limit 1  
