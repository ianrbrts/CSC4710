
public class video {
	 	protected int id;
	    protected String URL;
	    protected String title;
	    protected String description;
	    protected String tags;
	    protected String email;
	    protected String comedian;
	 
	    public video() {
	    }
	 
	    public video(String URL, String title, String description, String tags, String comedian) {
	        this.URL = URL;
	        this.title= title;
	        this.description = description;
	        this.tags = tags;
	        this.comedian = comedian;
	        
	    }
	    
	    public video(String URL, String title, String description, String tags) {
	        this.URL = URL;
	        this.title= title;
	        this.description = description;
	        this.tags = tags;
	        
	    }
	    
	    public video(String URL, String email) {
	    	this.URL = URL;
	    	this.email = email;
	    }
	    
	    public video(String URL, String email, String title) {
	    	this.URL = URL;
	    	this.email = email;
	    	this.title = title;
	    }
	    
	    public video(String comedian) {
	    	this.comedian = comedian;
	    }
	   
	 
	    public String getComedian() {
	    	return comedian;
	    }
	    
	    public void setComedian(String comedian) {
	    	this.comedian = comedian;
	    }
	    
	    public String getURL() {
	        return URL;
	    }
	    
	    public void setURL(String URL) {
	    	this.URL = URL;
	    }
	    
	    public String getTitle() {
	        return title;
	    }
	    
	    public void setTitle(String title) {
	    	this.title = title;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	    	this.description = description;
	    }
	    
	    public String getTags() {
	        return tags;
	    }
	    
	    public void setTags(String tags) {
	    	this.tags = tags;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	    	this.email = email;
	    }
	 
	    public String toString() {
	        return (this.getComedian());
	   }
	
}
