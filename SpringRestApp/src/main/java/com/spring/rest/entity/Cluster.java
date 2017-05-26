package com.spring.rest.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Cluster implements Serializable {

	private static final long serialVersionUID = -5885375142033606194L;
	
	private String id;
	private String name;
	private String description;
	private String status;
	private Date createdAt;
	private Date updatedAt;
	private String createdAtRackspace;
    private String latitudeOrigin;
    private String longitudeOrigin;
    private String latitudeSize;
    private String longitudeSize;
    private String deltaYLatitude;
    private String deltaXLongitude;
    private boolean openStack;
	
	public Cluster() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cluster(String id, String name, String description, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}

	

	public Cluster(String id, String name, String description, String status,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

		

	public String getCreatedAtRackspace() {
		return createdAtRackspace;
	}



	public void setCreatedAtRackspace(String createdAtRackspace) {
		this.createdAtRackspace = createdAtRackspace;
	}



	public String getLatitudeOrigin() {
		return latitudeOrigin;
	}



	public void setLatitudeOrigin(String latitudeOrigin) {
		this.latitudeOrigin = latitudeOrigin;
	}



	public String getLongitudeOrigin() {
		return longitudeOrigin;
	}



	public void setLongitudeOrigin(String longitudeOrigin) {
		this.longitudeOrigin = longitudeOrigin;
	}



	public String getLatitudeSize() {
		return latitudeSize;
	}



	public void setLatitudeSize(String latitudeSize) {
		this.latitudeSize = latitudeSize;
	}



	public String getLongitudeSize() {
		return longitudeSize;
	}



	public void setLongitudeSize(String longitudeSize) {
		this.longitudeSize = longitudeSize;
	}



	public String getDeltaYLatitude() {
		return deltaYLatitude;
	}



	public void setDeltaYLatitude(String deltaYLatitude) {
		this.deltaYLatitude = deltaYLatitude;
	}



	public String getDeltaXLongitude() {
		return deltaXLongitude;
	}



	public void setDeltaXLongitude(String deltaXLongitude) {
		this.deltaXLongitude = deltaXLongitude;
	}



	public boolean isOpenStack() {
		return openStack;
	}



	public void setOpenStack(boolean openStack) {
		this.openStack = openStack;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatedAt() {
		if(createdAt==null)
		{
			createdAt=getDate();
			System.out.println(createdAt);
		}
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		if(updatedAt==null)
		{
			updatedAt=getDate();
			
		}
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		
		this.updatedAt = updatedAt;
	}
	
	private Date getDate()
	{
		Date now=new Date();
		return new Date(now.getTime());
	}



	@Override
	public String toString() {
		return "Cluster [id=" + id + ", name=" + name + ", description="
				+ description + ", status=" + status + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
