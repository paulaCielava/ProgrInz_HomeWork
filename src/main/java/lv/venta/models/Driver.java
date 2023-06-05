package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "driver_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Driver extends Person{
	
	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Iddriver")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iddriver;
	
	@Column(name = "Categorie")
	private Buscategory categorie;
	

	public Driver(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String name,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String surname,
			Buscategory categorie) {
		super(name, surname);
		this.categorie = categorie;
	}
	
	
	@OneToMany(mappedBy = "tripDriver")
	private Collection<Trip> trip;
	
	
	
	
	
	
	
	
	
	
	
}
