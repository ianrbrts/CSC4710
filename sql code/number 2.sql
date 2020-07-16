select v1.comedian, date from testdb.video v1
where v1.date=curdate() AND not exists 
(select v2.comedian from testdb.video v2 where v2.date!=curdate() AND v1.comedian=v2.comedian)
