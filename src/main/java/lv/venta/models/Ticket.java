package lv.venta.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	
	@Column(name = "Trip")
	private String trip;
	
	@Column(name = "IsChild")
	private boolean isChild;
	
	@Column(name = "Cashier")
	private String cashier;

	public Ticket(LocalDateTime purchaseDateTime, String trip, boolean isChild, String cashier) {
		super();
		this.purchaseDateTime = purchaseDateTime;
		this.trip = trip;
		this.isChild = isChild;
		this.cashier = cashier;
	}
	
	
	
	
	
	
	
	
	
	
}
