package sbr;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloCtrlTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getHello() throws Exception {
        mvc.perform(get("/hello")) //
                .andExpect(status().isOk()) //
                .andExpect(jsonPath("$.message", is("Hello World!")));
    }

    @Test
    void putHello() throws Exception {
        mvc.perform(put("/hello")) //
                .andExpect(status().isMethodNotAllowed());
    }
}
