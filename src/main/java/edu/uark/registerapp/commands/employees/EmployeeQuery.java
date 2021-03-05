package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class EmployeeQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		final Optional<EmployeeEntity> employeeEntity =
			this.employeeRepository.findByEmployeeid(this.employeeId);
		if (employeeEntity.isPresent()) {
			return new Employee(employeeEntity.get());
		} else {
			throw new NotFoundException("Employee");
		}
	}

	// Properties
	private int employeeId;
	public int getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeQuery setEmployeeId(final int employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public int findClassification(int empID)
	{
		int classification = 0; 
		final Optional<EmployeeEntity> employeeEntity =
			this.employeeRepository.findByEmployeeid(empID); 

		final Optional<EmployeeEntity> employeeEntity2 = 
			this.employeeRepository.findByClassification(1); 

		final Optional<EmployeeEntity> employeeEntity3 = 
			this.employeeRepository.findByClassification(2); 

		if (employeeEntity.isPresent() && employeeEntity2.isPresent())
		{
			classification = 1; 
		}

		if (employeeEntity.isPresent() && employeeEntity3.isPresent())
		{
			classification = 2; 
		}
		return classification; 
	}

	@Autowired
	private EmployeeRepository employeeRepository;
}
