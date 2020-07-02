import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
	

    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
    public String tempUser = null;
 
    public void init() {
        peopleDAO = new PeopleDAO(); 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case"/signup":
            	signUp(request,response);
            	break;
            	
            case "/login":
            	login(request,response);
            	break;
            	
            case "/drop":
            	dropTables(request,response);
            	break;
            	
            case "/insert":
            	insert(request,response);
            	break;
         
            case "/search":
            	search(request,response);
            	break;
            	
            case "/comment":
            	goToComment(request,response);
            	break;
            
            case "/postcomment":
            	comment(request,response);
            	break;
            	
            case "/favorite":
            	favorite(request,response);
            	break;
            	
            case "/showfavorites":
            	goToFavorites(request,response);
            	break;
           
            case "/delete":
            	deleteFavorite(request,response);
            	break;
            	
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    
    protected void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	
        String username = req.getParameter("email");
        String password = req.getParameter("password1");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String age = req.getParameter("age");
        
        tempUser = username;
        
        People user = new People(username, password, fname, lname, age);
        peopleDAO.signUp(user);
        
        if(username.equals("admin@root.com") && password.equals("1234")) {
        	resp.sendRedirect("welcome.jsp");
        }
        else {
        	resp.sendRedirect("loggedin.jsp");
        }
    }
    
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	
    	String username = req.getParameter("email");
        String password = req.getParameter("password1");
        
        //variable to store the current user - probably a better way to do this
        tempUser = username;
        
        People user = new People(username, password); 	
        
        if(peopleDAO.login(user)) {
        	if(username.equals("admin@root.com") && password.equals("1234")) {
            	resp.sendRedirect("welcome.jsp");
            }
            else {
            	resp.sendRedirect("loggedin.jsp");
            }
        }
        else {
        	resp.sendRedirect("login.jsp");
        }
        
        
        
    }
    
    protected void dropTables(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(peopleDAO.dropTables()) {
    		System.out.println("Table Dropped");
    		resp.sendRedirect("welcome.jsp");
    	}
    }
    	
    //inserting a video onto the video table
    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(tempUser != null) {
    		String username = tempUser;
    		System.out.println(tempUser);
    	
	    	String URL = req.getParameter("url");
	        String title= req.getParameter("title");
	        String description = req.getParameter("description");
	        String tags = req.getParameter("tags");
	        
	        video freshVideo = new video(URL, title, description, tags);
	        
	        if(peopleDAO.insertVideo(freshVideo, username)) {
	        	RequestDispatcher dispatcher = req.getRequestDispatcher("insert.jsp");
		    	req.setAttribute("msg", "");
		    	dispatcher.forward(req, resp);
	        }
	        else {
	        	RequestDispatcher dispatcher = req.getRequestDispatcher("loggedin.jsp");
		    	dispatcher.forward(req, resp);
	        }
	        
	        	        
	        
	        
    	}
    	else {
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);
    	}
    	
    }
    
    //providing search results
    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	String parameters = req.getParameter("params");
    	
    	List<video> results = peopleDAO.searchResults(parameters);
    	
    	RequestDispatcher dispatcher = req.getRequestDispatcher("results.jsp");
    	req.setAttribute("listResults", results);
    	dispatcher.forward(req, resp);
    }
    
    protected void goToComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(tempUser != null) {
    		String username = tempUser;
    		System.out.println(tempUser);
    		String URL = req.getParameter("URL");
    	
    		List<review> allComments = peopleDAO.showComments(URL);
    	
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("CommentPage.jsp");
	    	req.setAttribute("URL", URL);
	    	req.setAttribute("listComments", allComments);
			dispatcher.forward(req, resp);
    	}
    	else {
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);
    	}
    }
    
    
    //method to add comments to the favorites table
    protected void comment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(tempUser != null) {
    		String username = tempUser;
    		System.out.println(tempUser);
    		String rating = req.getParameter("rating");
    		String comments = req.getParameter("Comments");
    		String URL = req.getParameter("URL");
        	
        	if(peopleDAO.comment(URL, username, rating, comments)) {
        		System.out.println("comment submitted");
        		
        		
        		List<review> allComments = peopleDAO.showComments(URL);
            	
    	    	RequestDispatcher dispatcher = req.getRequestDispatcher("CommentPage.jsp");
    	    	req.setAttribute("URL", URL);
    	    	req.setAttribute("listComments", allComments);
    			dispatcher.forward(req, resp);
        	
        	}
    	}
    	
    	else {
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);
    	}
    }
    
    //method to store a favorite in the favorites table 
    protected void favorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	//variable to store the current user - probably a better way to do this
    	if(tempUser != null) {
    		String username = tempUser;
    		System.out.println(tempUser);
    		String URL = req.getParameter("URL");
        	
        	if(peopleDAO.makeFavorite(URL, username)) {
        		System.out.println("Favorite saved");
        		
        		
            	
            	List<video> results = peopleDAO.showFavorite(tempUser);
            	
            	RequestDispatcher dispatcher = req.getRequestDispatcher("favorites.jsp");
            	req.setAttribute("listResults", results);
            	dispatcher.forward(req, resp);
        		
        		
        		
        	}
    	}
    	
    	else {
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);
    	}
    		
    		
    	
    	
    }
    
    //method that gets the current user's saved favorites
    protected void goToFavorites(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	List<video> results = peopleDAO.showFavorite(tempUser);
    	
    	RequestDispatcher dispatcher = req.getRequestDispatcher("favorites.jsp");
    	req.setAttribute("listResults", results);
    	dispatcher.forward(req, resp);
    	
    }
    
    //deleting a favorite that was previously saved
    protected void deleteFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(tempUser != null) {
    		String username = tempUser;
    		System.out.println(tempUser);
    		String URL = req.getParameter("URL");
    		System.out.println(URL);
        	
        	if(peopleDAO.deleteFavorite(URL, username)) {
        		System.out.println("Favorite saved");
        		
            	List<video> results = peopleDAO.showFavorite(tempUser);
            	
            	RequestDispatcher dispatcher = req.getRequestDispatcher("favorites.jsp");
            	req.setAttribute("listResults", results);
            	dispatcher.forward(req, resp);
        		
        	}
    	}
    	
    	else {
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);
    	}
    }
    
    /*
    private void listPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<People> listPeople = peopleDAO.listAllPeople();
        request.setAttribute("listPeople", listPeople);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleList.jsp");       
        dispatcher.forward(request, response);
    }
 
    // to insert a people
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("InsertPeopleForm.jsp");
        dispatcher.forward(request, response);
    }
 
    // to present an update form to update an  existing Student
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        People existingPeople = peopleDAO.getPeople(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditPeopleForm.jsp");
        request.setAttribute("people", existingPeople);
        dispatcher.forward(request, response); // The forward() method works at server side, and It sends the same request and response objects to another servlet.
 
    }
 
    // after the data of a people are inserted, this method will be called to insert the new people into the DB
    // 
    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        People newPeople = new People(name, address, status);
        peopleDAO.insert(newPeople);
        response.sendRedirect("list");  // The sendRedirect() method works at client side and sends a new request
    }
 
    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        
        System.out.println(name);
        
        People people = new People(id,name, address, status);
        peopleDAO.update(people);
        response.sendRedirect("list");
    }
 
    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //People people = new People(id);
        peopleDAO.delete(id);
        response.sendRedirect("list"); 
    }
    */
    

}
