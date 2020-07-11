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
            	
            case "/gotoinsert":
            	goToInsert(request,response);
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
    
    //method that gets called when clicking on the insert button from home
    protected void goToInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(tempUser != null) {
    		List<video> comedianNames = peopleDAO.showComedianNames(tempUser);
    		
    		RequestDispatcher dispatcher = req.getRequestDispatcher("insert.jsp");
	    	req.setAttribute("comedianList", comedianNames);
	    	dispatcher.forward(req, resp);
	        
    	}
    	else {
    		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    		dispatcher.forward(req, resp);
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
	        String comedian = req.getParameter("comedian");
	        
	        video freshVideo = new video(URL, title, description, tags, comedian);
	        
	        if(peopleDAO.insertVideo(freshVideo, username)) {
	        	List<video> comedianNames = peopleDAO.showComedianNames(tempUser);
	    		
	    		RequestDispatcher dispatcher = req.getRequestDispatcher("insert.jsp");
		    	req.setAttribute("comedianList", comedianNames);
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
    	
    	//getting an arraylist of all the results that match the params
    	List<video> results = peopleDAO.searchResults(parameters);
    	
    	RequestDispatcher dispatcher = req.getRequestDispatcher("results.jsp");
    	req.setAttribute("listResults", results);
    	dispatcher.forward(req, resp);
    }
    
    //method that is called when the user clicks on comment button from results.jsp
    protected void goToComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
    	if(tempUser != null) {
    		
    		
    		//setting these parameters so we can save them when we want to submit to the db
    		String URL = req.getParameter("URL");
    		String comedian = req.getParameter("comedian");
    	
    		List<review> allComments = peopleDAO.showComments(URL);
    	
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("CommentPage.jsp");
	    	
	    	//setting the attributes url and comedian to insert into db once form is submitted
	    	req.setAttribute("URL", URL);
	    	req.setAttribute("comedian", comedian);
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
    		String comedian = req.getParameter("comedian");
        	
        	if(peopleDAO.comment(URL, username, rating, comments, comedian)) {
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
    
    
    

}
