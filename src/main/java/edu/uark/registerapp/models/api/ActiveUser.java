package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.models.entities.ActiveUserEntity;

public class ActiveUser extends ApiResponse{
    private UUID id;
	public UUID getId() {
		return this.id;
	}
	public ActiveUser setId(final UUID id) {
		this.id = id;
		return this;
	}
    
    private String employeeid;

	public String getEmployeeId() {
		return this.employeeid;
	}

	public ActiveUser setEmployeeId(final String employeeid) {
		this.employeeid = employeeid;
		return this;
	}

    private String name;

	public String getName() {
		return this.name;
	}

	public ActiveUser setName(final String name) {
		this.name = name;
		return this;
	}

    private String classification;

	public String getClassification() {
		return this.name;
	}

	public ActiveUser setClassification(final String classification) {
		this.classification = classification;
		return this;
	}

    private String sessionkey;

	public String getSessionKey() {
		return this.sessionkey;
	}

	public ActiveUser setSessionKey(final String sessionkey) {
		this.sessionkey = sessionkey;
		return this;
	}

    private String createdOn;

	public String getCreatedOn() {
		return this.createdOn;
	}

	public ActiveUser setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public ActiveUser setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn =
			createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		return this;
	}

    public ActiveUser() {
		super();

        this.id = new UUID(0, 0);
		this.employeeid = StringUtils.EMPTY;
		this.name = StringUtils.EMPTY;;
		this.classification = StringUtils.EMPTY;;
		this.sessionkey = StringUtils.EMPTY;;

		this.setCreatedOn(LocalDateTime.now());
	}

	public ActiveUser(final ActiveUserEntity ActiveUserEntity) {
		super(false);

		this.id = ActiveUserEntity.getId();
		this.employeeid = ActiveUserEntity.getEmployeeId();
		this.name = ActiveUserEntity.getName();
		this.classification = ActiveUserEntity.getClassification();
		this.sessionkey = ActiveUserEntity.getSessionKey();


		this.setCreatedOn(ActiveUserEntity.getCreatedOn());
	}
}
