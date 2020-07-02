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

    public static String getIdentifierFromNERCorSDNUrl(String identifier) {
        if (identifier == null) {
            return null;
        } else if (URN_PATTERN.matcher(identifier).matches()) {
            String[] split = identifier.split(":");
            return split[split.length - 1];//return the last part of an urn
        } else if (URL_PATTERN.matcher(identifier).matches()) {
            String[] split = identifier.split("/");
            return split[split.length - 1];//return the last part of an urn
        } else {
            return identifier;
        }
    }

    public static String cleanUrl(String url) {
        return url.replaceAll("/$", "");
    }

    public static String getUrnFromUrl(String url) {
        if (url == null) {
            return null;
        } else if (URL_PATTERN.matcher(url).matches()) {
            Pattern earsIdentifierPattern = Pattern.compile("http://ontologies.ef-ears.eu/ears2/1#(.+?)_(\\d+)");
            Pattern nercIdentifierPattern = Pattern.compile("http://vocab.nerc.ac.uk/collection/(.+?)/current/(.+)");

            Matcher matcher = earsIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String type = matcher.group(1);
                String number = matcher.group(2).replace("/", "");
                return "ears:" + type + "::" + number;
            }
            matcher = nercIdentifierPattern.matcher(url);
            if (matcher.find()) {
                String type = matcher.group(1);
                String number = matcher.group(2).replace("/", "");
                return "SDN:" + type + "::" + number;
            }
        }
        return null;
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
