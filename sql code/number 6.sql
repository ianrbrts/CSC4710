select distinct comedian from testdb.video 
where url in (select url from testdb.favorite where favorite.email="fake@fake.com" or favorite.email="gg2252@wayne.edu"
			group by url
			having count(distinct email) = 2)
