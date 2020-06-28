package br.com.amiguinho.jankenpon.strategy;

import java.util.HashMap;
import java.util.Map;

public class JogadaFactory {

	private static Map<String, Jogada> jogadas = new HashMap<>();

	static {
		jogadas.put(JogadaEnum.PEDRA.name().toLowerCase(), new Pedra());
		jogadas.put(JogadaEnum.PAPEL.name().toLowerCase(), new Papel());
		jogadas.put(JogadaEnum.TESOURA.name().toLowerCase(), new Tesoura());
		jogadas.put(JogadaEnum.SPOCK.name().toLowerCase(), new Spock());
		jogadas.put(JogadaEnum.LAGARTO.name().toLowerCase(), new Tesoura());
	}
	
	public static Jogada getJogada(String jogada) {
		return jogadas.get(jogada);
	}
	
}
