package com.example.demo;

import com.example.demo.controller.HelloWorldClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;




@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
    private MockMvc mvc = MockMvcBuilders.standaloneSetup(new HelloWorldClass()).build();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect( MockMvcResultMatchers.content().string(equalTo("HelloWorld!")));

    }
}
