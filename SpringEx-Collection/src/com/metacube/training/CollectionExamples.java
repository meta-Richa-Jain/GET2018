package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionExamples {

	List addressList;
	Set addressSet;
	Map addressMap;
	

	// a setter method to set List
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	// prints and returns all the elements of the list.
	public List getAddressList() {
		return addressList;
	}

	// a setter method to set Set
	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}

	// prints and returns all the elements of the Set.
	public Set getAddressSet() {
		return addressSet;
	}

	// a setter method to set Map
	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	// prints and returns all the elements of the Map.
	public Map getAddressMap() {
		return addressMap;
	}

	

}