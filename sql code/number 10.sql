select distinct t1.email, length(group_concat(t1.url))from testdb.favorite t1
group by email
having length(group_concat(t1.url)) = any (select length(group_concat(t2.url)) from testdb.favorite t2 where t2.email != t1.email group by email)
order by length(group_concat(url)) desc
limit 2