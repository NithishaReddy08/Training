package com.event.Training.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.type.DateType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Registration_info")
public class RegistrationDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	@Column(name="FirstName")
    @NotBlank(message = "FirstName should not be blank")
    @Size(min = 3,message = "FirstName should be at least 3 chars")
	private String FirstName;
	@Column(name="LastName")
    @NotBlank(message = "LastName should not be blank")
    @Size(min = 3,message = "LastName should be at least 3 chars")
	private String LastName;
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	@Column(name="Mobile")
	@NotBlank(message = "mobile_no  should not be blank")
    @Size(min = 10,message = "mobile_no should be at least 10 chars")
	private String Mobile;
	@Column(name="Training_Name")
	@NotEmpty
	private String Training_Name;
	@Column(name="Mode")
	@NotBlank(message = "mode  should not be blank")
	private String Mode;
	@Column(name="Description")
	@NotBlank(message = "Desceription  should not be blank")
	private String Description;
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Column(name="Date")
	@NotBlank(message = "date  should not be blank")
	private  String Date ;
	
		public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String getTraining_Name() {
		return Training_Name;
	}
	public void setTraining_Name(String training_Name) {
		Training_Name = training_Name;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
