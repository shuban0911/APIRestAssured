package api.model.response;

public class EmployeeWithId {
	    private String status;
	    private GetEmployee data;
	    private String message;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public GetEmployee getData() {
			return data;
		}
		public void setData(GetEmployee data) {
			this.data = data;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
}
