
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
	    
	   
	 
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	
}
