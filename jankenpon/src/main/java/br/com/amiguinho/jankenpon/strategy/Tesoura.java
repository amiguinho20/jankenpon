package br.com.amiguinho.jankenpon.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

class Tesoura extends Jogada{

	@JsonIgnore
	@Override
	public Set<Jogada> getFraquezas() {
		return new HashSet<>(Arrays.asList(new Pedra(), new Spock()));
	}

	@Override
	public String getName() {
		return JogadaEnum.TESOURA.name().toLowerCase();
	}
	
}
