package io.github.sejoung.jpa.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.sejoung.jpa.annotation.SejoungDataJpaTest;
import io.github.sejoung.jpa.domain.Avengers;

@SejoungDataJpaTest
class AvengersRepositoryTest {

	@Autowired
	private AvengersRepository repository;

	@Test
	void saveTest() {
		var actual = repository.save(new Avengers("아이언맨"));
		assertThat(actual.getAvengersId()).isNotNull();
	}
}