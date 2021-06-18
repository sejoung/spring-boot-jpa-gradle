package io.github.sejoung.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import io.github.sejoung.jpa.constants.ProductType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@DiscriminatorValue(PackageProduct.DISCRIMINATOR_VALUE)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackageProduct {
	public static final String DISCRIMINATOR_VALUE = "PACKAGE";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageProductId;

	@Column(name = "odr", nullable = false)
	private Integer odr;

}
