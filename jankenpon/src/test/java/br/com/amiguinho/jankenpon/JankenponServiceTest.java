package br.com.amiguinho.jankenpon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class JankenponServiceTest {

	@Autowired
	private JankenponResource resource;

	@Test
	public void incluirJogador() throws Exception {

		String identificador = "jack";

		resource.incluirJogador(identificador);

		Jogador jogador = Jogador.criarJogador(identificador);

		Assertions.assertTrue(resource.consultarJogadores().contains(jogador));
	}
}
