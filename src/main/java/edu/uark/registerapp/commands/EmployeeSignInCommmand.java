package edu.uark.registerapp.commands;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.exceptions.UnauthorizedException;
//import edu.uark.registerapp.commands.ResultCommandInterface;
//import edu.uark.registerapp.commands.exceptions.ConflictException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.commands.employees.EmployeeQuery;
import edu.uark.registerapp.models.api.ActiveUser;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.Employeesignin;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class EmployeeSignInCommmand implements ResultCommandInterface<Employee> {
	// private Object apiEmployee;
	@Override
	public Employee execute() {
		this.validateProperties();
		return new Employee(this.Employeesignin());
	}

	// Helper Methods
	private void validateProperties() {

		if (this.employeeSignIn.getEmployeeID() == -1) {
			throw new UnprocessableEntityException("Employee Id");
		}
		try {
			this.employeeSignIn.getEmployeeId();
		} catch (final NumberFormatException e) {
			throw new UnprocessableEntityException("Employee Id");
		}
		if (StringUtils.isBlank(this.employeeSignIn.getPassword())) {
			throw new UnprocessableEntityException("Password");
		}
		this.employeeRepository.findByEmployeeid(this.employeeId);
	}

	// Properties
	private int employeeId;
	private Employeesignin employeeSignIn;
	private Employee employee; 

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ActiveUserRepository activeUserRepository;

	public Employeesignin getEmployeeSignIn() {
		return this.employeeSignIn;
	}

	public EmployeeSignInCommmand setEmployeeSignIn(final Employeesignin employeeSignIn) {
		this.employeeSignIn = employeeSignIn;
		return this;
	}

	private String sessionId;
	private Employee apiEmployee;

	public String getSessionId() {
		return this.sessionId;
	}

	public EmployeeSignInCommmand setSessionId(final String sessionId) {
		this.sessionId = sessionId;
		return this;
	}

	@Transactional
	private EmployeeEntity Employeesignin() {
		final Optional<EmployeeEntity> employeeEntity = this.employeeRepository
				.findById(employee.getId());

		// !Arrays.equals(this.employee.getPassword(), this.employeeSignIn.getPassword())
		if (!employeeEntity.isPresent() || !(this.employee.getPassword().equals(this.employeeSignIn.getPassword()))) /*, // employeeEntity password = repos. password
				EmployeeQuery.hashPassword(this.employeeSignIn.getPassword())))*/ {
			// Lookupcode already defined for another employee.
			// throw new ConflictException("lookupcode");
			throw new UnauthorizedException();

		}

		final Optional<ActiveUserEntity> activeUserEntity = (this.activeUserRepository)
				.findByEmployeeid(this.apiEmployee.getEmployeeId());

		if (!activeUserEntity.isPresent()) {
			(this.activeUserRepository).save(new ActiveUserEntity()).setSessionKey(this.sessionId);
			((Employee) this.apiEmployee).getFirstName();
			((Employee) this.apiEmployee).getLastName();
			((Employee) this.apiEmployee).getId();
			((Employee) this.apiEmployee).getClassification();

			// .findByEmployeeId(employeeEntity.get().getId())
			// .setClassification(employeeEntity.get().getClassification())
			// .setName(employeeEntity.get().getFirstName()
			// .concat(" ")
			// .concat(employeeEntity.get().getLastName()));
		} else {
			(this.activeUserRepository).save(activeUserEntity.get().setSessionKey(this.sessionId));

    }
	return employeeEntity.get();
	
 		

}
}






