select comedian from testdb.video 
where date=curdate() AND comedian not in 
	(select distinct comedian from testdb.review 
     where date != curdate())
