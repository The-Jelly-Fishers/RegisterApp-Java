
//     package edu.uark.registerapp.commands.employees;

// import java.util.LinkedList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import edu.uark.registerapp.commands.ResultCommandInterface;
// import edu.uark.registerapp.models.api.Employee;
// import edu.uark.registerapp.models.entities.EmployeeEntity;
// import edu.uark.registerapp.models.repositories.EmployeeRepository;

// @Service
// public class EmployeesQuery implements ResultCommandInterface<List<Employee>> {
// 	@Override
// 	public List<Employee> execute() {
// 		final LinkedList<Employee> employees = new LinkedList<Employee>();

// 		for (final EmployeeEntity employeeEntity : employeeRepository.findAll()) {
// 			employees.addLast(new Employee(employeeEntity)); 
// 		}
		
// 		return employees;
// 	}

// 	@Autowired
// 	EmployeeRepository employeeRepository;
// }
