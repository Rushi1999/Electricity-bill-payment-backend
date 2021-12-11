package com.cg.spring.boot.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("address")
@Entity
@Table(name = "ADDRESS") 
public class Address  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	//auto-generated Id
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	 @Column
	private int flatOrHouseNumber;
	 @Column
	private String buildingName;
	 @Column
	private String landmark;
	 @Column
	private String villageName;
	 @Column
	private String taluka;
	 @Column
	private String districtName;
	 @Column
	private String state;
	 @Column
	private Long pincode;
	 
	 
	 
	public Address() {
		super();
	}
	public Address(Long addressId, int flatOrHouseNumber, String buildingName, String landmark, String villageName,
			String taluka, String districtName, String state, Long pincode) {
		super();
		this.addressId = addressId;
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.villageName = villageName;
		this.taluka = taluka;
		this.districtName = districtName;
		this.state = state;
		this.pincode = pincode;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public int getFlatOrHouseNumber() {
		return flatOrHouseNumber;
	}
	public void setFlatOrHouseNumber(int flatOrHouseNumber) {
		this.flatOrHouseNumber = flatOrHouseNumber;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getTaluka() {
		return taluka;
	}
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatOrHouseNumber=" + flatOrHouseNumber + ", buildingName="
				+ buildingName + ", landmark=" + landmark + ", villageName=" + villageName + ", taluka=" + taluka
				+ ", districtName=" + districtName + ", state=" + state + ", pincode=" + pincode + "]";
	}
	 
	 
	
	
	
}
