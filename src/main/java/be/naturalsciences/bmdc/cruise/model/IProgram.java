/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import java.util.Collection;

/**
 * An interface that contains the core EARS elements for a Program, enriched
 * with entities and fields needed for the CSR.
 *
 * @author thomas
 */
public interface IProgram extends IEarsEntity{

    Collection<? extends ICruise> getCruises();
    
    String getSampling();

    String getName();

    String getDescription();

    Long getId();

    String getIdentifier();

    Collection<? extends IPerson> getPrincipalInvestigators();

    Collection<? extends IProject> getProjects();

    void setCruises(Collection<? extends ICruise> cruises);

    void setSampling(String sampling);

    void setName(String name);

    void setDescription(String description);

    void setId(Long id);

    void setIdentifier(String identifier);

    void setPrincipalInvestigators(Collection<? extends IPerson> principalInvestigators);

    void setProjects(Collection<? extends IProject> projects);

}
