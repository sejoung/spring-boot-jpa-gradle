package io.github.sejoung.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sejoung.jpa.domain.Avengers;

public interface AvengersRepository extends JpaRepository<Avengers, Long> {

}
