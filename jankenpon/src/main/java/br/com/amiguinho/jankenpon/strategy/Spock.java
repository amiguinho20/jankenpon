package br.com.amiguinho.jankenpon.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

class Spock extends Jogada{

	@JsonIgnore
	@Override
	public Set<Jogada> getFraquezas() {
		return new HashSet<>(Arrays.asList(new Lagarto(), new Papel()));
	}

	@Override
	public String getName() {
		return JogadaEnum.SPOCK.name().toLowerCase();
	}
	
}
