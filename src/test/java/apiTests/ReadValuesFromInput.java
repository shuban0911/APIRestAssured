package apiTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.response.Address;
import api.model.response.Root;
import api.model.response.Student;




public class ReadValuesFromInput {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		
		File file = new File("JSON/input.json");
		
		try {
			List<Student> students = null;
			ObjectMapper objectMapper = new ObjectMapper();
			List<Root> rootList = objectMapper.readValue(file, new TypeReference<List<Root>>(){});
			
			System.out.println(rootList.size());
			System.out.println(rootList.get(1).getUsername());
			
			//total number of students
			
			int numOfStudent = 0;
			//name of university 
			for(Root root:rootList) {
			System.out.println(root.getName());
			students = root.getStudents();
			numOfStudent = numOfStudent+students.size();
			
			}
			//mark of first student
			ArrayList<Integer> marks  = rootList.get(0).getStudents().get(1).getMarks();
			for(Integer mark :marks) {
				System.out.println(mark);
			}
			
			//total number of students
			
			System.out.println(numOfStudent);
			//contacts of all students
			for(Student student :students) {
				System.out.println(student.getName());
				ArrayList<String> contacts = student.getContact();
				for(String contact : contacts) {
					System.out.println(contact);
				}
			}
			
		//find all cities of second student of 2nd university
			
			List<Student> students2 = rootList.get(1).getStudents();
			System.out.println(students2.size());
			
			Student studNo2 = students2.get(1);	
						
			List<Address> add = studNo2.getAdresss();
			
			for(Address addr : add) {
				System.out.println(addr.getCity());
			}
				
				//names of all students
				
				List<Student> students1 = rootList.get(1).getStudents();
				for(Student stud :rootList.get(0).getStudents()) {
					System.out.println(stud.getName());
				}
				for(Student stud :students1) {
					System.out.println(stud.getName());
				}
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
