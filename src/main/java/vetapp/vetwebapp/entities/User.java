package vetapp.vetwebapp.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Data;


@MappedSuperclass
@Table(name="users")
@JsonIgnoreProperties("id")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="username")
	private String username;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="address")
	private String address;
	
	@Column(name="is_active" )
	private boolean isActive = false;
	
	@Column(name="created_at" )
	@CreatedDate
	private LocalDate createdAt = LocalDate.now();
	
	
}
