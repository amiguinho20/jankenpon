package br.com.amiguinho.jankenpon.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum JogadaEnum {
	PEDRA,
	PAPEL,
	TESOURA,
	SPOCK,
	LAGARTO;

	private Set<JogadaEnum> fraquezas = null;
	
	@Deprecated
	public static JogadaEnum criar(String codigo) {
		JogadaEnum jogadorCriado = null;
		for (JogadaEnum tipo : JogadaEnum.values()) {
			if (tipo.name().equalsIgnoreCase(codigo)) {
				jogadorCriado = tipo;
				break;
			}
		}
		return jogadorCriado;
	}

	@Deprecated
	public Set<JogadaEnum> getFraquezas() {
		if (fraquezas == null) {
			fraquezas = new HashSet<>();
			
			if (this.equals(PEDRA)) {
				fraquezas.addAll(Arrays.asList(PAPEL, SPOCK));
			} 
			if (this.equals(PAPEL)) {
				fraquezas.addAll(Arrays.asList(TESOURA, LAGARTO));
			} 
			if (this.equals(TESOURA)){
				fraquezas.addAll(Arrays.asList(PEDRA, SPOCK));
			}
			if (this.equals(SPOCK)) {
				fraquezas.addAll(Arrays.asList(LAGARTO, PAPEL));
			}
			if (this.equals(LAGARTO)) {
				fraquezas.addAll(Arrays.asList(PEDRA, TESOURA));
			}

		}
		return fraquezas;
	}	
}
