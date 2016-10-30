package com.pukka.model;

import java.util.Arrays;
import java.util.Optional;

public enum Source {
	LOCAL, FACEBOOK, GOOGLE;

	public static Optional<Source> fromString(String text) {
		return Arrays.stream(Source.values())
				.filter(e -> e.name().equalsIgnoreCase(text)).findAny();
	}
}
