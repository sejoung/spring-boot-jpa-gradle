package io.github.sejoung.jpa.constants;

public enum NormalProductType {

	A("A"), B("B");

	private final String value;

	NormalProductType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
