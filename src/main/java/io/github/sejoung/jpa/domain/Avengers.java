package io.github.sejoung.jpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Avengers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long avengersId;

	private String name;

	public Avengers(String name) {
		this.name = name;
	}

}
