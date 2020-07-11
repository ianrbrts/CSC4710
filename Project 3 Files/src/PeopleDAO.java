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
        			      .getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&"
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
    	
    	String sql = "DROP TABLE users";
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
     			
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	preparedStatement.executeUpdate();
        statement.execute("CREATE TABLE IF NOT EXISTS users(" +
    			"email VARCHAR(255) NOT NULL," +
    			"password VARCHAR(100) NOT NULL,"+
    			"fname VARCHAR(100) NOT NULL," + 
    			"lname VARCHAR(100) NOT NULL," +
    			"age INT," +
    			"PRIMARY KEY (email)"+
    			")");

        System.out.println("Table made again");
    	statement.execute(sql2);
    	
    	
    	
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
    
    /*
    public List<People> listAllPeople() throws SQLException {
        List<People> listPeople = new ArrayList<People>();        
        String sql = "SELECT * FROM student";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String status = resultSet.getString("status");
             
            People people = new People(id,name, address, status);
            listPeople.add(people);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listPeople;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
         
    public boolean insert(People people) throws SQLException {
    	connect_func();         
		String sql = "insert into  student(Name, Address, Status) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, people.name);
		preparedStatement.setString(2, people.address);
		preparedStatement.setString(3, people.status);
//		preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowInserted;
    }     
     
    public boolean delete(int peopleid) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, peopleid);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowDeleted;     
    }
     
    public boolean update(People people) throws SQLException {
        String sql = "update student set Name=?, Address =?,Status = ? where id = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, people.name);
        preparedStatement.setString(2, people.address);
        preparedStatement.setString(3, people.status);
        preparedStatement.setInt(4, people.id);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowUpdated;     
    }
	
    public People getPeople(int id) throws SQLException {
    	People people = null;
        String sql = "SELECT * FROM student WHERE id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String status = resultSet.getString("status");
             
            people = new People(id, name, address, status);
        }
         
        resultSet.close();
        statement.close();
         
        return people;
    }
    */
}
