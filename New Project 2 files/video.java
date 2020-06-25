
public class video {
	 	protected int id;
	    protected String URL;
	    protected String title;
	    protected String description;
	    protected String tags;
	 
	    public video() {
	    }
	 
	     
	    public video(String URL, String title, String description, String tags) {
	        this.URL = URL;
	        this.title= title;
	        this.description = description;
	        this.tags = tags;
	        
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
	 
	    public String toString() {
	        return ("URL:"+this.getURL()+
	                    " Title: "+ this.getTitle() +
	                    " Description: "+ this.getDescription() +
	                    " Tags : " + this.getTags());
	   }
	
}
