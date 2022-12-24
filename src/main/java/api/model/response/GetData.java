package api.model.response;

import java.util.ArrayList;

/*
 * import java.util.List;
 * 
 * import com.fasterxml.jackson.annotation.JsonInclude; import
 * com.fasterxml.jackson.annotation.JsonProperty;
 * 
 * import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data;
 * import lombok.NoArgsConstructor;
 * 
 * @Data
 * 
 * @Builder
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * @JsonInclude(JsonInclude.Include.NON_NULL) public class GetData{
 * 
 * @JsonProperty(value = "status") public String status;
 * 
 * @JsonProperty(value = "message") public String message;
 * 
 * @JsonProperty(value = "data") public List<GetEmployee> employees;
 * 
 * }
 */

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


public class GetData{
 public String status;
 public ArrayList<GetEmployee> data;
 public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<GetEmployee> getData() {
	return data;
}
public void setData(ArrayList<GetEmployee> data) {
	this.data = data;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String message;
}

