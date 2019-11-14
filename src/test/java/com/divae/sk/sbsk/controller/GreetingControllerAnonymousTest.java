package com.divae.sk.sbsk.controller;

import com.divae.sk.sbsk.SbskApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ActiveProfiles("disable-security")
class GreetingControllerAnonymousTest extends SbskApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPrincipalGreeting_with_Anonymous() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/principal"))
                .andExpect(
                        content().string("Hello, Anonymous!")
                );
        // @formatter:on
    }
}
