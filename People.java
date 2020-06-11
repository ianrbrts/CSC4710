

public class People {
    protected int id;
    protected String name;
    protected String password;
    protected String firstname;
    protected String lastname;
    protected String age;
 
    public People() {
    }
 
     
    public People(String name, String password, String firstname, String lastname, String age) {
        this.name = name;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }
    
    public People(String email, String password) {
    	this.name = email;
    	this.password = password;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
}