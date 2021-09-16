package io.github.sejoung.jpa.domain;

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
public class IronManAndCaptainAmericaAndHulkAndThor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ironManAndCaptainAmericaAndHulkAndThorId;

	private String name;

	public IronManAndCaptainAmericaAndHulkAndThor(String name) {
		this.name = name;
	}
}
