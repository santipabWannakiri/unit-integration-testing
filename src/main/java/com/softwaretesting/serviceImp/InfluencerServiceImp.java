package com.softwaretesting.serviceImp;

import com.softwaretesting.model.Application;
import com.softwaretesting.model.InfluencerDetailModel;
import com.softwaretesting.model.InfluencerModel;
import com.softwaretesting.model.request.RequestAddInfluencer;
import com.softwaretesting.repository.InfluencerRepository;
import com.softwaretesting.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfluencerServiceImp implements InfluencerService {

    @Autowired
    private InfluencerRepository influencerRepository;

    public InfluencerServiceImp(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    @Override
    public InfluencerModel save(RequestAddInfluencer influencerInfo) {
        InfluencerDetailModel influencerDetailModel = new InfluencerDetailModel();
        if (influencerInfo.getApp_name().equals("FACEBOOK")) {
            influencerDetailModel.setApp_name(Application.FACEBOOK);
        } else if (influencerInfo.getApp_name().equals("TIKTOK")) {
            influencerDetailModel.setApp_name(Application.TIKTOK);
        } else if (influencerInfo.getApp_name().equals("YOUTUBE")) {
            influencerDetailModel.setApp_name(Application.YOUTUBE);
        } else {
            influencerDetailModel.setApp_name(null);
        }
        influencerDetailModel.setChannel_name(influencerInfo.getChannel_name());
        return influencerRepository.save(new InfluencerModel(influencerInfo.getName(), influencerInfo.getEmail(), influencerDetailModel));
    }

}
