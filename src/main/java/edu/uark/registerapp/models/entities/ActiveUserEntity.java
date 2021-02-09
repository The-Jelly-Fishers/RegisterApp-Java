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

import edu.uark.registerapp.models.api.ActiveUser; // ????

@Entity
@Table(name="activeuser")
public class ActiveUserEntity {
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

	public ActiveUserEntity setEmployeeId(final String employeeid) {
		this.employeeid = employeeid;
		return this;
	}

	@Column(name = "name")
	private String name;

	public String getName() {
		return this.name;
	}

	public ActiveUserEntity setName(final String name) {
		this.name = name;
		return this;
	}

	@Column(name = "classification")
	private String classification;

	public String getClassification() {
		return this.name;
	}

	public ActiveUserEntity setClassification(final String classification) {
		this.classification = classification;
		return this;
	}

	@Column(name = "sessionkey")
	private String sessionkey;

	public String getSessionKey() {
		return this.sessionkey;
	}

	public ActiveUserEntity setSessionKey(final String sessionkey) {
		this.sessionkey = sessionkey;
		return this;
	}

	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public ActiveUser synchronize(final ActiveUser apiActiveUser) {
		//this.setCount(apiActiveUser.getCount());
		//this.setLookupCode(apiActiveUser.getLookupCode());

		apiActiveUser.setId(this.getId());
		apiActiveUser.setEmployeeId(this.getEmployeeId());
		apiActiveUser.setName(this.getName());
		apiActiveUser.setClassification(this.getClassification());
		apiActiveUser.setSessionKey(this.getSessionKey());

		apiActiveUser.setCreatedOn(this.getCreatedOn());

		return apiActiveUser;
	}

	public ActiveUserEntity() {
		this.id = new UUID(0, 0);
		this.employeeid = StringUtils.EMPTY;
		this.name = StringUtils.EMPTY;;
		this.classification = StringUtils.EMPTY;;
		this.sessionkey = StringUtils.EMPTY;;

		//this.lookupCode = StringUtils.EMPTY; ???? do strings this way
	}

	public ActiveUserEntity(final String employeeid, final String name, final String classification, final String sessionkey) {
		this.id = new UUID(0, 0);
		this.employeeid = employeeid;
		this.name = name;
		this.classification = classification;
		this.sessionkey = sessionkey;
	}

	public ActiveUserEntity(final ActiveUser apiActiveUser) {
    	this.id = new UUID(0, 0);
		this.employeeid = apiActiveUser.getEmployeeId();
		this.name = apiActiveUser.getName();
		this.classification = apiActiveUser.getClassification();
		this.sessionkey = apiActiveUser.getSessionKey();
	}
}
