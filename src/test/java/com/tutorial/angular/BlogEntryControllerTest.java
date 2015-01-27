package com.tutorial.angular;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


public class BlogEntryControllerTest {
	
	@InjectMocks
	private BlogEntryController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		mockMvc = standaloneSetup(controller).build();
		
		
	}

	@Test
	public void test() throws Throwable{
		mockMvc.perform(post("/test").content("{\"title\":\"test blog entry\"}").
				contentType(MediaType.APPLICATION_JSON)).
				andExpect(jsonPath("$.title", is("test blog entry"))).andDo(print());
	}
}
