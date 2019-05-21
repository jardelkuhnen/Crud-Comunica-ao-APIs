package br.com.seniorSistemas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "itens_order")
public class ItemOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@JoinColumn(name = "product_id", referencedColumnName = "id")
//	@Column(name = "product_id")
	@JoinColumn(name = "product_id")
	@Fetch(FetchMode.SELECT)
	@OneToOne()
	private Product product;

	@ManyToOne()
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
//	@Column(name = "order_id")
	private Orders order;

}
