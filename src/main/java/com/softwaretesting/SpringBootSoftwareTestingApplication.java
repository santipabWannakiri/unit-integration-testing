package com.softwaretesting;

import com.softwaretesting.model.Application;
import com.softwaretesting.model.InfluencerDetailModel;
import com.softwaretesting.model.InfluencerModel;
import com.softwaretesting.repository.InfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSoftwareTestingApplication {

    private InfluencerRepository influencerRepository;

    @Autowired
    public SpringBootSoftwareTestingApplication(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoftwareTestingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLiner(String[] args) {
        return runner -> {
            initialInfluencer();
        };
    }

    private void initialInfluencer() {
        InfluencerModel tom = new InfluencerModel("TOM", "tom@gmail.com", new InfluencerDetailModel(Application.FACEBOOK, "https://facebook.com/tomfanpage"));
        InfluencerModel jerry = new InfluencerModel("JERRY", "jerry@gmail.com", new InfluencerDetailModel(Application.YOUTUBE, "https://youtube.com/jerryChannel"));
        InfluencerModel speed = new InfluencerModel("SPEED", "speed@gmail.com", new InfluencerDetailModel(Application.TIKTOK, "https://tiktok.com/speedtt"));

        influencerRepository.save(tom);
        influencerRepository.save(jerry);
        influencerRepository.save(speed);
    }

}
