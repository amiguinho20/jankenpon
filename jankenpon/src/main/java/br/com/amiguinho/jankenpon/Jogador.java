package br.com.amiguinho.jankenpon;

import br.com.amiguinho.jankenpon.strategy.Jogada;

public class Jogador {

	private String identificacao;
//	private JogadaEnum jogada;
	private Jogada jogada;
	
	public Jogador() {}
	
	public Jogador(String identificacao) {
		this.identificacao = identificacao;
	}
	
	public static Jogador criarJogador(String identificacao) {
		return new Jogador(identificacao);
	}
	
	public String getIdentificacao() {
		return identificacao;
	}
	public Jogador setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
		return this;
	}
	
//	public JogadaEnum getJogada() {
//		return jogada;
//	}
//	public Jogador setJogada(JogadaEnum jogada) {
//		this.jogada = jogada;
//		return this;
//	}

	public Jogada getJogada() {
		return jogada;
	}
	public Jogador setJogada(Jogada jogada) {
		this.jogada = jogada;
		return this;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (identificacao == null) {
			if (other.identificacao != null)
				return false;
		} else if (!identificacao.equalsIgnoreCase(other.identificacao))
			return false;
		return true;
	}
	
	
	
}
