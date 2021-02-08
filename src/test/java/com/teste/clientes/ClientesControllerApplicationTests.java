package com.teste.clientes;

import com.teste.clientes.controllers.ClienteController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClienteController.class)
class ClientesControllerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void findAllUsers() throws Exception {
		this.mockMvc.perform(get("/clientes"))
				.andExpect(status().isOk());
	}

}
