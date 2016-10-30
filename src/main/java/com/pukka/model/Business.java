package com.pukka.model;

import java.util.Arrays;
import java.util.Optional;

public enum Business {
	INITECH, INITRODE;

	public static Optional<Business> fromString(String text) {
		return Arrays.stream(Business.values())
				.filter(e -> e.name().equalsIgnoreCase(text)).findAny();
	}
}
