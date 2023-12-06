package Person;

public class Person {
	
	private String userName;
	private String password;
	private String email;
	
	//Constructor for Person Object - A User of the program
	
	public Person(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	public Person(String userName, String password, String email)
	{
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	// Getters for the private attributes of Person
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	// Setters for the private attributes of Person
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

}

