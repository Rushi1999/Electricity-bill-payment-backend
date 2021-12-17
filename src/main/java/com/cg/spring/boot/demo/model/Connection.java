package com.cg.spring.boot.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

//@Component("connection")
//@Scope("prototype")
@Entity
@Table(name = "CONNECTION")
public class Connection implements Serializable {

	private static final long serialVersionUID = 1L;
	// should be auto-generated for internal purpose

	@Id
	@Column(name = "CONNECTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int connectionId;

// customerId auto-generated
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column(name = "CONSUMER_NUMBER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long consumerNumber;

//    @OneToMany
//	@OneToOne
//	@JoinColumn(name = "ADDRESS_ID")
//	private Address address;
//	 private String address;
	
//	@Column(name = "ADDRESS_ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int addressId;
	
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
	private int pincode;
	

	@Column(name = "CONNECTION_TYPE")
	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;

	@Column(name = "APPLICATION_DATE", length = 10, nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate applicationDate;

	@Column(name = "CONNECTION_DATE", length = 10, nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate connectionDate;

	/* validation */

	@Column(name = "STATUS", nullable = false, columnDefinition = "varchar(15) Check(status IN ('active','inactive'))")
//    @Pattern(regexp = "^[A|I]{1}$", message ="Must be Active or Inactive")
//    @Pattern(regexp = "^Active$|^Inactive$", message = "allowed input: active or inactive")
	private String connectionStatus;
	
	
	
	

	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Connection(Customer customer, int flatOrHouseNumber, String buildingName, String landmark,
			String villageName, String taluka, String districtName, String state, int pincode,
			ConnectionType connectionType, LocalDate applicationDate, LocalDate connectionDate,
			String connectionStatus) {
		super();
		this.customer = customer;
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.villageName = villageName;
		this.taluka = taluka;
		this.districtName = districtName;
		this.state = state;
		this.pincode = pincode;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}



	public Connection(int flatOrHouseNumber, String buildingName, String landmark, String villageName, String taluka,
			String districtName, String state, int pincode, ConnectionType connectionType, LocalDate applicationDate,
			LocalDate connectionDate, String connectionStatus) {
		super();
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.villageName = villageName;
		this.taluka = taluka;
		this.districtName = districtName;
		this.state = state;
		this.pincode = pincode;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}



	public Connection(int connectionId, Customer customer, Long consumerNumber, int flatOrHouseNumber,
			String buildingName, String landmark, String villageName, String taluka, String districtName, String state,
			int pincode, ConnectionType connectionType, LocalDate applicationDate, LocalDate connectionDate,
			String connectionStatus) {
		super();
		this.connectionId = connectionId;
		this.customer = customer;
		this.consumerNumber = consumerNumber;
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.villageName = villageName;
		this.taluka = taluka;
		this.districtName = districtName;
		this.state = state;
		this.pincode = pincode;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}



	public int getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	public String getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", customer=" + customer + ", consumerNumber="
				+ consumerNumber + ", flatOrHouseNumber=" + flatOrHouseNumber + ", buildingName=" + buildingName
				+ ", landmark=" + landmark + ", villageName=" + villageName + ", taluka=" + taluka + ", districtName="
				+ districtName + ", state=" + state + ", pincode=" + pincode + ", connectionType=" + connectionType
				+ ", applicationDate=" + applicationDate + ", connectionDate=" + connectionDate + ", connectionStatus="
				+ connectionStatus + "]";
	}

		
	
}