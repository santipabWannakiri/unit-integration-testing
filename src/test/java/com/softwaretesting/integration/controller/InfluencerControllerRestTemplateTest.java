package com.softwaretesting.integration.controller;

import com.softwaretesting.model.request.RequestAddInfluencer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfluencerControllerRestTemplateTest {
    @Value(value = "${local.server.port}")
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    private String aboutUrl;
    private String influencerUrl;

    @BeforeEach
    public void setup(){
        aboutUrl = "http://localhost:" + port + "/api/about";
        influencerUrl = "http://localhost:" + port + "/api/influencer";
    }

    @Test
    public void aboutReturnApplicationInfo() throws Exception {
                assertThat(this.restTemplate.getForObject(aboutUrl, String.class))
                .contains("Influencer Application");
    }

    @Test
    public void recordNewInfluencerReturns_Success() throws Exception{
        RequestAddInfluencer influencer = new RequestAddInfluencer();
        influencer.setName("TOM");
        influencer.setEmail("tom@gmail.com");
        influencer.setApp_name("TIKTOK");
        influencer.setChannel_name("https://tiktok/tomtt");

        assertThat(this.restTemplate.postForObject(influencerUrl,influencer,String.class))
                .contains("New Influencer name : " + influencer.getName() + " Added!");
    }

    @Test
    public void recordNewInfluencerReturn_BadRequest_Name_is_Mandatory() throws Exception{
        RequestAddInfluencer influencer = new RequestAddInfluencer();
        influencer.setName("");
        influencer.setEmail("tom@gmail.com");
        influencer.setApp_name("TIKTOK");
        influencer.setChannel_name("https://tiktok/tomtt");

        assertThat(this.restTemplate.postForObject(influencerUrl,influencer,String.class))
                .contains("name : is mandatory");

    }

    @Test
    public void recordNewInfluencerReturn_BadRequest_Email_is_Mandatory() throws Exception{
        RequestAddInfluencer influencer = new RequestAddInfluencer();
        influencer.setName("TOM");
        influencer.setEmail("");
        influencer.setApp_name("TIKTOK");
        influencer.setChannel_name("https://tiktok/tomtt");

        assertThat(this.restTemplate.postForObject(influencerUrl,influencer,String.class))
                .contains("email : is mandatory");

    }

    @Test
    public void recordNewInfluencerReturn_BadRequest_ChannelName_Incorrect() throws Exception{
        RequestAddInfluencer influencer = new RequestAddInfluencer();
        influencer.setName("TOM");
        influencer.setEmail("tom@gmail.com");
        influencer.setApp_name("TIKTOK");
        influencer.setChannel_name("tik");

        assertThat(this.restTemplate.postForObject(influencerUrl,influencer,String.class))
                .contains("channel_name : Channel name must be between 5 and 60 characters");

    }
}
