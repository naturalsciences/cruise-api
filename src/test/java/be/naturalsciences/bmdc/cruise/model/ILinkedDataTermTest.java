/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author thomas
 */
public class ILinkedDataTermTest {

    public ILinkedDataTermTest() {
    }

    /**
     * Test of getUrnFromUrl method, of class ILinkedDataTerm.
     */
    @Test
    public void testGetUrnFromUrl() {
        System.out.println("getUrnFromUrl");
        testUrl("http://ontologies.ef-ears.eu/ears2/1#dev_15/", "ears:dev::15");
        testUrl("http://ontologies.ef-ears.eu/ears2/1#dev_15", "ears:dev::15");
        testUrl("https://ontologies.ef-ears.eu/ears2/1#dev_15", "ears:dev::15");
        testUrl("http://ontologies.ef-ears.eu/ears2/1/#11BE_dev_35255390-37ad-11ea-92f9-d6fb90a43b87",
                "ears:dev:11BE::35255390-37ad-11ea-92f9-d6fb90a43b87");
        testUrl("http://ontologies.ef-ears.eu/ears2/1/#11BE_dev_35255390-37ad-11ea-92f9-d6fb90a43b87/",
                "ears:dev:11BE::35255390-37ad-11ea-92f9-d6fb90a43b87");
        testUrl("https://vocab.nerc.ac.uk/collection/P01/current/SPWGXX01", "SDN:P01::SPWGXX01");
        testUrl("https://vocab.nerc.ac.uk/collection/P01/current/SPWGXX01/", "SDN:P01::SPWGXX01");
        testUrl("https://www.seadatanet.org/urnurl/SDN:P01::SPWGXX01", "SDN:P01::SPWGXX01");
        testUrl("http://www.seadatanet.org/urnurl/SDN:P01::SPWGXX01", "SDN:P01::SPWGXX01");
        testUrl("https://www.seadatanet.org/urnurl/SDN:P01::SPWGXX01/", "SDN:P01::SPWGXX01");
        testUrl("https://www.seadatanet.org/urnurl/SDN:P01::blabla", "SDN:P01::blabla");
        testUrl("http://ontologies.ef-ears.eu/ears2/1/11BE#dev_1927", "ears:dev:11BE::1927");
        testUrl("http://ontologies.ef-ears.eu/ears2/1/12AE#dev_1927", null);
        testUrl("http://ontologies.ef-ears.eu/ears2/1/#dev_ff470414-4958-495a-ace9-ff6d6590a4f3",
                "ears:dev::ff470414-4958-495a-ace9-ff6d6590a4f3");
        testUrl("http://ontologies.ef-ears.eu/ears2/1/#concept_ff470414-4958-495a-ace9-ff6d6590a4f3",
                "ears:concept::ff470414-4958-495a-ace9-ff6d6590a4f3");

        testUrl("http://ontologies.ef-ears.eu/ears2/1#pro_3",
                "ears:pro::3");
        testUrl("http://ontologies.ef-ears.eu/ears2/1#pro_3_johnnyTool_All",
                "ears:pro::3_johnnyTool_All");

    }

    /**
     * Test of getIdentifierFromNERCorSDNUrlOrUrn method, of class ILinkedDataTerm.
     */
    @Test
    @Ignore
    public void testGetIdentifierFromNERCorSDNUrl() {
        System.out.println("getIdentifierFromNERCorSDNUrl");
        String identifier = "";
        String expResult = "";
        String result = ILinkedDataTerm.getIdentifierFromNERCorSDNUrlOrUrn(identifier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleanUrl method, of class ILinkedDataTerm.
     */
    @Test
    @Ignore
    public void testCleanUrl() {
        System.out.println("cleanUrl");
        String url = "";
        String expResult = "";
        String result = ILinkedDataTerm.cleanUrl(url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void testUrl(String url, String expectedId) {
        String result = ILinkedDataTerm.getUrnFromUrl(url);
        assertEquals(expectedId, result);
    }
}
