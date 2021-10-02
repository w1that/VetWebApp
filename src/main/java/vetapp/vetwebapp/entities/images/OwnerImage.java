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
import vetapp.vetwebapp.entities.Owner;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="owner_images")
public class OwnerImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="created_at")
	private LocalDate createdAt = LocalDate.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private Owner owner;

}
