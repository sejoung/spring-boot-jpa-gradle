package io.github.sejoung.jpa.domain.error;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "product_entity_test2")
public class ProductEntityTest2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productName;

	@OneToMany(mappedBy = "productEntityTest", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductEntityTestMappingNewProductEntityTest> mappings = new LinkedHashSet<>();

	public ProductEntityTest2(String productName) {
		this.productName = productName;
	}

	public void addMapping(ProductEntityTestMappingNewProductEntityTest mapping) {
		mappings.add(mapping);
	}
}
