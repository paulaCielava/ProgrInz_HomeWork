package lv.venta.models;


import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "city_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {
	
	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Idcity")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idcity;
	
	@Column(name = "Title") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 100)
	private String title;
	
	@Column(name = "AddressOfStation") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 1000)
	private String addressOfStation;

	public City(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String title,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String addressOfStation) {
		super();
		this.title = title;
		this.addressOfStation = addressOfStation;
	}
	
	
	@ManyToMany
	@JoinTable(name = "cityTrips", joinColumns = @JoinColumn(name = "Idcity"), inverseJoinColumns = @JoinColumn(name = "Idtrip"))
	private Collection<Trip> trip = new ArrayList<>();
	
	public void addTrip (Trip inputTrip) {
		if(!trip.contains(inputTrip)) {
			trip.add(inputTrip);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
