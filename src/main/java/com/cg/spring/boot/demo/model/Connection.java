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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component("connection")
@Scope("prototype")
@Entity
@Table(name = "CONNECTION") 
public class Connection  implements Serializable{
	
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
//	private int  customer;
	
       
//    @OneToMany
	@JoinColumn(name = "ADDRESS_ID")
    private Address address;
//	 private String address;
	
    @Column(name="CONNECTION_TYPE")
    @Enumerated(EnumType.STRING)
	private ConnectionType connectionType;
	
    @Column(name="APPLICATION_DATE",length = 10, nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate applicationDate;
    
	
    @Column(name="CONNECTION_DATE",length = 10, nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate connectionDate;
	
    /*validation*/
    
    @Column(name = "STATUS", nullable = false, columnDefinition = "varchar(15) Check(status IN ('active','inactive'))")
//    @Pattern(regexp = "^[A|I]{1}$", message ="Must be Active or Inactive")
//    @Pattern(regexp = "^Active$|^Inactive$", message = "allowed input: active or inactive")
	private String connectionStatus;

    
   
	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Connection(int connectionId, Customer customer, Address address, ConnectionType connectionType,
			LocalDate applicationDate, LocalDate connectionDate, String connectionStatus) {
		super();
		this.connectionId = connectionId;
		this.customer = customer;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		return "Connection [connectionId=" + connectionId + ", customer=" + customer + ", address=" + address
				+ ", connectionType=" + connectionType + ", applicationDate=" + applicationDate + ", connectionDate="
				+ connectionDate + ", connectionStatus=" + connectionStatus + "]";
	}

	
    
      
}

		
