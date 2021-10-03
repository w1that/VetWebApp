package vetapp.vetwebapp.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetapp.vetwebapp.entities.images.VetImage;

@Entity
@Getter
@Setter
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
	
    @OneToMany(mappedBy = "vet")
	private List<VetImage> vetImages;
    
}
