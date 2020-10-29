package com.mainsoft.app.ecommerce.test;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.mainsoft.app.ecommerce.controller.ClienteController;
import com.mainsoft.app.ecommerce.services.IClienteService;


@WebMvcTest(value = ClienteController.class)
class ClienteCrudTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private IClienteService clienteService;

	
	 @TestConfiguration static class TestConfigurationApp {	 
	 @Bean ObjectMapper objectMapperPrettyPrinting() { return new
	 ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT); } }
	 
	 

	@Test
	void listClientes() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clientes").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println((new Gson()).toJson(result.getResponse()));
		Assert.isTrue(result.getResponse().getStatus() == HttpServletResponse.SC_OK, "Correcto");
	}
	/*
	 * @Test void listCliente() throws Exception { RequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.get("/api/clientes/1")
	 * .accept(MediaType.APPLICATION_JSON); MvcResult result =
	 * mockMvc.perform(requestBuilder).andReturn();
	 * Assert.isTrue(result.getResponse().getStatus() == HttpServletResponse.SC_OK,
	 * "Correcto"); }
	 * 
	 */

}
