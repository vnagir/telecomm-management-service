package com.telecomm.traffic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties
public class Tower {

    public Tower(String provider, String location, double geoLocation, boolean isActive) {
        this.provider = provider;
        this.location = location;
        this.geoLocation = geoLocation;
        this.isActive = isActive;
        this.created_date = System.currentTimeMillis();
        this.uniqueId = geoLocation + "|" + provider;
    }


    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String provider;
    @NotNull
    private String location;
    @NotNull
    private Double geoLocation;
    @NotNull
    private boolean isActive;
    @NotNull
    private long created_date;
    @NotNull
    private String uniqueId;

    @Override
    public String toString() {
        return "Tower{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                ", location='" + location + '\'' +
                ", geoLocation=" + geoLocation +
                ", status=" + isActive +
                ", uniqueId="+uniqueId+
                ", created_date=" + created_date +
                '}';
    }
}

