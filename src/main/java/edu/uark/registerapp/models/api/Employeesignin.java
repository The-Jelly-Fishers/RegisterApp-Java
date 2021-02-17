package edu.uark.registerapp.models.api;

public class Employeesignin extends ApiResponse {
    Employee e = new Employee();
    String employeeID = e.getEmployeeId();
    String password = e.getPassword();
}
