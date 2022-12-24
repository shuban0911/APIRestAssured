package api.model.response;

import java.util.ArrayList;

public class Student{
	
    private int id;
    private String name;
    private ArrayList<Integer> marks;
    private ArrayList<String> contact;
    private ArrayList<Address> adresss;
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
	public ArrayList<Integer> getMarks() {
		return marks;
	}
	public void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}
	public ArrayList<String> getContact() {
		return contact;
	}
	public void setContact(ArrayList<String> contact) {
		this.contact = contact;
	}
	public ArrayList<Address> getAdresss() {
		return adresss;
	}
	public void setAdresss(ArrayList<Address> adresss) {
		this.adresss = adresss;
	}
}
