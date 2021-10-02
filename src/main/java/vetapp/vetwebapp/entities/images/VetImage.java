package vetapp.vetwebapp.entities.images;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vetapp.vetwebapp.entities.Pet;
import vetapp.vetwebapp.entities.Vet;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vet_images")
public class VetImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="created_at")
	private LocalDate createdAt = LocalDate.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vet_id")
	@JsonIgnore
	private Vet vet;

}