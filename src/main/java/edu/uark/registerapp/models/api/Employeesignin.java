package edu.uark.registerapp.models.api;

public class Employeesignin extends ApiResponse {
    Employee e = new Employee();
    String empolyeeId = e.getEmployeeId();
    String password = e.getPassword();
}
