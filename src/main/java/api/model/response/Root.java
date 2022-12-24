package api.model.response;

import java.util.ArrayList;

public class Root{
    private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Integer> getContact() {
		return contact;
	}
	public void setContact(ArrayList<Integer> contact) {
		this.contact = contact;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	private String username;
    private String password;
    private ArrayList<Integer> contact;
    private ArrayList<Student> students;
}
