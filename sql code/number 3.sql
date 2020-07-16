select comedian, count(comedian) as freq from testdb.review
group by comedian
order by count(comedian) desc
limit 3