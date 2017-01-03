package com.nilzxq.object;

/**
 * @author zxq @date 2017年1月3日
 *
 */
public class ContactInfo {

	 private String phone;
	    private String address;

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    @Override
	    public String toString() {
	        return "ContactInfo{" +
	                "phone='" + phone + '\'' +
	                ", address='" + address + '\'' +
	                '}';
	    }
}
