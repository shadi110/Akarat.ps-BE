package com.akarati.ps.entities;

import lombok.Data;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name = "real_estates")
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private Double price;
    
    private List<String> listOfPictures;
    
    private String video;
    
    @Embedded
    private Location location;
    
    private String currency;
    
    private Integer numberOfFavorites = 0;
    
    private String phoneNumber;
    
    private String ownerName;
    
    @Enumerated(EnumType.STRING)
    private RealEstateType type;
    
    @Enumerated(EnumType.STRING)
    private RealEstateStatus status;
    
    private String reachingToLocationVideo;
    
    @Column(length = 2048)
    private String coverPhoto;
    
    private Double size;
    
    private String sizeMetric;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private User owner;
    
    // Constructors, getters, setters
}




