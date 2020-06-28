package br.com.amiguinho.jankenpon.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

class Papel extends Jogada{

	@JsonIgnore
	@Override
	public Set<Jogada> getFraquezas() {
		return new HashSet<>(Arrays.asList(new Tesoura(), new Lagarto()));
	}

	@Override
	public String getName() {
		return JogadaEnum.PAPEL.name().toLowerCase();
	}

}
