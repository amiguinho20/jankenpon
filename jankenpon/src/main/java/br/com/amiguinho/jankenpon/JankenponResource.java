package br.com.amiguinho.jankenpon;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JankenponResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(JankenponResource.class);
	
	@Autowired
	private JankenponService model;

	@GetMapping("/jogadores")
	public Set<Jogador> consultarJogadores() {
		return model.consultarJogadores();
	}

	@GetMapping("/resultado")
	public String consultarResultado() {
		return model.consultarResultado();
	}

	@PostMapping("/jogar")
	public void jogar() {
		model.jogar();
	}
	
	@PutMapping("/jogador/{jogador}")
	public void incluirJogador(@PathVariable("jogador") String identificacao) {
		Jogador jogador = Jogador.criarJogador(identificacao);
		model.incluirJogador(jogador);
	}

	@PutMapping("/jogada/{jogador}/{jogada}")
	public void incluirJogada(@PathVariable("jogador") String jogador, @PathVariable("jogada") String jogada) {
		Jogador objJogador = Jogador.criarJogador(jogador);
		JogadaEnum objJogada = JogadaEnum.criar(jogada);
		model.incluirJogada(objJogador, objJogada);
	}

	@DeleteMapping("/jogador/{jogador}")
	public void excluirJogador(@PathVariable("jogador") String jogador) {
		Jogador objJogador = Jogador.criarJogador(jogador);
		model.excluirJogador(objJogador);
	}
	
	@DeleteMapping("/jogada/{jogador}")
	public void excluirJogada(@PathVariable("jogador") String jogador) {
		Jogador objJogador = Jogador.criarJogador(jogador);
		model.excluirJogada(objJogador);
	}

	
}
