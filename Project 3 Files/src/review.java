


public class review {
	 	protected int id;
	    protected String URL;
	   	protected String email;
	   	protected String rating;
	   	protected String comment;
	   	
	   	
	    public review() {
	    }
	 
	     
	    public review(String URL, String email, String rating, String comment) {
	        this.URL = URL;
	        this.email = email;
	        this.rating = rating;
	        this.comment = comment;
	        
	    }
	   
	   
	 
	    public String getURL() {
	        return URL;
	    }
	    
	    public void setURL(String URL) {
	    	this.URL = URL;
	    }
	    
	    public String getRating() {
	        return rating;
	    }
	    
	    public void setRating(String rating) {
	    	this.rating = rating;
	    }
	    
	    public String getComment() {
	        return comment;
	    }
	    
	    public void setComment(String comment) {
	    	this.comment = comment;
	    }
	   
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	    	this.email = email;
	    }
	 
	    public String toString() {
	        return ("URL:"+this.getURL()+
	                    " Title: "+ this.getEmail() +
	                    " Rating: "+ this.getRating() +
	                    " Email: " + this.getEmail() +
	                    " Comment: " + this.getComment());
	   }
	
}


