package com.liyang.jpa.audit.server.domain;

import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liyang.jpa.audit.server.common.LinkType;
import com.liyang.jpa.audit.server.common.Operate;


@Document(collection="logs")
public class AuditLog {

	@Id
	private String id;
	private String application;
	@Indexed
	private String requestPath;
	private String createBy;
	private Date createAt;
	private Terminal terminal;
	private String ip;
	private String latitude;
	private String longitude;
	private String province;
	private String city;
	private String district;
	private String imei;
	private Operate operate;
	private LinkType linkType;
	private String ownerResource;
	@Indexed
	private String ownerUuid;
	private String uuid;
	private String postBody;
	private HashMap<String,DiffItem> difference;
	
	
	
	public Operate getOperate() {
		return operate;
	}

	public void setOperate(Operate operate) {
		this.operate = operate;
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

	public HashMap<String, DiffItem> getDifference() {
		return difference;
	}

	public void setDifference(HashMap<String, DiffItem> difference) {
		this.difference = difference;
	}

	public String getOwnerResource() {
		return ownerResource;
	}

	public void setOwnerResource(String ownerResource) {
		this.ownerResource = ownerResource;
	}

	public String getOwnerUuid() {
		return ownerUuid;
	}

	public void setOwnerUuid(String ownerUuid) {
		this.ownerUuid = ownerUuid;
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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


	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}




	public enum Terminal{
		ANDROID,IOS,WXWORK_DESK,WXWORK_MOBILE,WXPUBLIC_DESK,WXPUBLIC_MOBILE,BROWSER,ELECTRON,API
	}
	
	
}
