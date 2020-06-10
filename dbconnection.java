import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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


@WebServlet("/dbconnection");
public class dbconnection{
	
	private dbconnection _dbConnection = null;

	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&"
  			          + "user=john&password=pass1234");
            System.out.println(connect);
        }
    }
	
	//Function to drop all existing tables
	private void dropTables() throws SQLException {
		Statement createTable = _dbConnection.createStatement();
		
		createTable.execute("DROP TABLE IF EXISTS users");
	};
		
	Statement createStatement() throws SQLException {
        return _dbConnection.createStatement();
    }
	
	
	protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
	}
    
        private void createUsersTable() throws SQLException{
        	Statement createTable = _dbConnection.createStatement();
        	
        
        		
        	createTable.execute("CREATE TABLE IF NOT EXISTS users(" +
        			"email VARCHAR(255) NOT NULL," +
        			"password VARCHAR(100) NOT NULL,"+
        			"fname VARCHAR(100) NOT NULL," + 
        			"lname VARCHAR(100) NOT NULL," +
        			"age INT," +
        			"PRIMARY KEY (email)"+
        			")"
			);
        	
        	//Re-populate table
        	createTable.executeUpdate("DELETE FROM users");
        	createTable.executeUpdate("Existing Users" +
        			"('Johncon97@gmail.com', 'temppass1', 'John', 'Con', '20')," +
        			"('TedJ2@gmail.com', 'temppass2', 'Ted', 'Jaco', '23')," +
        			"('JackLi@gmail.com', 'temppass3', 'Jack', 'Li', '32')," +
        			"('JerrysTe@gmail.com', 'temppass4', 'Jerry', 'Smith', '21')," +
        			"('BethS@gmail.com', 'temppass5', 'Beth', 'Smith', '20')," +
        			"('RickJ@gmail.com', 'temppass6', 'Rick', 'James', '42')," +
        			"('ThomasTheo@gmail.com', 'temppass7', 'Thomas', 'Theodore', '20')," +
        			"('SallyT@gmail.com', 'temppass8', 'Sally', 'Tibet', '54')," +
        			"('Jessichar@gmail.com', 'temppass9', 'Jessica', 'Harland', '20')," +
        			"('Tylerww@gmail.com', 'temppass10', 'Tyler', 'Walia', '52')"
    	);
	}

}