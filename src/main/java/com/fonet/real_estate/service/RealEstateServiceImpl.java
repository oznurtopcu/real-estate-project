package com.fonet.real_estate.service;

import com.fonet.real_estate.entity.RealEstate;
import com.fonet.real_estate.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealEstateServiceImpl implements RealEstateService{

    private final RealEstateRepository realEstateRepository;

    @Autowired
    public RealEstateServiceImpl(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    @Override
    public List<RealEstate> getAll() {
        return realEstateRepository.findAll();
    }

    //TODO: exception eklenecek
    @Override
    public RealEstate findById(Long id) {
        return realEstateRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public RealEstate create(RealEstate realEstate) {
        return realEstateRepository.save(realEstate);
    }

    @Override
    public RealEstate replaceOrCreate(Long id, RealEstate realEstate) {

        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(id);

        if(optionalRealEstate.isPresent()) {

            realEstate.setId(id);

            return realEstateRepository.save(realEstate);
        }
        return realEstateRepository.save(realEstate);
    }

    //TODO: exception eklenecek
    @Override
    public RealEstate update(Long id, RealEstate realEstate) {

        RealEstate realEstateToUpdate = realEstateRepository.findById(id)
                .orElseThrow();

        if(realEstate.getType() != null)
            realEstateToUpdate.setType(realEstate.getType());

        if(realEstate.getRoomInfo() != null)
            realEstateToUpdate.setRoomInfo(realEstate.getRoomInfo());

        if(realEstate.getArea() != null)
            realEstateToUpdate.setArea(realEstate.getArea());

        if(realEstate.getFloor() != null)
            realEstateToUpdate.setFloor(realEstate.getFloor());

        if(realEstate.getBuildingFloor() != null)
            realEstateToUpdate.setBuildingFloor(realEstate.getBuildingFloor());

        if(realEstate.getHeatingType() != null)
            realEstateToUpdate.setHeatingType(realEstate.getHeatingType());

        if(realEstate.getPrice() != null)
            realEstateToUpdate.setPrice(realEstate.getPrice());

        if(realEstate.getDescription() != null)
            realEstateToUpdate.setDescription(realEstate.getDescription());

        return realEstateRepository.save(realEstateToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        realEstateRepository.deleteById(id);
    }
}
