package net.xdclass.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //底层用junit，SpringJUnit4ClassRunner
@SpringBootTest(classes = {Application.class})//启动整个springboot项目
@AutoConfigureMockMvc
public class MockMvcTestDemo {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void apiTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/get_user")).
                andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testMatcher() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request("GET", URI.create("/get_user")))
                .andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
    }

}
