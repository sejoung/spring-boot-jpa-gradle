package io.github.sejoung.jpa.domain.error;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProductEntityTestMappingNewProductEntityTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productEntityTestMappingNewProductEntityTestId;

	@ManyToOne
	private ProductEntityTest2 productEntityTest;

	@OneToOne
	private NewProductEntityTest2 newProductEntityTest;

	public ProductEntityTestMappingNewProductEntityTest(
		ProductEntityTest2 productEntityTest, NewProductEntityTest2 newProductEntityTest) {
		this.productEntityTest = productEntityTest;
		this.newProductEntityTest = newProductEntityTest;
	}
}
