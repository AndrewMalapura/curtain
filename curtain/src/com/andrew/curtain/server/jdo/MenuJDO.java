package com.andrew.curtain.server.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MenuJDO implements IsSerializable {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private int itemPosition; // position item
	@Persistent
	private String itemName; // name of item
	@Persistent
	private String itemIcon; // path to item icon

	public MenuJDO() {
	}

	public MenuJDO(int itemPosition, String itemName, String itemIcon) {
		super();
		this.itemPosition = itemPosition;
		this.itemName = itemName;
		this.itemIcon = itemIcon;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the itemPosition
	 */
	public int getItemPosition() {
		return itemPosition;
	}

	/**
	 * @param itemPosition
	 *            the itemPosition to set
	 */
	public void setItemPosition(int itemPosition) {
		this.itemPosition = itemPosition;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemIcon
	 */
	public String getItemIcon() {
		return itemIcon;
	}

	/**
	 * @param itemIcon
	 *            the itemIcon to set
	 */
	public void setItemIcon(String itemIcon) {
		this.itemIcon = itemIcon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemIcon == null) ? 0 : itemIcon.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPosition;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MenuJDO)) {
			return false;
		}
		MenuJDO other = (MenuJDO) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (itemIcon == null) {
			if (other.itemIcon != null) {
				return false;
			}
		} else if (!itemIcon.equals(other.itemIcon)) {
			return false;
		}
		if (itemName == null) {
			if (other.itemName != null) {
				return false;
			}
		} else if (!itemName.equals(other.itemName)) {
			return false;
		}
		if (itemPosition != other.itemPosition) {
			return false;
		}
		return true;
	}

}
