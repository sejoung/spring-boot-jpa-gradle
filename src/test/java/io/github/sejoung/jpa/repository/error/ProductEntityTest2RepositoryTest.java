package io.github.sejoung.jpa.repository.error;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import io.github.sejoung.jpa.annotation.SejoungDataJpaTest;
import io.github.sejoung.jpa.domain.error.NewProductEntityTest2;
import io.github.sejoung.jpa.domain.error.ProductEntityTest2;
import io.github.sejoung.jpa.domain.error.ProductEntityTestMappingNewProductEntityTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SejoungDataJpaTest
class ProductEntityTest2RepositoryTest {

	@Autowired
	private ProductEntityTest2Repository repository;

	@Autowired
	private NewProductEntityTest2Repository newProductEntityTest2Repository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DisplayName("에러나옴")
	@Test
	void error() {
		var newProductEntityTest1 = newProductEntityTest2Repository.saveAndFlush(new NewProductEntityTest2("test"));
		var newProductEntityTest2 = newProductEntityTest2Repository.saveAndFlush(new NewProductEntityTest2("test2"));
		var productEntityTest = new ProductEntityTest2("123");
		productEntityTest.addMapping(
			new ProductEntityTestMappingNewProductEntityTest(productEntityTest, newProductEntityTest1));
		productEntityTest.addMapping(
			new ProductEntityTestMappingNewProductEntityTest(productEntityTest, newProductEntityTest2));
		var save = repository.saveAndFlush(productEntityTest);
		var actual = repository.findById(save.getId()).orElseThrow();
		assertThat(actual.getMappings()).hasSize(2);
	}

	@DisplayName("에러 이유 확인")
	@Test
	void seqName() {
		var actual = jdbcTemplate.queryForObject(
			"select pg_get_serial_sequence('product_entity_test_mapping_new_product_entity_test','product_entity_test_mapping_new_product_entity_test_id')",
			String.class);
		log.debug("{}", actual);
		assertThat(actual).isNotNull().isNotEmpty().isNotEqualTo(
			"product_entity_test_mapping_new_product_entity_test_product_entity_test_mapping_new_product_entity_test_id_seq");
	}
}