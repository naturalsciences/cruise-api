/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

/**
 * An interface that contains the core EARS elements for a Sea Area, enriched with entities and fields needed for the CSR.  
 * @author thomas
 */
public interface ISeaArea extends IConcept {
    
    
    public Double getSouthBoundLatitude();

    public void setSouthBoundLatitude(Double southBoundLatitude);

    public Double getNorthBoundLatitude();

    public void setNorthBoundLatitude(Double northBoundLatitude);

    public Double getWestBoundLongitude();

    public void setWestBoundLongitude(Double westBoundLongitude);

    public Double getEastBoundLongitude();

    public void setEastBoundLongitude(Double eastBoundLongitude);
}
