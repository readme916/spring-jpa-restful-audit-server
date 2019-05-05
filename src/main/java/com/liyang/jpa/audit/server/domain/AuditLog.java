package com.liyang.jpa.audit.server.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liyang.jpa.audit.server.common.LinkType;


@Document(collection="logs")
public class AuditLog {

	@Id
	private String id;
	private String application;
	@Indexed
	private String requestPath;
	private String createdBy;
	private Date createdAt;
	private String client;
	private String ip;
	private String latitude;
	private String longitude;
	private String province;
	private String city;
	private String district;
	private String imei;
	private String event;
	private LinkType linkType;
	private String resource;
	@Indexed
	private String uuid;
	
	private String subResource;
	private String subResourceId;
	private Map<String,Object> postBody;
	

	private Map difference;
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map getDifference() {
		return difference;
	}

	public void setDifference(Map difference) {
		this.difference = difference;
	}


	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getSubResource() {
		return subResource;
	}

	public void setSubResource(String subResource) {
		this.subResource = subResource;
	}

	public String getSubResourceId() {
		return subResourceId;
	}

	public void setSubResourceId(String subResourceId) {
		this.subResourceId = subResourceId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}


	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}



	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}


	public Map<String,Object> getPostBody() {
		return postBody;
	}

	public void setPostBody(Map<String,Object> postBody) {
		this.postBody = postBody;
	}

	
}
