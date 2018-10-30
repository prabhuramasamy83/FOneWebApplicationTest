package com.fonewebapplicationtest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class to test the main controller
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FOneMainController.class, secure = false)
public class FOneMainControllerTest {

    @Value("${welcome.message:}")
    private String message;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test calling the main controller
     *
     * @throws Exception
     */
    @Test
    public void shouldReturnMainMsgCallingMainController() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().string(containsString(message)));
    }

}
