package com.softwaretesting.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InfluencerModelTest {

    @Test
    void modelTest() {
        InfluencerDetailModel detial = new InfluencerDetailModel();
        InfluencerModel influencer = new InfluencerModel();
        detial.setId(1);
        detial.setApp_name(Application.YOUTUBE);
        detial.setChannel_name("youtube.com/nokia3310Channel");
        influencer.setId(1);
        influencer.setName("Nokia3310");
        influencer.setEmail("nokia3310@gmail.com");
        influencer.setInfluencerDetailModel(detial);

        assertEquals(1, influencer.getId());
        assertEquals("Nokia3310", influencer.getName());
        assertEquals("nokia3310@gmail.com", influencer.getEmail());
        assertEquals(1, influencer.getInfluencerDetailModel().getId());
        assertEquals(Application.YOUTUBE, influencer.getInfluencerDetailModel().getApp_name());
        assertEquals("youtube.com/nokia3310Channel", influencer.getInfluencerDetailModel().getChannel_name());

    }


}