package org.echaselab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookSpringTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddAddressBook() throws Exception{
        //Create address book
        this.mockMvc.perform(post("/book")).andDo(print()).andExpect(status().isOk());

        //Add buddy
        this.mockMvc.perform(post("/buddy?book=1&buddy_name=ethan&buddy_phone=613")).andDo(print()).andExpect(status().isOk());

        //Get buddy
        this.mockMvc.perform(get("/buddy")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("ethan"))).andExpect(content().string(containsString("613")));

        //Delete buddy
        this.mockMvc.perform(delete("/buddy?id=1&name=ethan")).andDo(print()).andExpect(status().isOk());

        //Get buddy
        this.mockMvc.perform(get("/buddy")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAddBuddy() throws Exception{
        this.mockMvc.perform(post("/buddy?book=1&buddy_name=ethan&buddy_phone=613")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGetBuddy() throws Exception{
        this.mockMvc.perform(get("/buddy")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDeleteBuddy() throws Exception {
        this.mockMvc.perform(delete("/buddy?id=1&name=ethan")).andExpect(status().isOk());
    }
//    @Test
//    public void testGetAddressBooks() throws Exception{
//        RestTemplate restTemplate = new TestRestTemplate();
//        String getBooksUrl = "http://localhost:8080/book";
//        ResponseEntity<String> response = restTemplate.getForObject(getBooksUrl, String.class);
//
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//
//        System.out.println(response.getBody());
////        assertThat(this.controller.getBooks("http://localhost:"+port+"/book"), String.class);
//    }
}
