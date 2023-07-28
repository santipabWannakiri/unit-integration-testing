package com.softwaretesting.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "influencer")
@Data
public class InfluencerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "influencer_detail_id")
    private InfluencerDetailModel influencerDetailModel;

    public InfluencerModel() {
    }

    public InfluencerModel(String name, String email, InfluencerDetailModel influencerDetailModel) {
        this.name = name;
        this.email = email;
        this.influencerDetailModel = influencerDetailModel;
    }

    public InfluencerModel(int id, String name, String email, InfluencerDetailModel influencerDetailModel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.influencerDetailModel = influencerDetailModel;
    }
}
