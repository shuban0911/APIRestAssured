package api.model.response;

/*
 * import java.util.List;
 * 
 * import com.fasterxml.jackson.annotation.JsonInclude; import
 * com.fasterxml.jackson.annotation.JsonProperty;
 * 
 * import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data;
 * import lombok.NoArgsConstructor;
 * 
 * 
 * @Data
 * 
 * @Builder
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * @JsonInclude(JsonInclude.Include.NON_NULL) public class GetEmployee {
 * 
 * @JsonProperty(value = "profile_image") public String profile_image;
 * 
 * @JsonProperty(value = "employee_age") public String employee_age;
 * 
 * @JsonProperty(value = "employee_salary") public int employee_salary;
 * 
 * @JsonProperty(value = "employee_name") public String employee_name;
 * 
 * @JsonProperty(value = "id") public int id; }
 */

public class GetEmployee{
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(int employee_salary) {
		this.employee_salary = employee_salary;
	}
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public int id;
	 public String employee_name;
	 public int employee_salary;
	 public int employee_age;
	 public String profile_image;
	}
