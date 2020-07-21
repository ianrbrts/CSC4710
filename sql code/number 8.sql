select distinct email, rating from testdb.review
where email not in (select email from testdb.review where rating="poor" or rating="fair")
group by email