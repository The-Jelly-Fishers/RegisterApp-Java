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

import edu.uark.registerapp.models.api.Product; //should this be employee ???


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
	private String employeeid;

	public String getEmployeeId() {
		return this.employeeid;
	}

	public EmployeeEntity setEmployeeId(final String employeeid) {
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
	private String active;

	public String getActive() {
		return this.active;
	}

	public EmployeeEntity setActive(final String active) {
		this.active = active;
		return this;
	}

    @Column(name = "classification")
	private String classification;

	public String getClassification() {
		return this.classification;
	}

	public EmployeeEntity setClassification(final String classification) {
		this.classification = classification;
		return this;
	}

    @Column(name = "managerid")
	private int managerid;

	public int getManagerId() {
		return this.managerid;
	}

	public EmployeeEntity setManagerId(final int managerid) {
		this.managerid = managerid;
		return this;
	}
    
	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public Product synchronize(final Product apiProduct) {
        apiProduct.setId(this.getId());
		this.setEmployeeId(apiProduct.getEmployeeId());
        this.setFirstName(apiProduct.getFirstName());
		this.setLastName(apiProduct.getLastName());
		this.setPassword(apiProduct.getPassword());
		this.setActive(apiProduct.getActive());
		this.setClassification(apiProduct.getClassification());
		apiProduct.setCreatedOn(this.getCreatedOn());
		return apiProduct;
	}

	public EmployeeEntity() {
		this.id = new UUID(0, 0);
        this.employeeid = "";
        this.firstname = "";
        this.lastname = "";
        this.password = "";
        this.active = "";
        this.classification = "";
        this.managerid = -1;

	}

	public EmployeeEntity(final String employeeid, final String firstname, final String lastname, final String password, final String active, final String classification, final int managerid) {
		this.id = new UUID(0, 0);
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.active = active;
        this.classification = classification;
        this.managerid = managerid;
        
	}

	public EmployeeEntity(final Product apiProduct) {
        this.id = new UUID(0, 0);
		this.employeeid = apiProduct.getEmployeeId();
        this.firstname = apiProduct.getFirstName();
        this.lastname = apiProduct.getLastName();
        this.password = apiProduct.getPassword();
        this.active = apiProduct.getActive();
        this.classification = apiProduct.getClassification();
        this.managerid = apiProduct.getManagerId();
	}
}



