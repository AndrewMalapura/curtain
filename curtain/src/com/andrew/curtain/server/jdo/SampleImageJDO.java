package com.andrew.curtain.server.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.gwt.user.client.rpc.IsSerializable;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SampleImageJDO implements IsSerializable {
   
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String imageName;
	@Persistent
	private int categoryId;
	@Persistent
	private Blob img;
	
	// default constructor
	public SampleImageJDO() {}
	
	public SampleImageJDO(Key key, String imageName, int categoryId, Blob img) {
		this.key = key;
		this.imageName = imageName;
		this.categoryId = categoryId;
		this.img = img;
	}

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the img
	 */
	public Blob getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(Blob img) {
		this.img = img;
	}
	
	
}
