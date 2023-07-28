package com.softwaretesting.service;

import com.softwaretesting.model.InfluencerModel;
import com.softwaretesting.model.request.RequestAddInfluencer;

public interface InfluencerService {
    public InfluencerModel save(RequestAddInfluencer influencer);
}
