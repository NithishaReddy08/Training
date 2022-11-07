package com.event.Training.Model;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.type.DateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TrainingDetails")
public class TrainingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Column(name="Training_Name")
  //  @NotBlank(message = "Training_Name should not be blank")
	private String Training_Name;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Column(name="Description")
	// @NotBlank(message = "Description should not be blank") 
	private String Description;
	@Column(name="Duration")
	//@NotEmpty
	private String Duration;
	@Column(name="Mode")
	@NotBlank(message = "mode  should not be blank")
	private String Mode;
	@Column(name="From_Date")
	//@NotBlank(message = "date  should not be blank")
	private String From_Date ;
	@Column(name="To_Date")
	//@NotBlank(message = "date  should not be blank")
	private String  To_Date;
	@Column(name="Trainer")
	//@NotBlank(message = "Trainer  should not be blank")
	private String Trainer;
	@Column(name="Offering_Dept")
	//@NotBlank(message = "Offering_Dept.  should not be blank")
	private String Offering_Dept;
	public String getTraining_Name() {
		return Training_Name;
	}
	public void setTraining_Name(String training_Name) {
		Training_Name = training_Name;
	}
	
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	public String getFrom_Date() {
		return From_Date;
	}
	public void setFrom_Date(String from_Date) {
		From_Date = from_Date;
	}
	public String getTo_Date() {
		return To_Date;
	}
	public void setTo_Date(String to_Date) {
		To_Date = to_Date;
	}
	public String getTrainer() {
		return Trainer;
	}
	public void setTrainer(String trainer) {
		Trainer = trainer;
	}
	public String getOffering_Dept() {
		return Offering_Dept;
	}
	public void setOffering_Dept(String offering_Dept) {
		Offering_Dept = offering_Dept;
	}
	
}