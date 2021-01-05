/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.mgamble.geocodio.api;

/**
 *
 * @author mgamble
 */
public class Version {

    /*

        0.0.1 - Initial version

     */
    public Version() {

    }

    private final String buildNumber = "0.0.1";
    private final String buildName = "cardigan";
    private final String author = "Matthew M. Gamble";

    /**
     * @return the buildNumber
     */
    public String getBuildNumber() {
        return buildNumber;
    }

    /**
     * @return the buildName
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

}
