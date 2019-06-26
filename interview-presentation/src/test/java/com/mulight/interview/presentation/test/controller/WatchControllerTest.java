package com.mulight.interview.presentation.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WatchControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper mapper;
	
	List<String> inputList = new ArrayList<>();
	
	MvcResult mvcResult = null;
    
	//suppose we fetch the purchasing list from front end 
    @Before
    public void setUp() throws Exception{
    	inputList.add("001"); 
    	inputList.add("001"); 
    	inputList.add("001"); 
    	inputList.add("001"); 
    	inputList.add("001"); 
    	inputList.add("001"); 
    	inputList.add("002"); 
    	inputList.add("002"); 
    	inputList.add("002"); 
    	inputList.add("002"); 
    	inputList.add("003"); 
    	inputList.add("002"); 
    }
    
    @Test
    public void watchControllerTest () throws Exception {
    	String requestJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(inputList);
    	mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/checkout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @After
    public void afterTest () throws Exception {
    	
    	System.out.println("Do something after test");
    }

}
