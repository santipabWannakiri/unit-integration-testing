package com.softwaretesting.unit.model;

import com.softwaretesting.model.Application;
import com.softwaretesting.model.InfluencerDetailModel;
import com.softwaretesting.model.InfluencerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfluencerModelTest {

    @Test
    void modelTest() {
        InfluencerDetailModel detail = new InfluencerDetailModel();
        InfluencerModel influencer = new InfluencerModel();
        detail.setId(1);
        detail.setApp_name(Application.YOUTUBE);
        detail.setChannel_name("https://youtube.com/nokia3310Channel");
        influencer.setId(1);
        influencer.setName("Nokia3310");
        influencer.setEmail("nokia3310@gmail.com");
        influencer.setInfluencerDetailModel(detail);

        assertEquals(1, influencer.getId());
        assertEquals("Nokia3310", influencer.getName());
        assertEquals("nokia3310@gmail.com", influencer.getEmail());
        assertEquals(1, influencer.getInfluencerDetailModel().getId());
        assertEquals(Application.YOUTUBE, influencer.getInfluencerDetailModel().getApp_name());
        assertEquals("https://youtube.com/nokia3310Channel", influencer.getInfluencerDetailModel().getChannel_name());

    }


}