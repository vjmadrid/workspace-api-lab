package com.acme.message.api.restful.crud.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.acme.message.api.restful.crud.validator.annotation.UserMessageIdExisting;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "usermessage")
public class UserMessage extends AbstractEntity {


	private static final long serialVersionUID = -5296552955771109028L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@UserMessageIdExisting
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "vip")
	private boolean vip;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")	
	@Column(name = "creationdate")
	private Date creationDate;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
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
	public boolean equals(Object object) {
		
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserMessage)) {
			return false;
		}
		
		final UserMessage other = (UserMessage)object;

		return new EqualsBuilder().append(getId(), other.getId())
				.append(getDescription(), other.getDescription())
				.append(isVip(), other.isVip())
				.append(getCreationDate(), other.getCreationDate())
				.append(getDeletedDate(), other.getDeletedDate())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getDescription()).append(isVip()).append(getCreationDate()).append(getDeletedDate()).toHashCode();
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
	            .append("id", id)
	            .append("description", description)
	            .append("vip", vip)
	            .append("creationDate", (creationDate==null?null:dateFormat.format(creationDate)))
	            .append("deletedDate", (deletedDate==null?null:dateFormat.format(deletedDate)))
	            .toString();
	}
	
}
