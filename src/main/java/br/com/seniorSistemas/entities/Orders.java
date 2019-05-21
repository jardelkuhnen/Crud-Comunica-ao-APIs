package br.com.seniorSistemas.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@JoinColumn(name = "client_id", referencedColumnName = "id")
//	@Fetch(FetchMode.SELECT)
//	@ManyToOne()
	@Column(name = "client_id", nullable = false)
	private Long clientId;
//
//	@Column(name = "provider_id")
//	private Long providerId;
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<ItemOrder> itensOrder;

}
