package io.github.sejoung.jpa.constants;

import io.github.sejoung.jpa.domain.NormalProduct;
import io.github.sejoung.jpa.domain.PackageProduct;

public enum ProductType {
	PACKAGE(PackageProduct.DISCRIMINATOR_VALUE), NORMAL(NormalProduct.DISCRIMINATOR_VALUE);

	private final String value;

	ProductType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
