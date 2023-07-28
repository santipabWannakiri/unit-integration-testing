package com.softwaretesting.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "influencer_detail")
@Data
public class InfluencerDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Application app_name;
    private String channel_name;

    public InfluencerDetailModel() {
    }

    public InfluencerDetailModel(Application app_name, String channel_name) {
        this.app_name = app_name;
        this.channel_name = channel_name;
    }

    public InfluencerDetailModel(int id, Application app_name, String channel_name) {
        this.id = id;
        this.app_name = app_name;
        this.channel_name = channel_name;
    }
}
