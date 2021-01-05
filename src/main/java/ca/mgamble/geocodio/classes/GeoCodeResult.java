/*
 * The MIT License
 *
 * Copyright 2021 mgamble.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ca.mgamble.geocodio.classes;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author mgamble
 */
public class GeoCodeResult {
    @SerializedName("address_components")
    private AddressComponents addressComponents;
    @SerializedName("formatted_address")
    private String formattedAddress;
    private Location location;
    private String accuract;
    @SerializedName("accuracy_type")
    private String accuracyType;
    private String source;

    /**
     * @return the addressComponents
     */
    public AddressComponents getAddressComponents() {
        return addressComponents;
    }

    /**
     * @param addressComponents the addressComponents to set
     */
    public void setAddressComponents(AddressComponents addressComponents) {
        this.addressComponents = addressComponents;
    }

    /**
     * @return the formattedAddress
     */
    public String getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * @param formattedAddress the formattedAddress to set
     */
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the accuract
     */
    public String getAccuract() {
        return accuract;
    }

    /**
     * @param accuract the accuract to set
     */
    public void setAccuract(String accuract) {
        this.accuract = accuract;
    }

    /**
     * @return the accuracyType
     */
    public String getAccuracyType() {
        return accuracyType;
    }

    /**
     * @param accuracyType the accuracyType to set
     */
    public void setAccuracyType(String accuracyType) {
        this.accuracyType = accuracyType;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }
    
}
