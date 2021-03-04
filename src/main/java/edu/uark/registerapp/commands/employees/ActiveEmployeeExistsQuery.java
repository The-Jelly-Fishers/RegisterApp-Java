package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class ActiveEmployeeExistsQuery implements VoidCommandInterface {
	@Transactional
	@Override
	public void execute() {
		boolean activeUserPresent = this.employeeRepository.existsByActive("active"); 
		if (activeUserPresent == false) { // No record with the associated record ID exists in the database.
			System.out.println("no active users right now"); 
			// throw new NotFoundException("employee");
		}
	}

	// private UUID employeeId;
	// public UUID getEmployeeId() {
	// 	return this.employeeId;
	// }
	// public ActiveEmployeeExistsQuery setEmployeeId(final UUID employeeId) {
	// 	this.employeeId = employeeId;
	// 	return this;
	// }
	
	@Autowired
	private EmployeeRepository employeeRepository;
}
