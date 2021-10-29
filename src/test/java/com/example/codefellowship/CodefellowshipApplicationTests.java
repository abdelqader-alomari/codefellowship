package com.example.codefellowship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

    @Autowired
    MockMvc mvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void indexPage() throws Exception {
        mvc.perform(get("/")).andExpect(content().string(containsString("Code Fellowship")));
    }

    @Test
    public void signupPage() throws Exception {
        mvc.perform(get("/signup")).andExpect(content().string(containsString("signup")));
    }

    @Test
    public void loginPage() throws Exception {
        mvc.perform(get("/login")).andExpect(content().string(containsString("password")));
    }
}
