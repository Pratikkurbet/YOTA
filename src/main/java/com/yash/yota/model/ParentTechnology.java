package com.yash.yota.model;
/*
 * This Parent Technology model is define what a technology consist of and useful for request which client side will send.
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParentTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Validation for Parent Technology Name
	@NotBlank(message = "Parent Technology Name should not be empty!")
	private String name;
	
	//Validation for Parent Technology Description
	@NotBlank(message = "Description is required.")
	private String shortDescription;
	
	private boolean status;
	
	//Validation for Parent Technology Creation Date
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date createdAt;
	
	//Validation for Parent Technology Updation Date
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date updatedAt;

	//@PrePersist means method will be called before the entity is inserted (persisted) into the database.
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}

	//@PreUpdate means method will be called before the entity is Updated in the database.
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
}
