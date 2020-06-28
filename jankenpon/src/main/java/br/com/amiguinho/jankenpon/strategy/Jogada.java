package br.com.amiguinho.jankenpon.strategy;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Jogada {
	
	public abstract String getName();
	
	@JsonIgnore
	public abstract Set<Jogada> getFraquezas();

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() == obj.getClass()){
			return true;
		}else {
			return false;
		}
	}	
	
	
}
