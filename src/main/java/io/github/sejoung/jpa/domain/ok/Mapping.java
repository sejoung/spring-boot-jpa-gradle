package io.github.sejoung.jpa.domain.ok;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Mapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private ProductEntityTest productEntityTest;

	@OneToOne
	private NewProductEntityTest newProductEntityTest;

	public Mapping(NewProductEntityTest newProductEntityTest, ProductEntityTest productEntityTest) {
		this.newProductEntityTest = newProductEntityTest;
		this.productEntityTest = productEntityTest;
	}
}
