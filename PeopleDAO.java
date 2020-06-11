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
    	
    	String sql = "SELECT email FROM users WHERE email = ? AND password = ?)";
    				
    				
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	preparedStatement.setString(1, user.name);
    	preparedStatement.setString(2, user.password);
    	
    	System.out.println("I'm here");
    	
    	if(sql.contains(user.name)) {
    		if(sql.contains(user.password)) {
    			preparedStatement.close();
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
       	    			"('Tylerww@gmail.com', 'temppass10', 'Tyler', 'Walia', '52')";
     			
    	
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
