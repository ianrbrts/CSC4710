select distinct comedian
from testdb.review
where comedian not in 
	(select distinct comedian from testdb.review t1 
     where t1.rating="poor" or t1.rating="fair" or t1.rating="good")
