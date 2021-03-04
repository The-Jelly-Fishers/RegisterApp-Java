package edu.uark.registerapp.models.api;

public class Employeesignin extends ApiResponse {
    Employee e = new Employee();
    int employeeID = e.getEmployeeId();
    String password = e.getPassword();
	public int getEmployeeId() {
		return this.employeeID;
	}
	public int getEmployeeID() {
		return this.employeeID;
	}
	public String getPassword() {
		return this.password;
	}
}
