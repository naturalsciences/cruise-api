/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import java.util.Collection;
import java.util.Set;

/**
 * An interface that contains the core EARS elements for a Platform, enriched
 * with entities and fields needed for the CSR.
 *
 * @author thomas
 */
public interface IPlatform extends IConcept {

    ILinkedDataTerm getPlatformClass();

    void setPlatformClass(ILinkedDataTerm platformClass);

    IOrganisation getVesselOperator();

    void setVesselOperator(IOrganisation organisation);

    Set<? extends ITool> getInstruments();

    Collection<? extends ICruise> getCruises();

    Collection<? extends IEvent> getEvents();

    public void addCruise(ICruise cruise);

}
