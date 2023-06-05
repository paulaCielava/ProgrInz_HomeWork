package lv.venta.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cashier_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trip {
	
	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Idtrip")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idtrip;
	
	@Column(name = "Cities") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 100)
	private String cities;
	
	@Column(name = "Driver")
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 100)
	private String driver;
	
	@Column(name = "StartDateTime")
	@NotNull
	private LocalDateTime startDateTime;
	
	@Column(name = "Duration")
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 100)
	private String duration;

	public Trip(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String cities,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String driver,
			@NotNull LocalDateTime startDateTime,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String duration) {
		super();
		this.cities = cities;
		this.driver = driver;
		this.startDateTime = startDateTime;
		this.duration = duration;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
