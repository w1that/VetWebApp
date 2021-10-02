package vetapp.vetwebapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vets")
public class Vet extends User {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name="clinic_name")
	private String clinicName;
	
	@Column(name="stars")
	private int stars;
	
	@Column(name="home_service")
	private boolean homeService;
	
}
