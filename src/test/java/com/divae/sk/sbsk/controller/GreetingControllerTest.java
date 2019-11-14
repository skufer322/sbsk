package com.divae.sk.sbsk.controller;

import com.divae.sk.sbsk.SbskApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(
        username = "SUPER-USER",
        roles = {"USER", "ADMIN"}
)
class GreetingControllerTest extends SbskApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPrincipalGreeting_with_mockuser_class() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/principal"))
                .andExpect(content().string("Hello, SUPER-USER!"));
        // @formatter:on
    }

    @Test
    @WithMockUser(
            username = "METHOD-MOCKED-USER"
    )
    void getPrincipalGreeting_with_specified_mockuser_method() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/principal"))
                .andExpect(content().string("Hello, METHOD-MOCKED-USER!"));
        // @formatter:on
    }

    @Test
    @WithMockUser
    void getPrincipalGreeting_with_unspecified_mockuser_method() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/principal"))
                .andExpect(content().string("Hello, user!"));
        // @formatter:on
    }

    @Test
    void getPrincipalGreeting_with_user_fluent_API() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/principal")
                        .with(user("TEST-USER")))
                .andExpect(content().string("Hello, TEST-USER!"));
        // @formatter:on
    }

    @Test
    @WithAnonymousUser
    void getPrincipalGreeting_with_anonymous_user() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/principal"))
                .andExpect(status().isUnauthorized());
        // @formatter:on
    }

    @Test
    void getAdminGreeting_with_mockuser_class_which_has_admin_status() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/admin"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Admin!"));
        // @formatter:on
    }

    @Test
    @WithMockUser
    void getAdminGreeting_with_mockuser_method_which_has_not_admin_status() throws Exception {
        // @formatter:off
        mockMvc.perform(
                    get("/greeting/admin"))
                .andExpect(status().isForbidden());
        // @formatter:on
    }
}