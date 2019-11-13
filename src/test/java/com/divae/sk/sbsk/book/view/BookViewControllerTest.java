package com.divae.sk.sbsk.book.view;

import com.divae.sk.sbsk.SbskApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("disable-security")
class BookViewControllerTest extends SbskApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void index_csv_shouldWork() throws Exception {
        mockMvc
                .perform(get("/booksView").accept("text/csv"))
                .andExpect(status().isOk())
                .andExpect(view().name("booksView"))
                .andExpect(content().string(""
                        + "1;Hyperion;1600\n"
                        + "2;Der Algebraist;800\n"));
    }
}