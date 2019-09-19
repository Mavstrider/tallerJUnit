package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BaseDeDatosService {

	List<Articulo> articulos = new ArrayList<Articulo>(Arrays.asList(new Articulo(1L, "Batatas", 10D),
			new Articulo(2L, "Ba", 2D), new Articulo(3L, "BatatasN", 10D), new Articulo(4L, "Favas", 30D),
			new Articulo(5L, "feijoes", 20D)));

	public Articulo findbyId(Long id) {
		for (Articulo articulo : articulos) {
			if (articulo.getId().equals(id)) {
				return articulo;
			}
		}
		return null;
	}

	public Articulo findByIdJava8(Long id) {
		Optional<Articulo> artfind = articulos.stream().filter(articulo -> articulo.getId().equals(id)).findFirst();
		if(artfind.isPresent()) {
			return artfind.get();
		}
		return null;
	}

}
