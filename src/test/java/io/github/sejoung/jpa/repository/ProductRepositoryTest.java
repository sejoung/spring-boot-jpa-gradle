package io.github.sejoung.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import io.github.sejoung.jpa.annotation.SejoungDataJpaTest;
import io.github.sejoung.jpa.constants.ProductType;
import io.github.sejoung.jpa.domain.NormalProduct;
import io.github.sejoung.jpa.domain.PackageProduct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SejoungDataJpaTest
class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void findTest() {
		var normalProduct = new NormalProduct("일반상품", ProductType.NORMAL, 1);
		entityManager.persistAndFlush(normalProduct);
		var packageProduct = new PackageProduct("패키지상품", ProductType.PACKAGE, 2);
		entityManager.persistAndFlush(packageProduct);

		var list = repository.findAll();

		list.forEach(product -> log.debug("{}", product));

	}
}