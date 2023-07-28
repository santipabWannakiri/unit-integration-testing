package com.softwaretesting.service;

import com.softwaretesting.model.Application;
import com.softwaretesting.model.InfluencerDetailModel;
import com.softwaretesting.model.InfluencerModel;
import com.softwaretesting.model.request.RequestAddInfluencer;
import com.softwaretesting.repository.InfluencerRepository;
import com.softwaretesting.serviceImp.InfluencerServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InfluencerServiceTest {
    @Mock
    private InfluencerRepository influencerRepository;
    @InjectMocks
    private InfluencerServiceImp influencerService;

    @BeforeEach
    public void setup() {
        Mockito.when(influencerRepository.save(Mockito.any(InfluencerModel.class)))
                .thenReturn(new InfluencerModel(1, "TOM", "tom@gmail.com",
                                new InfluencerDetailModel(1, Application.FACEBOOK, "https://facebook.com/tomfanpage")));
    }

    @Test
    public void recordNewInfluencer() {
        RequestAddInfluencer tom = new RequestAddInfluencer("TOM", "tom@gmail.com", "FACEBOOK", "https://facebook.com/tomfanpage");
        InfluencerModel result = influencerService.save(tom);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("TOM", result.getName());
        assertEquals(1, result.getInfluencerDetailModel().getId());
        assertEquals(Application.FACEBOOK, result.getInfluencerDetailModel().getApp_name());
    }

}