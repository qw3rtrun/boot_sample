package qw3rtrun;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@WebIntegrationTest
@Transactional
public class DemoBootApplicationIntegrationTests {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ent/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/ent").content("petya"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createAndGetTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/ent").content("petya"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/ent/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ent"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createAndListTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/ent").content("petya"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.put("/ent").content("vasya"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/ent"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createAndUpdateTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/ent").content("petya"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.post("/ent/0").content("masha"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void replaceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/ent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"petya\",\"version\":0}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createAndReplaceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/ent").content("petya"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.post("/ent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"masha\",\"version\":1}"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
