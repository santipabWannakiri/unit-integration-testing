package com.softwaretesting.repository;

import com.softwaretesting.model.InfluencerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfluencerRepository extends CrudRepository<InfluencerModel,Integer > {

}
