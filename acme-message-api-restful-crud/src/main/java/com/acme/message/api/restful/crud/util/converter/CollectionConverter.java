package com.acme.message.api.restful.crud.util.converter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CollectionConverter {

	public static <T> List<T> toList(final Iterable<T> iterable) {
		
		if (Objects.isNull(iterable)){
				return Collections.emptyList();
		}
		
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}
}
