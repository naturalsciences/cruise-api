/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An interface that contains the core EARS elements for a Term that exists in a
 * linked data context, enriched with entities and fields needed for the CSR.
 *
 * @author thomas
 */
public interface ILinkedDataTerm extends IConcept {

    public final static Pattern URN_PATTERN = Pattern.compile(
            "^[a-z0-9][a-z0-9-]{0,31}:([a-z0-9()+,\\-.:=@;$_!*']|%[0-9a-f]{2})+$",
            Pattern.CASE_INSENSITIVE);

    public final static Pattern URL_PATTERN = Pattern.compile(
            "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})",
            Pattern.CASE_INSENSITIVE);

    public static String getIdentifierFromNERCorSDNUrlOrUrn(String identifier) {
        if (identifier == null) {
            return null;
        } else if (URN_PATTERN.matcher(identifier).matches()) {
            String[] split = identifier.split(":");
            return split[split.length - 1];//return the last part of an urn
        } else if (URL_PATTERN.matcher(identifier).matches()) {
            String[] split = identifier.split("/");
            return split[split.length - 1];//return the last part of an url
        } else {
            return identifier;
        }
    }

    public static String cleanUrl(String url) {
        return url.replaceAll("/$", "");
    }

    /**
     * *
     * Get the BODC URN from a term. Look both at the identifier and the
     * transitive identifier
     *
     * @return
     */
    public static String getBodcUrnFromTerm(ILinkedDataTerm term) {
        String urnFromUrl = getUrnFromUrl(term.getIdentifier());
        if (urnFromUrl.contains("SDN")) {
            return urnFromUrl;
        } else {
            return getUrnFromUrl(term.getTransitiveIdentifier());
        }
    }

    /**
     * *
     * Given an url, try to extract the essential part and show it as an urn. If
     * all else fails, return null.
     *
     * @param identifier
     * @return
     */
    public static String getUrnFromUrl(String url) {
        if (url == null) {
            return null;
            // http://ontologies.ef-ears.eu/ears2/1/#11BE_dev_35255390-37ad-11ea-92f9-d6fb90a43b87
        } else if (URL_PATTERN.matcher(url).matches()) {
//http://ontologies.ef-ears.eu/ears2/1/#dev_ff470414-4958-495a-ace9-ff6d6590a4f3
            Pattern earsClassicIdentifierPattern = Pattern.compile("https?:\\/\\/ontologies.ef-ears.eu\\/ears2\\/1\\/?#(.+?)_([a-z0-9\\-]+)");
            Pattern earsBoatIdentifierPattern = Pattern.compile("https?:\\/\\/ontologies.ef-ears.eu\\/ears2\\/1\\/?#(.+?)_(.+?)_([a-z0-9\\-]+)");
            Pattern wrongEars3PartIdentifierPattern = Pattern.compile("https?:\\/\\/ontologies.ef-ears.eu\\/ears2\\/1\\/11BE#(.+?)_([a-z0-9\\-]+)");
            Pattern nercIdentifierPattern = Pattern.compile("https?:\\/\\/vocab.nerc.ac.uk\\/collection\\/(.+?)\\/current\\/(.+)");
            Pattern sdnUrnToUrlIdentifierPattern = Pattern.compile("https?:\\/\\/www.seadatanet.org\\/urnurl\\/(.*)");

            Matcher matcher = sdnUrnToUrlIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String urn = matcher.group(1).replace("/", "");
                return urn;
            }
            matcher = nercIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String type = matcher.group(1);
                String number = matcher.group(2).replace("/", "");
                return "SDN:" + type + "::" + number;
            }
            matcher = earsBoatIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String boat = matcher.group(1);
                String type = matcher.group(2);
                String identifier = matcher.group(3).replace("/", "");
                return "ears:" + type + ":" + boat + "::" + identifier;
            }
            matcher = earsClassicIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String type = matcher.group(1);
                String identifier = matcher.group(2).replace("/", "");
                return "ears:" + type + "::" + identifier;
            }
            matcher = wrongEars3PartIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String boat = "11BE";
                String type = matcher.group(1);
                String identifier = matcher.group(2).replace("/", "");
                return "ears:" + type + ":" + boat + "::" + identifier;
            }
        }
        return null;
    }

    public static boolean identifierMatches(ILinkedDataTerm me, String identifier) {
        return me.getIdentifier().equals(identifier) || me.getUrn().equals(identifier) || me.getTransitiveIdentifier().equals(identifier) || me.getTransitiveUrn().equals(identifier);
    }

    public static boolean identifierOrNameMatches(ILinkedDataTerm me, String identifier) {
        return identifier.equals(me.getName()) || identifier.equals(me.getIdentifier()) || identifier.equals(me.getUrn()) || identifier.equals(me.getTransitiveIdentifier()) || identifier.equals(me.getTransitiveUrn());
    }

    /**
     * *
     * Return the identifier for the term. This must be an url.
     *
     * @return
     */
    String getIdentifier();

    /**
     * *
     * Set the identifier for the term. This must be an url.
     *
     * @return
     */
    void setIdentifier(String identifier);

    String getName();

    void setName(String name);

    /**
     * *
     * Set the (pseudo-)urn for the term.
     *
     * @return
     */
    String getUrn();

    void setUrn(String urn);

    String getTransitiveIdentifier();

    void setTransitiveIdentifier(String transitiveIdentifier);

    String getTransitiveUrn();

    void setTransitiveUrn(String transitiveUrn);
}
