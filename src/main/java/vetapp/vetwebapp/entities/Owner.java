package vetapp.vetwebapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vetapp.vetwebapp.entities.images.OwnerImage;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy = "owner")
	private List<Pet> pets;
	
	@OneToMany(mappedBy = "owner")
	private List<OwnerImage> images;

}
