package excercse;
public class Record 
{
  private long id;
  private long count;
  private String name;
  private String email;
  private String location;
   
  public Record(long id, long count, String name, 
                  String email, String location) {
    super();
    this.id = id;
    this.count = count;
    this.name = name;
    this.email = email;
    this.location = location;
  }
   
  //Getters and setters
 
  public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public long getCount() {
	return count;
}

public void setCount(long count) {
	this.count = count;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

@Override
  public String toString() {
    return "Record [id=" + id + ", count=" + count + ", name=" + name + 
                    ", email=" + email + ", location="
                    + location + "]";
  }
}