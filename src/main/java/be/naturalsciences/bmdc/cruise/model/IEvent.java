/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import java.time.OffsetDateTime;
import java.util.Collection;

/**
 * An interface that contains the core EARS elements for an , enriched with
 * entities and fields needed for the CSR.
 *
 * @author thomas
 */
public interface IEvent extends IEarsEntity {

    public IProgram getProgram();

    public ILinkedDataTerm getAction();

    public IPerson getActor();

    public String getEventDefinitionId();

    public String getIdentifier();

    public ILinkedDataTerm getProcess();

    public Collection<? extends IProperty> getProperties();

    public ILinkedDataTerm getSubject();

    public OffsetDateTime getTimeStamp();

    public ITool getTool();

    public ILinkedDataTerm getToolCategory();

    public IPlatform getPlatform();

    @Override
    public String toString();

    void setProgram(IProgram program);

    void setAction(ILinkedDataTerm action);

    void setActor(IPerson actor);

    void setEventDefinitionId(String eventDefinitionId);

    void setIdentifier(String identifier);

    void setProcess(ILinkedDataTerm process);

    void setProperties(Collection<? extends IProperty> properties);

    void setSubject(ILinkedDataTerm subject);

    void setTimeStamp(OffsetDateTime timeStamp);

    void setTool(ITool tool);

    void setToolCategory(ILinkedDataTerm toolCategory);

    void setPlatform(IPlatform platform);

    String getLabel();

    void setLabel(String label);

    String getDescription();

    void setDescription(String description);

    String getStation();

    void setStation(String description);

}
