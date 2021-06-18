package io.github.sejoung.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.github.sejoung.jpa.constants.ProductType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@DiscriminatorValue(NormalProduct.DISCRIMINATOR_VALUE)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NormalProduct extends Product {
	public static final String DISCRIMINATOR_VALUE = "NORMAL";

	@Column(name = "count")
	private Integer count;

	public NormalProduct(String productName, ProductType productType, Integer count) {
		super(productName, productType);
		this.count = count;
	}
}
