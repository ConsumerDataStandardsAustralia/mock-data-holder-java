package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@ApiModel(description = "Australian address formatted according to the file format defined by the [PAF file format](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf)")
@Entity
public class CommonPAFAddress  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Building/Property name 1
     */
    private String buildingName1;

    /**
     * Building/Property name 2
     */
    private String buildingName2;

    /**
     * Unique identifier for an address as defined by Australia Post.  Also known as Delivery Point Identifier
     */
    private String dpid;

    /**
     * Unit number (including suffix, if applicable)
     */
    private String flatUnitNumber;

    /**
     * Type of flat or unit for the address
     */
    private String flatUnitType;

    /**
     * Floor or level number (including alpha characters)
     */
    private String floorLevelNumber;

    /**
     * Type of floor or level for the address
     */
    private String floorLevelType;

    /**
     * Full name of locality
     */
    private String localityName;

    /**
     * Allotment number for the address
     */
    private String lotNumber;

    /**
     * Postal delivery number if the address is a postal delivery type
     */
    private Integer postalDeliveryNumber;

    /**
     * Postal delivery number prefix related to the postal delivery number
     */
    private String postalDeliveryNumberPrefix;

    /**
     * Postal delivery number suffix related to the postal delivery number
     */
    private String postalDeliveryNumberSuffix;

    /**
     * Postal delivery type. (eg. PO BOX). Valid enumeration defined by Australia Post PAF code file
     */
    private String postalDeliveryType;

    /**
     * Postcode for the locality
     */
    private String postcode;

    /**
     * State in which the address belongs. Valid enumeration defined by Australia Post PAF code file [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf). NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT
     */
    private String state;

    /**
     * The name of the street
     */
    private String streetName;

    /**
     * The street type suffix. Valid enumeration defined by Australia Post PAF code file
     */
    private String streetSuffix;

    /**
     * The street type. Valid enumeration defined by Australia Post PAF code file
     */
    private String streetType;

    /**
     * Thoroughfare number for a property (first number in a property ranged address)
     */
    private Integer thoroughfareNumber1;

    /**
     * Suffix for the thoroughfare number. Only relevant is thoroughfareNumber1 is populated
     */
    private String thoroughfareNumber1Suffix;

    /**
     * Second thoroughfare number (only used if the property has a ranged address eg 23-25)
     */
    private Integer thoroughfareNumber2;

    /**
     * Suffix for the second thoroughfare number. Only relevant is thoroughfareNumber2 is populated
     */
    private String thoroughfareNumber2Suffix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommonPAFAddress buildingName1(String buildingName1) {
        this.buildingName1 = buildingName1;
        return this;
    }

    @ApiModelProperty(value = "Building/Property name 1")
    public String getBuildingName1() {
        return buildingName1;
    }

    public void setBuildingName1(String buildingName1) {
        this.buildingName1 = buildingName1;
    }
    public CommonPAFAddress buildingName2(String buildingName2) {
        this.buildingName2 = buildingName2;
        return this;
    }

    @ApiModelProperty(value = "Building/Property name 2")
    public String getBuildingName2() {
        return buildingName2;
    }

    public void setBuildingName2(String buildingName2) {
        this.buildingName2 = buildingName2;
    }
    public CommonPAFAddress dpid(String dpid) {
        this.dpid = dpid;
        return this;
    }

    @ApiModelProperty(value = "Unique identifier for an address as defined by Australia Post.  Also known as Delivery Point Identifier")
    public String getDpid() {
        return dpid;
    }

    public void setDpid(String dpid) {
        this.dpid = dpid;
    }

    public CommonPAFAddress flatUnitNumber(String flatUnitNumber) {
        this.flatUnitNumber = flatUnitNumber;
        return this;
    }

    @ApiModelProperty(value = "Unit number (including suffix, if applicable)")
    public String getFlatUnitNumber() {
        return flatUnitNumber;
    }

    public void setFlatUnitNumber(String flatUnitNumber) {
        this.flatUnitNumber = flatUnitNumber;
    }

    public CommonPAFAddress flatUnitType(String flatUnitType) {
        this.flatUnitType = flatUnitType;
        return this;
    }

    @ApiModelProperty(value = "Type of flat or unit for the address")
    public String getFlatUnitType() {
        return flatUnitType;
    }

    public void setFlatUnitType(String flatUnitType) {
        this.flatUnitType = flatUnitType;
    }

    public CommonPAFAddress floorLevelNumber(String floorLevelNumber) {
        this.floorLevelNumber = floorLevelNumber;
        return this;
    }

    @ApiModelProperty(value = "Floor or level number (including alpha characters)")
    public String getFloorLevelNumber() {
        return floorLevelNumber;
    }

    public void setFloorLevelNumber(String floorLevelNumber) {
        this.floorLevelNumber = floorLevelNumber;
    }

    public CommonPAFAddress floorLevelType(String floorLevelType) {
        this.floorLevelType = floorLevelType;
        return this;
    }

    @ApiModelProperty(value = "Type of floor or level for the address")
    public String getFloorLevelType() {
        return floorLevelType;
    }

    public void setFloorLevelType(String floorLevelType) {
        this.floorLevelType = floorLevelType;
    }
    public CommonPAFAddress localityName(String localityName) {
        this.localityName = localityName;
        return this;
    }

    @ApiModelProperty(required = true, value = "Full name of locality")
    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public CommonPAFAddress lotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    @ApiModelProperty(value = "Allotment number for the address")
    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public CommonPAFAddress postalDeliveryNumber(Integer postalDeliveryNumber) {
        this.postalDeliveryNumber = postalDeliveryNumber;
        return this;
    }

    @ApiModelProperty(value = "Postal delivery number if the address is a postal delivery type")
    public Integer getPostalDeliveryNumber() {
        return postalDeliveryNumber;
    }

    public void setPostalDeliveryNumber(Integer postalDeliveryNumber) {
        this.postalDeliveryNumber = postalDeliveryNumber;
    }
    public CommonPAFAddress postalDeliveryNumberPrefix(String postalDeliveryNumberPrefix) {
        this.postalDeliveryNumberPrefix = postalDeliveryNumberPrefix;
        return this;
    }

    @ApiModelProperty(value = "Postal delivery number prefix related to the postal delivery number")
    public String getPostalDeliveryNumberPrefix() {
        return postalDeliveryNumberPrefix;
    }

    public void setPostalDeliveryNumberPrefix(String postalDeliveryNumberPrefix) {
        this.postalDeliveryNumberPrefix = postalDeliveryNumberPrefix;
    }
    public CommonPAFAddress postalDeliveryNumberSuffix(String postalDeliveryNumberSuffix) {
        this.postalDeliveryNumberSuffix = postalDeliveryNumberSuffix;
        return this;
    }

    @ApiModelProperty(value = "Postal delivery number suffix related to the postal delivery number")
    public String getPostalDeliveryNumberSuffix() {
        return postalDeliveryNumberSuffix;
    }

    public void setPostalDeliveryNumberSuffix(String postalDeliveryNumberSuffix) {
        this.postalDeliveryNumberSuffix = postalDeliveryNumberSuffix;
    }
    public CommonPAFAddress postalDeliveryType(String postalDeliveryType) {
        this.postalDeliveryType = postalDeliveryType;
        return this;
    }

    @ApiModelProperty(value = "Postal delivery type. (eg. PO BOX). Valid enumeration defined by Australia Post PAF code file")
    public String getPostalDeliveryType() {
        return postalDeliveryType;
    }

    public void setPostalDeliveryType(String postalDeliveryType) {
        this.postalDeliveryType = postalDeliveryType;
    }

    public CommonPAFAddress postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    @ApiModelProperty(required = true, value = "Postcode for the locality")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public CommonPAFAddress state(String state) {
        this.state = state;
        return this;
    }

    @ApiModelProperty(required = true, value = "State in which the address belongs. Valid enumeration defined by Australia Post PAF code file [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf). NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public CommonPAFAddress streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    @ApiModelProperty(value = "The name of the street")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public CommonPAFAddress streetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
        return this;
    }

    @ApiModelProperty(value = "The street type suffix. Valid enumeration defined by Australia Post PAF code file")
    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }
    public CommonPAFAddress streetType(String streetType) {
        this.streetType = streetType;
        return this;
    }

    @ApiModelProperty(value = "The street type. Valid enumeration defined by Australia Post PAF code file")
    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }
    public CommonPAFAddress thoroughfareNumber1(Integer thoroughfareNumber1) {
        this.thoroughfareNumber1 = thoroughfareNumber1;
        return this;
    }

    @ApiModelProperty(value = "Thoroughfare number for a property (first number in a property ranged address)")
    public Integer getThoroughfareNumber1() {
        return thoroughfareNumber1;
    }

    public void setThoroughfareNumber1(Integer thoroughfareNumber1) {
        this.thoroughfareNumber1 = thoroughfareNumber1;
    }

    public CommonPAFAddress thoroughfareNumber1Suffix(String thoroughfareNumber1Suffix) {
        this.thoroughfareNumber1Suffix = thoroughfareNumber1Suffix;
        return this;
    }

    @ApiModelProperty(value = "Suffix for the thoroughfare number. Only relevant is thoroughfareNumber1 is populated")
    public String getThoroughfareNumber1Suffix() {
        return thoroughfareNumber1Suffix;
    }

    public void setThoroughfareNumber1Suffix(String thoroughfareNumber1Suffix) {
        this.thoroughfareNumber1Suffix = thoroughfareNumber1Suffix;
    }
    public CommonPAFAddress thoroughfareNumber2(Integer thoroughfareNumber2) {
        this.thoroughfareNumber2 = thoroughfareNumber2;
        return this;
    }

    @ApiModelProperty(value = "Second thoroughfare number (only used if the property has a ranged address eg 23-25)")
    public Integer getThoroughfareNumber2() {
        return thoroughfareNumber2;
    }

    public void setThoroughfareNumber2(Integer thoroughfareNumber2) {
        this.thoroughfareNumber2 = thoroughfareNumber2;
    }

    public CommonPAFAddress thoroughfareNumber2Suffix(String thoroughfareNumber2Suffix) {
        this.thoroughfareNumber2Suffix = thoroughfareNumber2Suffix;
        return this;
    }

    @ApiModelProperty(value = "Suffix for the second thoroughfare number. Only relevant is thoroughfareNumber2 is populated")
    public String getThoroughfareNumber2Suffix() {
        return thoroughfareNumber2Suffix;
    }

    public void setThoroughfareNumber2Suffix(String thoroughfareNumber2Suffix) {
        this.thoroughfareNumber2Suffix = thoroughfareNumber2Suffix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPAFAddress commonPAFAddress = (CommonPAFAddress) o;
        return Objects.equals(this.id, commonPAFAddress.id) &&
            Objects.equals(this.buildingName1, commonPAFAddress.buildingName1) &&
            Objects.equals(this.buildingName2, commonPAFAddress.buildingName2) &&
            Objects.equals(this.dpid, commonPAFAddress.dpid) &&
            Objects.equals(this.flatUnitNumber, commonPAFAddress.flatUnitNumber) &&
            Objects.equals(this.flatUnitType, commonPAFAddress.flatUnitType) &&
            Objects.equals(this.floorLevelNumber, commonPAFAddress.floorLevelNumber) &&
            Objects.equals(this.floorLevelType, commonPAFAddress.floorLevelType) &&
            Objects.equals(this.localityName, commonPAFAddress.localityName) &&
            Objects.equals(this.lotNumber, commonPAFAddress.lotNumber) &&
            Objects.equals(this.postalDeliveryNumber, commonPAFAddress.postalDeliveryNumber) &&
            Objects.equals(this.postalDeliveryNumberPrefix, commonPAFAddress.postalDeliveryNumberPrefix) &&
            Objects.equals(this.postalDeliveryNumberSuffix, commonPAFAddress.postalDeliveryNumberSuffix) &&
            Objects.equals(this.postalDeliveryType, commonPAFAddress.postalDeliveryType) &&
            Objects.equals(this.postcode, commonPAFAddress.postcode) &&
            Objects.equals(this.state, commonPAFAddress.state) &&
            Objects.equals(this.streetName, commonPAFAddress.streetName) &&
            Objects.equals(this.streetSuffix, commonPAFAddress.streetSuffix) &&
            Objects.equals(this.streetType, commonPAFAddress.streetType) &&
            Objects.equals(this.thoroughfareNumber1, commonPAFAddress.thoroughfareNumber1) &&
            Objects.equals(this.thoroughfareNumber1Suffix, commonPAFAddress.thoroughfareNumber1Suffix) &&
            Objects.equals(this.thoroughfareNumber2, commonPAFAddress.thoroughfareNumber2) &&
            Objects.equals(this.thoroughfareNumber2Suffix, commonPAFAddress.thoroughfareNumber2Suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            buildingName1,
            buildingName2,
            dpid,
            flatUnitNumber,
            flatUnitType,
            floorLevelNumber,
            floorLevelType,
            localityName,
            lotNumber,
            postalDeliveryNumber,
            postalDeliveryNumberPrefix,
            postalDeliveryNumberSuffix,
            postalDeliveryType,
            postcode,
            state,
            streetName,
            streetSuffix,
            streetType,
            thoroughfareNumber1,
            thoroughfareNumber1Suffix,
            thoroughfareNumber2,
            thoroughfareNumber2Suffix);
    }

    @Override
    public String toString() {
        return "class CommonPAFAddress {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   buildingName1: " + toIndentedString(buildingName1) + "\n" +
            "   buildingName2: " + toIndentedString(buildingName2) + "\n" +
            "   dpid: " + toIndentedString(dpid) + "\n" + 
            "   flatUnitNumber: " + toIndentedString(flatUnitNumber) + "\n" + 
            "   flatUnitType: " + toIndentedString(flatUnitType) + "\n" + 
            "   floorLevelNumber: " + toIndentedString(floorLevelNumber) + "\n" + 
            "   floorLevelType: " + toIndentedString(floorLevelType) + "\n" + 
            "   localityName: " + toIndentedString(localityName) + "\n" + 
            "   lotNumber: " + toIndentedString(lotNumber) + "\n" + 
            "   postalDeliveryNumber: " + toIndentedString(postalDeliveryNumber) + "\n" + 
            "   postalDeliveryNumberPrefix: " + toIndentedString(postalDeliveryNumberPrefix) + "\n" + 
            "   postalDeliveryNumberSuffix: " + toIndentedString(postalDeliveryNumberSuffix) + "\n" + 
            "   postalDeliveryType: " + toIndentedString(postalDeliveryType) + "\n" + 
            "   postcode: " + toIndentedString(postcode) + "\n" + 
            "   state: " + toIndentedString(state) + "\n" + 
            "   streetName: " + toIndentedString(streetName) + "\n" + 
            "   streetSuffix: " + toIndentedString(streetSuffix) + "\n" + 
            "   streetType: " + toIndentedString(streetType) + "\n" + 
            "   thoroughfareNumber1: " + toIndentedString(thoroughfareNumber1) + "\n" + 
            "   thoroughfareNumber1Suffix: " + toIndentedString(thoroughfareNumber1Suffix) + "\n" + 
            "   thoroughfareNumber2: " + toIndentedString(thoroughfareNumber2) + "\n" + 
            "   thoroughfareNumber2Suffix: " + toIndentedString(thoroughfareNumber2Suffix) + "\n" + 
            "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

