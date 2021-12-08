/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import be.naturalsciences.bmdc.cruise.model.IPerson;
import be.naturalsciences.bmdc.cruise.model.IPlatform;
import be.naturalsciences.bmdc.cruise.model.IProgram;
import be.naturalsciences.bmdc.cruise.model.ISeaArea;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Set;

/**
 * An interface that contains the core EARS elements for a SeaArea, enriched
 * with entities and fields needed for the CSR.
 *
 * @author thomas
 */
public interface ICruise extends IEarsEntity{

    public IHarbour getArrivalHarbour();

    public Collection<? extends IPerson> getChiefScientists();

    public IOrganisation getCollateCentre();

    public IHarbour getDepartureHarbour();

    public OffsetDateTime getEndDate();

    public String getIdentifier();

    public String getName();

    public boolean getIsCancelled();

    public String getObjectives();
    
    public String getPurpose();

    public Collection<? extends ICoordinate> getTrack();

    public Collection<? extends ILinkedDataTerm> getP02();

    public IPlatform getPlatform();

    public Collection<? extends IProgram> getPrograms();

    public Collection<? extends ILinkedDataTerm> getProjectTerms();

    public Collection<? extends ILinkedDataTerm> getSeaAreaTerms();

    public Collection<? extends ISeaArea> getSeaAreas();

    public OffsetDateTime getStartDate();

    public Collection<? extends IEvent> getEvents();

    public Set<? extends ILinkedDataTerm> getInstrumentTypes();

    public Set<? extends ITool> getInstruments();

    void setArrivalHarbour(IHarbour arrivalHarbour);

    void setChiefScientists(Collection<? extends IPerson> chiefScientists);

    void setCollateCentre(IOrganisation IOrganisation);

    void setDepartureHarbour(IHarbour departureHarbour);

    void setEndDate(OffsetDateTime endDate);

    void setIdentifier(String identifier);

    void setName(String name);

    void setIsCancelled(boolean isCancelled);

    void setObjectives(String objectives);
    
    void setPurpose(String purpose);

    public void setTrack(Collection<? extends ICoordinate> coordinates);

    void setP02(Collection<? extends ILinkedDataTerm> P02);

    void setPlatform(IPlatform platform);

    void setPrograms(Collection<? extends IProgram> programs);

    void setSeaAreas(Collection<? extends ISeaArea> seaAreas);

    void setStartDate(OffsetDateTime startDate);

    public void setEvents(Collection<? extends IEvent> events);

    public String getFinalReportUrl();

    public void setFinalReportUrl(String finalReportUrl);

    public String getPlanningUrl();

    public void setPlanningUrl(String planningUrl);

    public String getTrackImageUrl();

    public void setTrackImageUrl(String trackImageUrl);

    public String getTrackGmlUrl();

    public void setTrackGmlUrl(String trackGmlUrl);

    public String getDataUrl();

    public void setDataUrl(String dataUrl);

    public void setSouthBoundLatitude(double y);

    public void setNorthBoundLatitude(double y);

    public void setWestBoundLongitude(double x);

    public void setEastBoundLongitude(double x);

    public double getWestBoundLongitude();

    public double getEastBoundLongitude();

    public double getNorthBoundLatitude();

    public double getSouthBoundLatitude();

}
