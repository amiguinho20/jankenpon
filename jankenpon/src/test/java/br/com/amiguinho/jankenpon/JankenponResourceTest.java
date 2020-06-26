package br.com.amiguinho.jankenpon;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class JankenponResourceTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper objectMapper;

//	@Autowired
//	private JankenponService service;

	@Test
	public void incluirJogador() throws Exception {

		Jogador jogador = Jogador.criarJogador("Jack");

		String queryString = "/jogador/" + jogador.getIdentificacao();
		mock.perform(put(queryString)).andExpect(status().isOk());

		MvcResult result = mock.perform(get("/jogadores")).andExpect(status().isOk()).andReturn();

		String jsonInput = result.getResponse().getContentAsString();

		Set<Jogador> jogadores = objectMapper.readValue(jsonInput,
				objectMapper.getTypeFactory().constructCollectionType(Set.class, Jogador.class));

		 Assertions.assertTrue(jogadores.contains(jogador));
	}
}
