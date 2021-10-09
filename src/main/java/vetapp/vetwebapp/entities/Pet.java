package vetapp.vetwebapp.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vetapp.vetwebapp.entities.images.PetImage;

@Entity
@Table(name="pets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","owner"})

public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="disease")
	private String disease;
	
	@Column(columnDefinition = "TEXT", name="description" )
	private String description;
	 
	@Column(name="age")
	private int age;
	
	@ManyToOne()
	@JoinColumn(name="genus_id")
	private Genus genus;


	@ManyToOne(fetch=FetchType.LAZY)  
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@OneToMany(mappedBy = "pet")
	private List<PetImage> images;
	
	
	
}
