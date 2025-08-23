package com.akarati.ps.repositories;

import java.util.List;


import com.akarati.ps.entities.RealEstate;
import com.akarati.ps.entities.RealEstateStatus;
import com.akarati.ps.entities.RealEstateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
    List<RealEstate> findByType(RealEstateType type);
    List<RealEstate> findByStatus(RealEstateStatus status);
    List<RealEstate> findByOwnerId(Long ownerId);
    List<RealEstate> findByPriceBetween(Double minPrice, Double maxPrice);
    List<RealEstate> findByOwner_Id(Long ownerId);
}
