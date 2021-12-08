/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import be.naturalsciences.bmdc.cruise.model.ILinkedDataTerm;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;

/**
 * An interface that contains the core EARS elements for a Tool, enriched with
 * entities and fields needed for the CSR.
 *
 * @author thomas
 */
public interface ITool extends IConcept {

    ILinkedDataTerm getParentTool();

    void setParentTool(ILinkedDataTerm parentTool);

    /*SENSORML REQUIREMENTS*/
    public String getSerialNumber();

    public ILinkedDataTerm getToolCategory();

    public Collection<? extends IProperty> getCharacteristics();

    public Collection<? extends IProperty> getCapabilities();

    public Collection<? extends ILinkedDataTerm> getMeasuredParameters();

    public void setSerialNumber(String serialNumber);

    public void setToolCategory(ILinkedDataTerm toolCategory);

    public void setCharacteristics(Collection<? extends IProperty> characteristics);

    public void setCapabilities(Collection<? extends IProperty> capabilities);

    public void setMeasuredParameters(Collection<? extends ILinkedDataTerm> measuredParameters);

    //featureOfInterest: do later as at the moment we have no need for static sensors
    //location: do later as at the moment we have no need for static sensors
}
