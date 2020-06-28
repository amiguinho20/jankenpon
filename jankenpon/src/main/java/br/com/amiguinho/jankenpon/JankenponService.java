package br.com.amiguinho.jankenpon;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.amiguinho.jankenpon.strategy.Jogada;

@Service
public class JankenponService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JankenponService.class);
	
	public Set<Jogador> consultarJogadores(){
		return JankenponCacheSingleton.getJogadores();
	}
	
	public void excluirJogada(Jogador jogador) {
		jogador = JankenponCacheSingleton.getJogador(jogador);
		jogador.setJogada(null);
	}
	
	public void excluirJogador(Jogador jogador) {
		JankenponCacheSingleton.getJogadores().remove(jogador);
	}
	
	public void incluirJogador(Jogador jogador) {
		JankenponCacheSingleton.getJogadores().add(jogador);
	}
	
	//public void incluirJogada(Jogador jogador, JogadaEnum jogada) {
	public void incluirJogada(Jogador jogador, Jogada jogada) {
		Set<Jogador> jogadores = JankenponCacheSingleton.getJogadores();
		if (jogadores.contains(jogador)) {
			jogador = JankenponCacheSingleton.getJogador(jogador);
		}else {
			incluirJogador(jogador);
		}
		jogador.setJogada(jogada);
	}
		
	public void jogar() {

		Jogador jogadorVencedor = null;
		
		foco:
		for (Jogador jogadorFoco : JankenponCacheSingleton.getJogadores()) {
			
			boolean jogadorSemJogada = jogadorFoco.getJogada() == null ? true : false;
			if (jogadorSemJogada) {
				continue;
			}
			
			for (Jogador rival : JankenponCacheSingleton.getJogadores()) {
				
				boolean jogadorIgualRival = jogadorFoco.equals(rival);
				if (jogadorIgualRival) {
					continue;
				}
				
				boolean rivalSemJogada = rival.getJogada() == null ? true : false;
				if (rivalSemJogada) {
					continue;
				}

				boolean empate = jogadorFoco.getJogada().equals(rival.getJogada());
				if (empate) {
					continue foco;
				}

				boolean derrota = jogadorFoco.getJogada().getFraquezas().contains(rival.getJogada());
				if (derrota) {
					continue foco;
				}
			}
			jogadorVencedor = jogadorFoco;
		}
		
		if (jogadorVencedor != null) {
			LOGGER.info("vitoria: jogador[{}]", jogadorVencedor.getIdentificacao());
			JankenponCacheSingleton.setJogadorVencedor(jogadorVencedor);
		} else {
			LOGGER.info("EMPATE");
		}

		
	}
	
	public String consultarResultado() {
		Jogador jogadorVencedor = JankenponCacheSingleton.getJogadorVencedor();
		String retorno = "EMPATE";
		if (jogadorVencedor != null) {
			retorno = "Vencedor: " + jogadorVencedor.getIdentificacao() + " - " + jogadorVencedor.getJogada().getName();
		}
		return retorno;
	}
	
}
