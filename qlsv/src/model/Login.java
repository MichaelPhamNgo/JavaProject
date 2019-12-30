package model;

public class Login {

	private String User;
	private String Id;
	private String Hello;
	public String getUser() {
		return User;
	}
	public String getId() {
		return Id;
	}
	public String getHello() {
		return Hello;
	}
	public Login(String user, String id, String hello) {
		super();
		User = user;
		Id = id;
		Hello = hello;
	}

}
