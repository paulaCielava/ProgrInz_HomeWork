package lv.venta.models;

import jakarta.persistence.AttributeOverride;
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
public class Cashier extends Person{

	@Setter(value = AccessLevel.NONE) 
	@Column(name = "Idcashier")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idcashier;

	
	
	public Cashier(
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String name,
			@NotNull @Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+") @Size(min = 3, max = 100) String surname) {
		super(name, surname);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
