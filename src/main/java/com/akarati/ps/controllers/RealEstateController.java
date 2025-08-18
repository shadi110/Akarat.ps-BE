package com.akarati.ps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akarati.ps.entities.RealEstate;
import com.akarati.ps.entities.RealEstateStatus;
import com.akarati.ps.entities.RealEstateType;
import com.akarati.ps.services.RealEstateService;

@RestController
@RequestMapping("/api/real-estates")
public class RealEstateController {
    @Autowired
    private RealEstateService realEstateService;
    
    @PostMapping("/owner/{ownerId}")
    public ResponseEntity<RealEstate> createRealEstate(
            @PathVariable Long ownerId,
            @RequestBody RealEstate realEstate) {
        return new ResponseEntity<>(
            realEstateService.createRealEstate(realEstate, ownerId), 
            HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<RealEstate>> getAllRealEstates() {
        return new ResponseEntity<>(realEstateService.getAllRealEstates(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RealEstate> getRealEstateById(@PathVariable Long id) {
        return realEstateService.getRealEstateById(id)
            .map(realEstate -> new ResponseEntity<>(realEstate, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RealEstate> updateRealEstate(
            @PathVariable Long id, 
            @RequestBody RealEstate realEstateDetails) {
        return new ResponseEntity<>(
            realEstateService.updateRealEstate(id, realEstateDetails), 
            HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealEstate(@PathVariable Long id) {
        realEstateService.deleteRealEstate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<RealEstate>> searchRealEstates(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) RealEstateType type,
            @RequestParam(required = false) RealEstateStatus status,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return new ResponseEntity<>(
            realEstateService.searchRealEstates(query, type, status, minPrice, maxPrice),
            HttpStatus.OK);
    }
    
    @PostMapping("/{id}/favorite")
    public ResponseEntity<Void> incrementFavoriteCount(@PathVariable Long id) {
        realEstateService.incrementFavoriteCount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}