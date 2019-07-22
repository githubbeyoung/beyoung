package com.enjoy.domain;

import java.io.Serializable;

public class CodRegion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uuid;
	private Integer code;
	private Integer upcode;
	private String cname;
	private String description;
	private Character flag;
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getUpcode() {
		return upcode;
	}
	public void setUpcode(Integer upcode) {
		this.upcode = upcode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Character getFlag() {
		return flag;
	}
	public void setFlag(Character flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "CodRegion [uuid=" + uuid + ", code=" + code + ", upcode=" + upcode + ", cname=" + cname
				+ ", description=" + description + ", flag=" + flag + "]";
	}
	
	

}
