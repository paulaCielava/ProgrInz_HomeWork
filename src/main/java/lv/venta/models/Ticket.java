package lv.venta.models;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ticket_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
	
	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Idticket")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idticket;
	
	@Column(name = "PurchaseDateTime")
	private LocalDateTime purchaseDateTime;
	
	@Column(name = "Price")
	@Positive
	private float price;
	
	//@Column(name = "Trip")
	//private String trip;
	
	@Column(name = "IsChild")
	private boolean isChild;
	
	/*
	@Column(name = "Cashier")
	private String cashier;
	*/

	public Ticket(LocalDateTime purchaseDateTime, float price, Trip ticketTrip, boolean isChild, Cashier ticketCashier) {
		this.purchaseDateTime = purchaseDateTime;
		this.price = price;
		this.ticketTrip = ticketTrip;
		this.isChild = isChild;
		this.ticketCashier = ticketCashier;
	}
	
	@ManyToOne
	@JoinColumn(name = "Idcashier")
	private Cashier ticketCashier;
	
	@ManyToOne
	@JoinColumn(name = "Idtrip")
	private Trip ticketTrip;
	
	
	
	
}
