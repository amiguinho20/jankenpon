package br.com.amiguinho.jankenpon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JankenponCacheSingleton {
	
	private static Set<Jogador> jogadores;
	
	private static Jogador jogadorVencedor;

	private JankenponCacheSingleton() {}
	
	public static synchronized Set<Jogador> getJogadores(){
		if (jogadores == null) {
			jogadores = new HashSet<>();
		}
		return jogadores;
	}
	
	public static synchronized Jogador getJogador(Jogador jogador) {
		Jogador jogadorRet = null;
		if (jogadores.contains(jogador)) {
			Iterator<Jogador> iterator = jogadores.iterator();
			while (iterator.hasNext()) {
				Jogador aux = iterator.next();
				if (aux.equals(jogador)) {
					jogadorRet = aux;
					break;
				}
			}
		}
		return jogadorRet;
	}
	
	public static synchronized Jogador getJogadorVencedor() {
		return jogadorVencedor;
	}
	
	public static synchronized void setJogadorVencedor(Jogador vencedor) {
		jogadorVencedor = vencedor;
	}

	
}
