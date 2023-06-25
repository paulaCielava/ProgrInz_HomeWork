package lv.venta.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "trip_table")
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
	
	
	@Column(name = "StartDateTime")
	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime startDateTime;
	
	@Column(name = "Duration")
	@NotNull
	private float duration;

	public Trip(Driver tripDriver, LocalDateTime startDateTime, float duration) {
		this.tripDriver = tripDriver;
		this.startDateTime = LocalDateTime.now();
		this.duration = duration;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "Iddriver")
	private Driver tripDriver;
	
	@OneToMany(mappedBy = "ticketTrip")
	private Collection<Ticket> ticket;
	
	@ManyToMany
	@JoinTable(name = "cityTrips", joinColumns = @JoinColumn(name = "Idtrip"), inverseJoinColumns = @JoinColumn(name = "Idcity"))
	private Collection<City> cityTrips = new ArrayList<>();
	
	public void addcityTrips (City inputCity) {
		if(!cityTrips.contains(inputCity)) {
			cityTrips.add(inputCity);
		}
	}
	
	
	
	
	
}
