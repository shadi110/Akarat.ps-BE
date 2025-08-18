package com.akarati.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akarati.ps.entities.RealEstate;
import com.akarati.ps.entities.RealEstateStatus;
import com.akarati.ps.entities.RealEstateType;
import com.akarati.ps.entities.User;
import com.akarati.ps.excptions.ResourceNotFoundException;
import com.akarati.ps.repositories.RealEstateRepository;
import com.akarati.ps.repositories.UserRepository;

@Service
public class RealEstateService {
    @Autowired
    private RealEstateRepository realEstateRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public RealEstate createRealEstate(RealEstate realEstate, Long ownerId) {
        User owner = userRepository.findById(ownerId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        realEstate.setOwner(owner);
        return realEstateRepository.save(realEstate);
    }
    
    public List<RealEstate> getAllRealEstates() {
        return realEstateRepository.findAll();
    }
    
    public Optional<RealEstate> getRealEstateById(Long id) {
        return realEstateRepository.findById(id);
    }
    
    public RealEstate updateRealEstate(Long id, RealEstate realEstateDetails) {
        RealEstate realEstate = realEstateRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Real Estate not found"));
        // Update fields
        return realEstateRepository.save(realEstate);
    }
    
    public void deleteRealEstate(Long id) {
        realEstateRepository.deleteById(id);
    }
    
    public List<RealEstate> searchRealEstates(String query, RealEstateType type, 
            RealEstateStatus status, Double minPrice, Double maxPrice) {
				return null;
        // Implementation for search with multiple criteria
    }
    
    public void incrementFavoriteCount(Long id) {
        RealEstate realEstate = realEstateRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Real Estate not found"));
        realEstate.setNumberOfFavorites(realEstate.getNumberOfFavorites() + 1);
        realEstateRepository.save(realEstate);
    }
}