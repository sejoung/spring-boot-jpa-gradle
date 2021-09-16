package io.github.sejoung.jpa.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.jdbc.core.JdbcTemplate;

import io.github.sejoung.jpa.annotation.SejoungDataJpaTest;
import io.github.sejoung.jpa.domain.IronManAndCaptainAmericaAndHulkAndThor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SejoungDataJpaTest
class IronManAndCaptainAmericaAndHulkAndThorRepositoryTest {

	@Autowired
	private IronManAndCaptainAmericaAndHulkAndThorRepository repository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DisplayName("에러남")
	@Test
	void error() {
		var actual = assertThrows(
			InvalidDataAccessResourceUsageException.class,
			() -> repository.save(new IronManAndCaptainAmericaAndHulkAndThor("아이언맨")));
		assertThat(actual.getMessage()).isEqualTo(
			"could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet");
	}

	@DisplayName("에러 이유 확인")
	@Test
	void seqName() {
		var actual = jdbcTemplate.queryForObject(
			"select pg_get_serial_sequence('iron_man_and_captain_america_and_hulk_and_thor','iron_man_and_captain_america_and_hulk_and_thor_id')",
			String.class);
		log.debug("{}", actual);
		assertThat(actual).isEqualTo(
			"public.iron_man_and_captain_america_and_hulk_and_thor_iron_man_and_captain_america_and_hulk_and_thor_id_seq");
	}
}