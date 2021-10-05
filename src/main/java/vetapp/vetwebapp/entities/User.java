package vetapp.vetwebapp.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Table(name="users")
@Getter
@Setter
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
	
	@Column(name="is_active" )
	private boolean isActive = false;
	
	@Column(name="created_at" )
	@CreatedDate
	private LocalDate createdAt = LocalDate.now();
	
	@Nullable
	@Column(name="longitude")
	private String longitude;
	
	@Nullable
	@Column(name="latitude")
	private String latitude;
	
}
