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

@ToString(callSuper = true)
@DiscriminatorValue(PackageProduct.DISCRIMINATOR_VALUE)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackageProduct extends Product {
	public static final String DISCRIMINATOR_VALUE = "PACKAGE";

	@Column(name = "odr", nullable = false)
	private Integer odr;

	public PackageProduct(String productName, ProductType productType, Integer odr) {
		super(productName, productType);
		this.odr = odr;
	}
}
