import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/PeopleDAO")
public class PeopleDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public PeopleDAO() {

    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = (Connection) DriverManager
        			      .getConnection("jdbc:mysql://localhost:3306/testdb?&"
        			          + "user=john&password=pass1234");
                System.out.println("Connection made");
                statement = connect.createStatement();
                
                statement.execute("CREATE TABLE IF NOT EXISTS users(" +
            			"email VARCHAR(255) NOT NULL," +
            			"password VARCHAR(100) NOT NULL,"+
            			"fname VARCHAR(100) NOT NULL," + 
            			"lname VARCHAR(100) NOT NULL," +
            			"age INT," +            			
            			"PRIMARY KEY (email)"+
            			")");
                System.out.println("Table made");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            
            System.out.println(connect);
        }
    }
    
    protected void createVideoTable() throws SQLException {
        
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                connect = (Connection) DriverManager
        			      .getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&"
        			          + "user=john&password=pass1234");
                System.out.println("Connection made");
                statement = connect.createStatement();
                
                
                statement.execute("CREATE TABLE IF NOT EXISTS video(" +
            			"URL VARCHAR(255) NOT NULL," +
            			"title VARCHAR(100) NOT NULL,"+
            			"description VARCHAR(100) NOT NULL," + 
            			"tags VARCHAR(100) NOT NULL,"
            			+ "date DATE NOT NULL," +
            			"email VARCHAR(255) NOT NULL,"
            			+ "comedian VARCHAR(255) NOT NULL," +
            			"FOREIGN KEY (email) REFERENCES users(email),"
            			+ "FOREIGN KEY (comedian) REFERENCES comedian(name)," +
            			"PRIMARY KEY (URL)"+
            			")");
                
                System.out.println("Video table made");
            } catch (Exception e) {
            	
            	throw new SQLException(e);
            }
            
            System.out.println(connect);
        
        
    }
    
    protected void createReviewTable() throws SQLException {
    	 try {
         	Class.forName("com.mysql.jdbc.Driver");
             connect = (Connection) DriverManager
     			      .getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&"
     			          + "user=john&password=pass1234");
             System.out.println("Connection made");
             statement = connect.createStatement();
             
             
             statement.execute("CREATE TABLE IF NOT EXISTS review(" +
            		
         			"comment VARCHAR(255) NOT NULL," +
         			"rating VARCHAR(100) NOT NULL,"+
         			"URL VARCHAR(255) NOT NULL,"+
         			"email VARCHAR(255) NOT NULL,"+
         			"reviewid int(1) NOT NULL AUTO_INCREMENT," +
         			"PRIMARY KEY (reviewid)"+
         			")");
             System.out.println("Review table made");
         } catch (Exception e) {
         	
         	throw new SQLException(e);
         }
         
         System.out.println(connect);
    }
    
    protected void createFavoriteTable() throws SQLException {
   	 try {
        	Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager
    			      .getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&"
    			          + "user=john&password=pass1234");
            System.out.println("Connection made");
            statement = connect.createStatement();
            
            
            statement.execute("CREATE TABLE IF NOT EXISTS favorite(" +
            		"URL VARCHAR(255) NOT NULL," +
        			"email VARCHAR(255) NOT NULL," +
            		"favid int NOT NULL AUTO_INCREMENT," +
        			"PRIMARY KEY(favid)"+
        			")");
            
            System.out.println("Favorite table made");
        } catch (Exception e) {
        	
        	throw new SQLException(e);
        }
        
        System.out.println(connect);
   }
    
    protected void createComedianTable() throws SQLException{
    	 try {
         	Class.forName("com.mysql.jdbc.Driver");
             connect = (Connection) DriverManager
     			      .getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&"
     			          + "user=john&password=pass1234");
             System.out.println("Connection made");
             statement = connect.createStatement();
             
             
             statement.execute("CREATE TABLE IF NOT EXISTS comedian(" +
             		"name VARCHAR(255) NOT NULL," +
         			"birthday VARCHAR(255) NOT NULL,"
         			+ "birthplace VARCHAR(255) NOT NULL," +
          			"PRIMARY KEY(name)"+
         			")");
             
             String sql = "INSERT IGNORE INTO comedian (name, birthday, birthplace) values "+
    	    			"('Dave Chappelle', '8/24/1973', 'Washington DC')," +
    	    			"('Jerry Seinfeld', '04/29/1954', 'Brooklyn, NY')," +
    	    			"('Bill Burr', '06/10/1968', 'Canton, MA')," +
    	    			"('Robin Williams', '07/21/1951', 'Chicago, IL')," +
    	    			"('John Mulaney', '08/26/1982', 'Chicago, IL')," +
    	    			"('Eddie Murphy', '04/03/1961', 'Brooklyn, NY')," +
    	    			"('George Carlin', '05/12/1937', 'Manhattan, NY')";
    	    			
             
            preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
         	preparedStatement.executeUpdate();
             
             System.out.println("Comedian table made");
         } catch (Exception e) {
         	
         	throw new SQLException(e);
         }
         
         System.out.println(connect);
    }
    
    public boolean signUp(People user) throws SQLException {
    	connect_func();         
		String sql = "insert into users(email, password, fname, lname, age) values (?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, user.name);
		preparedStatement.setString(2, user.password);
		preparedStatement.setString(3, user.firstname);
		preparedStatement.setString(4, user.lastname);
		preparedStatement.setString(5, user.age);
		//preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        //disconnect();
        return rowInserted;
    }
    
    public boolean login(People user) throws SQLException{
    	connect_func();
    	
    	
    	String sql = "SELECT email FROM users WHERE email = ? AND password = ?"; 
    	try(PreparedStatement statement = (PreparedStatement) connect.prepareStatement(sql)){
    		statement.setString(1, user.name);
    		statement.setString(2, user.password);
    		try(ResultSet resultSet = statement.executeQuery()){
    			System.out.println(resultSet);
    			return resultSet.next();
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	
    	
    	
    	
    				
    				
    	/*
    	preparedStatement.setString(1, user.name);
    	preparedStatement.setString(2, user.password);
    	
    	System.out.println("I'm here");
    	System.out.println(user.name);
    	System.out.println(preparedStatement);
    	
    	if(preparedStatement.toString().contains(user.name)) {
    		if(preparedStatement.toString().contains(user.password)) {
    			preparedStatement.close();
    			System.out.println("I'm here too");
    			return true;
    		}
    		else {
    			preparedStatement.close();
    			return false;
    		}
    	}
    	else {
    		preparedStatement.close();
    		return false;
    	}
    	
    	*/
    	
    	
    }
    
    public boolean dropTables() throws SQLException{
    	connect_func();
    	
    	String drop1 = "DROP TABLE IF EXISTS review";
    	String drop2 = "DROP TABLE IF EXISTS video";
    	String drop3 = "DROP TABLE IF EXISTS favorite";
    	String drop4 = "DROP TABLE IF EXISTS users";
    	
    	
    	String createFavorite = "CREATE TABLE IF NOT EXISTS `favorite` (" + 
    							"  `URL` varchar(255) NOT NULL," + 
    							"  `email` varchar(255) NOT NULL," + 
    							"  `favid` int NOT NULL AUTO_INCREMENT," + 
    							"  PRIMARY KEY (`favid`))";
    	
    	String createReview = "CREATE TABLE IF NOT EXISTS `review` (\r\n" + 
    							"  `reviewid` int NOT NULL AUTO_INCREMENT,\r\n" + 
    							"  `comment` varchar(255) NOT NULL,\r\n" + 
    							"  `rating` varchar(100) NOT NULL,\r\n" + 
    							"  `URL` varchar(255) NOT NULL,\r\n" + 
    							"  `email` varchar(255) NOT NULL,\r\n" + 
    							"  `comedian` varchar(45) NOT NULL,\r\n" + 
    							"  PRIMARY KEY (`reviewid`),\r\n" + 
    							"  KEY `URL` (`URL`),\r\n" + 
    							"  KEY `email` (`email`),\r\n" + 
    							"  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`URL`) REFERENCES `video` (`URL`),\r\n" + 
    							"  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`email`) REFERENCES `users` (`email`))";
    	
    	String createVideo = "CREATE TABLE IF NOT EXISTS `video` (\r\n" + 
    						 "  `URL` varchar(255) NOT NULL,\r\n" + 
    						 "  `title` varchar(100) NOT NULL,\r\n" + 
    						 "  `description` varchar(100) NOT NULL,\r\n" + 
    						 "  `tags` varchar(100) NOT NULL,\r\n" + 
    						 "  `email` varchar(255) DEFAULT NULL,\r\n" + 
    						 "  `date` date DEFAULT NULL,\r\n" + 
    						 "  `comedian` varchar(255) DEFAULT NULL,\r\n" + 
    						 "  PRIMARY KEY (`URL`),\r\n" + 
    						 "  KEY `email` (`email`)\r\n" + 
    						 ") ";
    	
       	String sql2 = "INSERT INTO users (email, password, fname, lname, age) values "+
       	    			"('Johncon97@gmail.com', 'temppass1', 'John', 'Con', '20')," +
       	    			"('TedJ2@gmail.com', 'temppass2', 'Ted', 'Jaco', '23')," +
       	    			"('JackLi@gmail.com', 'temppass3', 'Jack', 'Li', '32')," +
       	    			"('JerrysTe@gmail.com', 'temppass4', 'Jerry', 'Smith', '21')," +
       	    			"('BethS@gmail.com', 'temppass5', 'Beth', 'Smith', '20')," +
       	    			"('RickJ@gmail.com', 'temppass6', 'Rick', 'James', '42')," +
       	    			"('ThomasTheo@gmail.com', 'temppass7', 'Thomas', 'Theodore', '20')," +
       	    			"('SallyT@gmail.com', 'temppass8', 'Sally', 'Tibet', '54')," +
       	    			"('Jessichar@gmail.com', 'temppass9', 'Jessica', 'Harland', '20')," +
       	    			"('Tylerww@gmail.com', 'temppass10', 'Tyler', 'Walia', '52')," +
       	    			"('admin@root.com', '1234', 'root', 'admin', '100')";
       	
       	String sql3 = "INSERT INTO video (URL, title, description, tags, email, date, comedian) values "+
	    			"('https://www.youtube.com/watch?v=j2D4BelPffUc', 'Best Of: Bill Burr | Netflix Is A Joke', 'Bill Burr comedy','funny', 'TedJ2@gmail.com', curdate(),'Bill Burr')," +
	    			"('https://www.youtube.com/watch?v=t2fgzC8jqp8', '33 Minutes of JOHN MULANEY', 'John Mulaney comedy','funny',  'TedJ2@gmail.com', curdate(),'John Mulaney')," +
	    			"('https://www.youtube.com/watch?v=H6dmAEkapGg', 'Eddie Murphy - Standup', 'Funny stuff', 'Funny', 'RickJ@gmail.com', curdate(), 'Eddie Murphy'\r\n) ," + 
	    			"('https://www.youtube.com/watch?v=quZU_hA4Pr4', 'John Mulaney: “Canceling Plans Is Like Heroin”', 'John Mulaney bit',	'funny',  'SallyT@gmail.com', curdate(),'John Mulaney')," +
	    			"('https://www.youtube.com/watch?v=Hy-sVByUHqE', 'The Best of George Carlin', 'George Carlin all time','george carlin funny', 'TedJ2@gmail.com', curdate(),'Bill Burr'),"
	    			+ "('https://www.youtube.com/watch?v=Vn6MHmDo_Ck', 'Bill Burr - Breaking bad | Full standup special', 'Bill Burr','funny', 'Johncon97@gmail.com', curdate(),'Bill Burr'),"
	    			+ "('https://www.youtube.com/watch?v=8f-4etve2t0', 'Bill Burr Most Funny Standup Jokes Savage Moments', 'Bill burr', 'funny', 'JackLi@gmail.com', curdate(),'Bill Burr'),"
	    			+ "('https://www.youtube.com/watch?v=FA4kxlObK9Q', 'Jerry Seinfeld Compares Married Men To Game Show Losers', 'Jerry sienfeld','funny', 'JerrysTe@gmail.com', curdate(),'Jerry Seinfeld'),"
	    			+ "('https://www.youtube.com/watch?v=VuTMc3MbbXo', 'Jerry Seinfeld Live Chicago', 'Jerry','funny', 'BethS@gmail.com', curdate(),'Jerry Seinfeld'),"
	    			+ "('https://www.youtube.com/watch?v=73mWXVa12_c', 'Robin Williams Live On Broadway New York 2002', 'Robin Williams','funny', 'ThomasTheo@gmail.com', curdate(),'Robin Williams'),"
	    			+ "('https://www.youtube.com/watch?v=R0t7gFSW5aQ', 'The ULTIMATE Robin Williams COMPILATION', 'Robin williams funny stuff', 'funny', 'Jessichar@gmail.com', curdate(),'Robin Williams'),"
	    			+ "('https://www.youtube.com/watch?v=8yOWjkAxrwE', 'Eddie Murphys Delirous Part 10 ', 'Eddie murphy bit','funny', 'Tylerww@gmail.com', curdate(),'Eddie Murphy'),"
	    			+ "('https://www.youtube.com/watch?v=whfQf3Pd5bU', 'Eddie Murphys SNL', 'Eddie murphy bit','funny', 'ianrbrts42@gmail.com', curdate(),'Eddie Murphy')";
       	
       	String sql4 = "INSERT INTO review (reviewid, comment, rating, URL, email, comedian) values "+
	    			"(1, 'Very funny video', 'excellent', 'https://www.youtube.com/watch?v=j2D4BelPffUc', 'BethS@gmail.com', 'Bill Burr')," +
	    			"(2, 'It is okay, not great', 'fair', 'https://www.youtube.com/watch?v=quZU_hA4Pr4', 'Jessichar@gmail.com', 'John Mulaney')," +
	    			"(3, 'Not very funny', 'poor', 'https://www.youtube.com/watch?v=Hy-sVByUHqE', 'Tylerww@gmail.com', 'George Carlin')," +
	    			"(4, 'Very good, super funny', 'excellent', 'https://www.youtube.com/watch?v=quZU_hA4Pr4', 'Johncon97@gmail.com', 'John Mulaney')," + 
	    			"(5, 'I like this', 'excellent', 'https://www.youtube.com/watch?v=j2D4BelPffUc', 'Johncon97@gmail.com', 'Bill Burr')";
       	
       	String sql5 = "INSERT INTO favorite (URL, email, favid) values "+
	    			"('https://www.youtube.com/watch?v=j2D4BelPffUc', 'BethS@gmail.com', 1)," +
	    			"('https://www.youtube.com/watch?v=t2fgzC8jqp8', 'BethS@gmail.com', 2),"
	    			+ "('https://www.youtube.com/watch?v=j2D4BelPffUc', 'Tedj2@gmail.com', 3),"
	    			+ "('https://www.youtube.com/watch?v=t2fgzC8jqp8', 'TedJ2@gmail.com', 4),"
	    			+ "('https://www.youtube.com/watch?v=quZU_hA4Pr4', 'ThomasTheo@gmail.com', 5),"
	    			+ "('https://www.youtube.com/watch?v=j2D4BelPffUc', 'Johncon97@gmail.com', 6)";
	    			
       	
       	
       	
     			
    	
    	statement.execute(drop1);
    	statement.execute(drop2);
    	statement.execute(drop3);
    	statement.execute(drop4);
    	
        statement.execute("CREATE TABLE IF NOT EXISTS users(" +
    			"email VARCHAR(255) NOT NULL," +
    			"password VARCHAR(100) NOT NULL,"+
    			"fname VARCHAR(100) NOT NULL," + 
    			"lname VARCHAR(100) NOT NULL," +
    			"age INT," +
    			"PRIMARY KEY (email)"+
    			")");
        statement.execute(sql2);
        System.out.println("Users table made again");
        
        statement.execute(createVideo);
        System.out.println("Video table made again");

        statement.execute(createReview);
        System.out.println("review table made again");
        
        statement.execute(createFavorite);
        System.out.println("Favorite table made again");
                
        statement.execute(sql3);
        System.out.println("Video data added");
        
        statement.execute(sql4);
        System.out.println("Review data added");
        
        statement.execute(sql5);
        System.out.println("favorite data added");
        
     
    	return true;
    }
    
    protected boolean insertVideo(video freshVideo, String email) throws SQLException {
        createVideoTable();
        createComedianTable();
        
        String sql2 = "insert into video(URL, title, description, tags, email, comedian, date) values (?, ?, ?, ?, ?, ?, CURDATE())";
		String sql1 = "SELECT * FROM video WHERE email = ? AND date = CURDATE()";
		
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql1);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.last();
        
        if(resultSet.getRow() >= 5) {
        	System.out.println(email + (resultSet.getRow() + 1) + "This is true");
        	return false;
        }
        else {
        	System.out.println(email + (resultSet.getRow() + 1) + "This is false");
        }
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql2);
		preparedStatement.setString(1, freshVideo.URL);
		preparedStatement.setString(2, freshVideo.title);
		preparedStatement.setString(3, freshVideo.description);
		preparedStatement.setString(4, freshVideo.tags);
		preparedStatement.setString(5, email);
		preparedStatement.setString(6, freshVideo.comedian);
		//preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        //disconnect();
        return rowInserted;
    }
    
    protected List<video> searchResults(String params) throws SQLException{
    	video searchResult = null;
    	
    	List<video> listResults= new ArrayList<video>();   
    	
    	createVideoTable();
    	
    	String fullParams = "%"+params+"%";
    	String sql = "SELECT * FROM video WHERE url like ? OR title like ? OR description like ? OR tags like ?";
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	preparedStatement.setString(1, fullParams);
    	preparedStatement.setString(2, fullParams);
    	preparedStatement.setString(3, fullParams);
    	preparedStatement.setString(4, fullParams);
    	
    	ResultSet resultSet = preparedStatement.executeQuery();
    	
    	while (resultSet.next()) {
            String url = resultSet.getString("URL");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String tags = resultSet.getString("tags");
            String comedian = resultSet.getString("comedian");
             
            searchResult = new video(url, title, description, tags, comedian);
            listResults.add(searchResult);
            System.out.println(Arrays.toString(listResults.toArray()));
        }
    	
    	resultSet.close();
    	preparedStatement.close();
    	
    	return listResults;
    }
    
    protected boolean makeFavorite(String URL, String user) throws SQLException {
    	createFavoriteTable();
        createVideoTable();
        connect_func();
        
        
        String sql = "INSERT INTO favorite (URL, email) values(?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, URL);
		preparedStatement.setString(2, user);
		
		//preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        //disconnect();
        return rowInserted;
    }
    
    protected boolean deleteFavorite(String URL, String user) throws SQLException {
    	createFavoriteTable();
        createVideoTable();
        connect_func();
        
        
        String sql = "DELETE FROM favorite WHERE URL = ? AND email = ?";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, URL);
		preparedStatement.setString(2, user);
		
		//preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        //disconnect();
        return rowInserted;
    }
    
    protected List<video> showFavorite(String user) throws SQLException {
    	createFavoriteTable();
        createVideoTable();
        connect_func();
        
        
        List<video> favoriteList= new ArrayList<video>();  
        
        String sql = "SELECT favorite.URL, favorite.email, video.title "
        		+ "FROM favorite "
        		+ "INNER JOIN video ON favorite.URL=video.URL "
        		+ "WHERE favorite.email LIKE ?";
        			
        
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);		
		preparedStatement.setString(1, user);
		
		
		
		ResultSet resultSet1 = preparedStatement.executeQuery();
		
	
    	
    	while (resultSet1.next()) {
            String url = resultSet1.getString("URL");
            String email = resultSet1.getString("email");
            String title = resultSet1.getString("title");
            
            
          
            video favoriteResult = new video(url, email, title);
            favoriteList.add(favoriteResult);
            System.out.println(Arrays.toString(favoriteList.toArray()));
        }
    	
    	
		
		//preparedStatement.executeUpdate();
		
    	resultSet1.close();
    	preparedStatement.close();
    	
    	return favoriteList;
    }
    
    protected List<video> showComedianNames(String user) throws SQLException {
    	createComedianTable();
        createVideoTable();
        connect_func();
        
        
        List<video> comedianList= new ArrayList<video>();  
        
        String sql = "SELECT name FROM comedian ";
        		
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);		
		
		ResultSet resultSet1 = preparedStatement.executeQuery();
		
    	while (resultSet1.next()) {
            String name = resultSet1.getString("name");            
          
            video comedianResult = new video(name);
            comedianList.add(comedianResult);
        }
    	
    	
		
		//preparedStatement.executeUpdate();
		
    	resultSet1.close();
    	preparedStatement.close();
    	
    	return comedianList;
    }
    
    protected List<users> showUserNames() throws SQLException {
    	createComedianTable();
        createVideoTable();
        connect_func();
        
        
        List<users> userList= new ArrayList<users>();  
        
        String sql = "SELECT email FROM users";
        		
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);		
		
		ResultSet resultSet1 = preparedStatement.executeQuery();
		
    	while (resultSet1.next()) {
            String name = resultSet1.getString("email");            
          
            users result= new users(name);
            userList.add(result);
        }
    	
    	
		
		//preparedStatement.executeUpdate();
		
    	resultSet1.close();
    	preparedStatement.close();
    	
    	return userList;
    }
    
    protected boolean comment(String URL, String username, String rating, String comment, String comedian) throws SQLException {
    	createReviewTable();
        createVideoTable();
        connect_func();
        
        
        String sql = "INSERT INTO review (comment, rating, URL, email, comedian) VALUES (?,?,?,?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, comment);
		preparedStatement.setString(2, rating);
		preparedStatement.setString(3, URL);
		preparedStatement.setString(4, username);
		preparedStatement.setString(5, comedian);
		
		//preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        //disconnect();
        return rowInserted;
    }
    
    protected List<review> showComments(String URL) throws SQLException {
    	createReviewTable();
        createVideoTable();
        connect_func();
        
        
        List<review> reviewList= new ArrayList<review>();  
        
        String sql = "SELECT * FROM review"
        		+ " WHERE URL=?";
        
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, URL);
        	
        ResultSet resultSet1 = preparedStatement.executeQuery();
		
    	while (resultSet1.next()) {
            
            String email = resultSet1.getString("email");
            String rating = resultSet1.getString("rating");
            String comment = resultSet1.getString("comment");
            
          
            review allComments = new review(URL, email, rating, comment);
            reviewList.add(allComments);
            System.out.println(Arrays.toString(reviewList.toArray()));
        }
    	
    	
		
		//preparedStatement.executeUpdate();
		
    	resultSet1.close();
    	preparedStatement.close();
    	
    	return reviewList;
        
    }

	protected List<video> sortCool() throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> comedianList = new ArrayList<video>();  
        
        String sql = "select distinct comedian\r\n" + 
        			 "from testdb.review\r\n" + 
        			 "where comedian not in \r\n" + 
        			 "	(select distinct comedian from testdb.review t1 \r\n" + 
        			 "     where t1.rating=\"poor\" or t1.rating=\"fair\" or t1.rating=\"good\")";
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	
        ResultSet resultSet1 = preparedStatement.executeQuery();
		
    	while (resultSet1.next()) {
            String comedian = resultSet1.getString("comedian");
            video comedianName = new video(comedian);
                    
            comedianList.add(comedianName);

        }
    	
        
		return comedianList;
	}
	
	protected List<video> sortNew() throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> comedianList = new ArrayList<video>();  
        
        String sql = "select distinct comedian from testdb.video \r\n" + 
        			 "where date=curdate() AND comedian not in \r\n" + 
        			 "	(select distinct comedian from testdb.review \r\n" + 
        			 "     where date != curdate())";
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	
        ResultSet resultSet1 = preparedStatement.executeQuery();
		
    	while (resultSet1.next()) {
            String comedian = resultSet1.getString("comedian");
            video comedianName = new video(comedian);
                    
            comedianList.add(comedianName);
        }
    	
        
		return comedianList;
	}
	
	protected List<video> sortHot() throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> comedianList = new ArrayList<video>();  
        
        String sql = "select comedian, count(comedian) as freq from testdb.review\r\n" + 
        			 "group by comedian\r\n" + 
        			 "order by count(comedian) desc\r\n" + 
        			 "limit 3";
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	
        ResultSet resultSet1 = preparedStatement.executeQuery();
		
    	while (resultSet1.next()) {
            String comedian = resultSet1.getString("comedian");
            video comedianName = new video(comedian);
                    
            comedianList.add(comedianName);
        }
    	
        
		return comedianList;
	}
	
	protected List<video> sortCommon(String email1, String email2) throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> comedianList = new ArrayList<video>();
        
        String sql = "select distinct comedian from testdb.video \r\n" + 
	        		"where url in (select url  from testdb.favorite where favorite.email = ? or favorite.email = ? " + 
	        		"			group by url " + 
	        		"			having count(distinct email) = 2)";
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email1);
        preparedStatement.setString(2, email2);
        
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		System.out.println("Hello");
		
    	while (resultSet1.next()) {
            String comedian = resultSet1.getString("comedian");
            video commonComedian = new video(comedian);
                    
            comedianList.add(commonComedian);
        }
    	
        
		return comedianList;
	}

	
	//method to take care of the buttons in the sort page
	public List<video> getComediansVideos(String comedianName)throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> comedianList = new ArrayList<video>();
        
        String sql = "select distinct url, title from testdb.video where comedian = ? or tags = ? or email=?";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, comedianName);
        preparedStatement.setString(2, comedianName);
        preparedStatement.setString(3, comedianName);
        
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
    		System.out.println(comedianName);
            String URL = resultSet1.getString("URL");
            String title = resultSet1.getString("title");
            video comedianURL = new video(URL, title);
                    
            comedianList.add(comedianURL);
        }
    	
        
		return comedianList;
		
	}

	//method to return a list of the top comedians
	public List<video> getTopComedian() throws SQLException{
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> topComedians = new ArrayList<video>();
        
        String sql = "select comedian, count(comedian) as count\r\n" + 
        			 "from (\r\n" + 
        			 "	select comedian, count(comedian), RANK() over (order by count(comedian) desc) as rk\r\n" + 
        			 "    from testdb.video\r\n" + 
        			 "    group by comedian\r\n" + 
        			 "    ) t\r\n" + 
        			 "where rk = 1\r\n" + 
        			 "group by comedian";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
            String topComedian = resultSet1.getString("comedian");
            video topComedianObj = new video(topComedian);
                    
            topComedians.add(topComedianObj);
        }
    	
        
		return topComedians;
	}

	public List<video> getPopTags() throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> popTags = new ArrayList<video>();
        
        String sql = "select distinct tags \r\n" + 
        			 "from testdb.video \r\n" + 
        			 "group by tags\r\n" + 
        			 "having count(distinct email) >= (select count(distinct email) - 1 from testdb.users)";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
            String tags= resultSet1.getString("tags");
            video tagobj = new video(tags); //tags will be accessed with comedian because of the constructor
                    
            popTags.add(tagobj);
        }
    	
        
		return popTags;
	}

	public List<video> getProductiveEmail() throws SQLException{
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> productiveUser = new ArrayList<video>();
        
        String sql = "select email, count(email) as count\r\n" + 
        			 "from (\r\n" + 
        			 "	select email, count(email), RANK() over (order by count(email) desc) as rk\r\n" + 
        			 "    from testdb.video\r\n" + 
        			 "    group by email\r\n" + 
        			 "    ) t\r\n" + 
        			 "where rk = 1\r\n" + 
        			 "group by email";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
            String user = resultSet1.getString("email");
            video emailobj = new video(user); //tags will be accessed with comedian because of the constructor
                    
            productiveUser.add(emailobj);
        }
    	
        
		return productiveUser;
	}

	public List<video> getPositiveReviewers() throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> positiveReviewers = new ArrayList<video>();
        
        String sql = "select distinct email from testdb.review\r\n" + 
        			 "where email not in (select email from testdb.review where rating=\"poor\" or rating=\"fair\")";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
            String posReviewer = resultSet1.getString("email");
            video reviewerobj = new video(posReviewer); //tags will be accessed with comedian because of the constructor
                    
            positiveReviewers.add(reviewerobj);
        }
    	
        
		return positiveReviewers;
	}

	public List<video> getPoorVideos()  throws SQLException{
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> poorVideos = new ArrayList<video>();
        
        String sql = "select distinct review.url, video.title from testdb.review, testdb.video\r\n" + 
        			 "where video.url = review.url and review.url not in (select url from testdb.review where rating=\"excellent\" or rating=\"fair\" or rating=\"good\")";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
            String poorvideo = resultSet1.getString("url");
            String poortitle = resultSet1.getString("title");
            video poorReview = new video(poorvideo, poortitle); //tags will be accessed with comedian because of the constructor
                    
            poorVideos.add(poorReview);
        }
    	
        
		return poorVideos;
	}

	public List<video> getTwinUsers()throws SQLException {
		createReviewTable();
        createVideoTable();
        connect_func();
        
        List<video> twinEmails = new ArrayList<video>();
        
        String sql = "select distinct t1.email, length(group_concat(t1.url))from testdb.favorite t1\r\n" + 
        			 "group by email\r\n" + 
        			 "having length(group_concat(t1.url)) = any (select length(group_concat(t2.url)) from testdb.favorite t2 where t2.email != t1.email group by email)\r\n" + 
        			 "order by length(group_concat(url)) desc "
        			 + "limit 2";
	        		
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        
		
    	while (resultSet1.next()) {
            String twinEmail= resultSet1.getString("email");
            video twinObj = new video(twinEmail); //tags will be accessed with comedian because of the constructor
                    
            twinEmails.add(twinObj);
        }
    	
        
		return twinEmails;
	}
    
   
}
