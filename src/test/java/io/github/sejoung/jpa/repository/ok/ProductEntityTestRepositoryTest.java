package io.github.sejoung.jpa.repository.ok;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.sejoung.jpa.annotation.SejoungDataJpaTest;
import io.github.sejoung.jpa.domain.ok.Mapping;
import io.github.sejoung.jpa.domain.ok.NewProductEntityTest;
import io.github.sejoung.jpa.domain.ok.ProductEntityTest;
import io.github.sejoung.jpa.repository.ok.NewProductEntityTestRepository;
import io.github.sejoung.jpa.repository.ok.ProductEntityTestRepository;

@SejoungDataJpaTest
class ProductEntityTestRepositoryTest {
	@Autowired
	private ProductEntityTestRepository repository;

	@Autowired
	private NewProductEntityTestRepository newProductEntityTestRepository;

	@Test
	void name() {

		var newProductEntityTest1 = newProductEntityTestRepository.saveAndFlush(new NewProductEntityTest("test"));
		var newProductEntityTest2 = newProductEntityTestRepository.saveAndFlush(new NewProductEntityTest("test2"));
		var productEntityTest = new ProductEntityTest("123");
		productEntityTest.addMapping(new Mapping(newProductEntityTest1, productEntityTest));
		productEntityTest.addMapping(new Mapping(newProductEntityTest2, productEntityTest));
		var save = repository.saveAndFlush(productEntityTest);
		var actual = repository.findById(save.getId()).orElseThrow();
		assertThat(actual.getMappings()).hasSize(2);
	}
}