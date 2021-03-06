package edu.uark.registerapp.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import edu.uark.registerapp.models.api.Employee; 


@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

	public UUID getId() {
		return this.id;
	}


	@Column(name = "employeeid")
	private int employeeid;

	public int getEmployeeId() {
		return this.employeeid;
	}

	public EmployeeEntity setEmployeeId(final int employeeid) {
		this.employeeid = employeeid;
		return this;
	}

	@Column(name = "firstname")
	private String firstname;

	public String getFirstName() {
		return this.firstname;
	}

	public EmployeeEntity setFirstName(final String firstname) {
		this.firstname = firstname;
		return this;
	}

    @Column(name = "lastname")
	private String lastname;

	public String getLastName() {
		return this.lastname;
	}

	public EmployeeEntity setLastName(final String lastname) {
		this.lastname = lastname;
		return this;
	}

    @Column(name = "password")
	private String password;

	public String getPassword() {
		return this.password;
	}

	public EmployeeEntity setPassword(final String password) {
		this.password = password;
		return this;
	}

    @Column(name = "active")
	private boolean active;

	public boolean getActive() {
		return this.active;
	}

	public EmployeeEntity setActive(final boolean active) {
		this.active = active;
		return this;
	}

    @Column(name = "classification")
	private int classification;

	public int getClassification() {
		return this.classification;
	}

	public EmployeeEntity setClassification(final int classification) {
		this.classification = classification;
		return this;
	}

    @Column(name = "managerid")
	private String managerid;

	public String getManagerId() {
		return this.managerid;
	}

	public EmployeeEntity setManagerId(final String managerid)
	{
		this.managerid = managerid; 
		return this; 
	}
	
	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public Employee synchronize(final Employee apiEmployee) {
        apiEmployee.setId(this.getId());
		this.setEmployeeId(apiEmployee.getEmployeeId());
        this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setPassword(apiEmployee.getPassword());
		this.setActive(apiEmployee.getActive());
		this.setClassification(apiEmployee.getClassification());
		this.setManagerId(apiEmployee.getManagerId()); 
		// apiEmployee.setManagerId(this.getManagerId()); 
		apiEmployee.setCreatedOn(this.getCreatedOn());
		return apiEmployee;
	}

	public EmployeeEntity() {
		this.id = new UUID(0, 0);
        this.employeeid = -1;
        this.firstname = StringUtils.EMPTY;
        this.lastname = StringUtils.EMPTY;
        this.password = StringUtils.EMPTY;
        this.active = false;
        this.classification = -1;
        // this.managerid = new UUID(0,0);

	}

	public EmployeeEntity(final int employeeid, final String firstname, final String lastname, final String password, final boolean active, final int classification, final String managerid) {
		this.id = new UUID(0, 0);
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.active = active;
        this.classification = classification;
        this.managerid = managerid;
        
	}

	public EmployeeEntity(final Employee apiEmployee) {
        this.id = new UUID(0, 0);
		this.employeeid = apiEmployee.getEmployeeId();
        this.firstname = apiEmployee.getFirstName();
        this.lastname = apiEmployee.getLastName();
        this.password = apiEmployee.getPassword();
        this.active = apiEmployee.getActive();
        this.classification = apiEmployee.getClassification();
        this.managerid = apiEmployee.getManagerId(); 
	}
}



