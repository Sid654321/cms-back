package com.sst.entity;

import com.sst.utils.Entity;
import java.util.Date;



public class Tag extends Entity{


	private Integer id;

	private String tagName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}