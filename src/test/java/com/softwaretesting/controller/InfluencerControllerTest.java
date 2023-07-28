package com.softwaretesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwaretesting.model.Application;
import com.softwaretesting.model.request.RequestAddInfluencer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class InfluencerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void aboutReturnsApplicationInfo() throws Exception {
        this.mockMvc.perform(get("/api/about"))
                .andExpect(status().isOk())
                .andExpect(content().string("Influencer Application"));
    }

    @Test
    public void recordNewInfluencerReturns_Success() throws Exception {
        RequestAddInfluencer influencer = new RequestAddInfluencer();
        influencer.setName("Santipab");
        influencer.setEmail("Santipab@gmail.com");
        influencer.setApp_name("TIKTOK");
        influencer.setChannel_name("Tiktok/yoyoChannel");
        String payload = mapper.writeValueAsString(influencer);

        mockMvc.perform(post("/api/influencer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("New Influencer name : " + influencer.getName() + " Added!!"));
    }
}