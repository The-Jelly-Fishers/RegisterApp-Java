package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.models.entities.EmployeeEntity;

public class Employee extends ApiResponse {
	public static Object employee;
	private UUID id;
	public UUID getId() {
		return this.id;
	}

    public Employee setId(final UUID id) {
		this.id = id;
		return this;
	}

	private int employeeid;

	public  int getEmployeeId() {
		return this.employeeid;
	}

	public Employee setEmployeeId(final int employeeid) {
		this.employeeid = employeeid;
		return this;
	}

	private String firstname;

	public String getFirstName() {
		return this.firstname;
	}

	public Employee setFirstName(final String firstname) {
		this.firstname = firstname;
		return this;
	}

	private String lastname;

	public String getLastName() {
		return this.lastname;
	}

	public Employee setLastName(final String lastname) {
		this.lastname = lastname;
		return this;
	}

	private String password;

	public String getPassword() {
		return this.password;
	}

	public Employee setPassword(final String password) {
		this.password = password;
		return this;
	}

	private boolean active;

	public boolean getActive() {
		return this.active;
	}

	public Employee setActive(final boolean active) {
		this.active = active;
		return this;
	}

	private int classification;

	public int getClassification() {
		return this.classification;
	}

	public Employee setClassification(final int classification) {
		this.classification = classification;
		return this;
	}

	private String managerid;

	public String getManagerId() {
		return this.managerid;
	}

	public Employee setManagerId(final String managerid) {
		this.managerid = managerid;
		return this;
	}
    
	private String createdOn;

	public String getCreatedOn() {
		return this.createdOn;
	}

	public Employee setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Employee setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn =
			createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return this;
	}

	public Employee() {
		super();

        this.id = new UUID(0, 0);
        this.employeeid = -1;
        this.firstname = StringUtils.EMPTY;
        this.lastname = StringUtils.EMPTY;
        this.password = StringUtils.EMPTY;
        this.active = false;
        this.classification = -1;
        this.managerid = StringUtils.EMPTY; 
        this.setCreatedOn(LocalDateTime.now());
	}

	public Employee(final EmployeeEntity employeeEntity) {
		super(false);

        this.id = new UUID(0, 0);
		this.employeeid = employeeEntity.getEmployeeId();
        this.firstname = employeeEntity.getFirstName();
        this.lastname = employeeEntity.getLastName();
        this.password = employeeEntity.getPassword();
        this.active = employeeEntity.getActive();
        this.classification = employeeEntity.getClassification();
        this.managerid = employeeEntity.getManagerId(); 

		this.setCreatedOn(employeeEntity.getCreatedOn());
	}
}
