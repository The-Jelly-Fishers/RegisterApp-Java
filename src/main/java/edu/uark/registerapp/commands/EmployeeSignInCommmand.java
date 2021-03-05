package edu.uark.registerapp.commands;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.exceptions.ConflictException;
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
public class EmployeeSignInCommmand implements ResultCommandInterface<ActiveUser> {
	// private Object apiEmployee;
	@Override
	public ActiveUser execute() {
		System.out.println("1 trying to find where error is"); 
		// this.validateProperties();
		return new ActiveUser(this.Employeesignin());
	}

	// Helper Methods
	private void validateProperties() {

		// if (this.employeeSignIn.getEmployeeID() == -1) {
		// 	throw new UnprocessableEntityException("Employee Id");
		// }
		// try {
		// 	this.employeeSignIn.getEmployeeId();
		// } catch (final NumberFormatException e) {
		// 	throw new UnprocessableEntityException("Employee Id");
		// }
		// if (StringUtils.isBlank(this.employeeSignIn.getPassword())) {
		// 	throw new UnprocessableEntityException("Password");
		// }
		// this.employeeRepository.findByEmployeeid(this.employeeId);
	}

	// Properties
	// private int employeeId;
	// private Employeesignin employeeSignIn;
	// private Employee employee; 

	// @Autowired
	// private EmployeeRepository employeeRepository;
	@Autowired
	private ActiveUserRepository activeUserRepository;

	// public int getEmployeeSignIn() {
	// 	return this.employeeSignIn;
	// }

	// public EmployeeSignInCommmand setEmployeeSignIn(final Employeesignin employeeSignIn) {
	// 	this.employeeSignIn = employeeSignIn;
	// 	return this;
	// }

	// private String sessionId;

	// public String getSessionId() {
	// 	return this.sessionId;
	// }

	// public EmployeeSignInCommmand setSessionId(final String sessionId) {
	// 	this.sessionId = sessionId;
	// 	return this;
	// }

	private ActiveUser apiActive;
	public ActiveUser getApiActiveUser() 
	{
		System.out.println("2 trying to find where error is"); 
		return this.apiActive;
	}
	public EmployeeSignInCommmand setApiActiveUser(final ActiveUser apiActive) {
		System.out.println("3 trying to find where error is"); 
		this.apiActive = apiActive;
		return this; 
	}

	@Transactional
	private ActiveUserEntity Employeesignin() {
		// final Optional<EmployeeEntity> employeeEntity = this.employeeRepository
		// 		.findById(employee.getId());

		// // !Arrays.equals(this.employee.getPassword(), this.employeeSignIn.getPassword())
		// if (!employeeEntity.isPresent() || !(this.employee.getPassword().equals(this.employeeSignIn.getPassword()))) /*, // employeeEntity password = repos. password
		// 		EmployeeQuery.hashPassword(this.employeeSignIn.getPassword())))*/ {
		// 	// Lookupcode already defined for another employee.
		// 	// throw new ConflictException("lookupcode");
		// 	throw new UnauthorizedException();

		// }
		System.out.println("4 trying to find where error is"); 
		final Optional<ActiveUserEntity> activeUserEntity = this.activeUserRepository.findByEmployeeid(this.apiActive.getEmployeeId());
				System.out.println("5 trying to find where error is"); 
		if (activeUserEntity.isPresent()) {
			System.out.println("6 trying to find where error is"); 
			throw new ConflictException("alreadyActiveUser"); 
		}
		System.out.println("7 trying to find where error is"); 
	return this.activeUserRepository.save(new ActiveUserEntity(apiActive));
}
}






