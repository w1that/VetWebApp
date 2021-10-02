package vetapp.vetwebapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vetapp.vetwebapp.entities.images.PetImage;

@Entity
@Table(name="pets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="disease")
	private String disease;
	
	@Column(name="age")
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genus_id", referencedColumnName = "id")
	private Genus genus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private Owner owner;
	
	@OneToMany(mappedBy = "pet")
	private List<PetImage> images;
	
}
