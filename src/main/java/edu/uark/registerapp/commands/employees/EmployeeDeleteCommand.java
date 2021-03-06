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
public class EmployeeDeleteCommand implements VoidCommandInterface {
	@Transactional
	@Override
	public void execute() {
		final Optional<EmployeeEntity> employeeEntity =
			this.employeeRepository.findByEmployeeid(this.employeeId);
		if (!employeeEntity.isPresent()) { // No record with the associated record ID exists in the database.
			throw new NotFoundException("employee");
		}

		this.employeeRepository.delete(employeeEntity.get());
	}

	// Properties
	private int employeeId;
	public int getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeDeleteCommand setEmployeeId(final int employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
}
