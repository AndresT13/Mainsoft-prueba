package com.mainsoft.app.ecommerce.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mainsoft.app.ecommerce.controller.ClienteController;
import com.mainsoft.app.ecommerce.services.IClienteService;

import org.springframework.util.Assert;

@WebMvcTest(value = ClienteController.class)
class clienteControllTest {
	
	 @Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
	 private IClienteService clienteService;

	 @TestConfiguration
	    static class TestConfigurationApp {
	        @Bean
	        ObjectMapper objectMapperPrettyPrinting() {
	            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	        }
	    }

	 /*
	    @Test
	    void getClients() throws Exception {
	        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clientes")
	                .accept(MediaType.APPLICATION_JSON);
	        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	        Assert.isTrue(result.getResponse().getStatus()== HttpServletResponse.SC_OK, "Correcto");
	    }
	    
	    */


	    @Test
	    void Crear() throws Exception {
	        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clientes/11")
	                .accept(MediaType.APPLICATION_JSON);
	        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	        Assert.isTrue(result.getResponse().getStatus()== HttpServletResponse.SC_OK, "Correcto");
	    }

}
