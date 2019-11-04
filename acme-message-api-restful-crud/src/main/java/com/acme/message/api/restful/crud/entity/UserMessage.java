package com.acme.message.api.restful.crud.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usermessage")
public class UserMessage implements Serializable {

	private static final long serialVersionUID = -6242095987088758384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "vip")
	private boolean vip;

	
	@Column(name = "creationdate")
	private Date creationDate;
	
	@Column(name = "deleteddate")
	private Date deletedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
	
	@Override
    public String toString() {
        return "UserMessage{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", vip='" + vip + '\'' +
                ", creationDate=" + creationDate +
                ", deletedDate='" + deletedDate + '\'' +
                '}';
    }
	
}
