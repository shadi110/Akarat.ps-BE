package com.akarati.ps.entities;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Location {
    private String address;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    
}