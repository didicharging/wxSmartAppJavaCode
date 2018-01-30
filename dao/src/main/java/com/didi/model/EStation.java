package com.didi.model;


public class EStation  implements Comparable<EStation>{
    private String id;

    private String name;

    private String user;

    @Override
	public String toString() {
		return "EStation [id=" + id + ", name=" + name + ", address=" + address + ", distance=" + distance + "]";
	}

	private Double longitude;

    private Double latitude;

    private String address;

    private String phone;
    
    private int distance;
    
  
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
    
    
    
	@Override
	 public int compareTo(EStation o) { 

	  int flag = (int) (this.distance - o.distance); 

	  return flag; 
	 }  
    
    
    
    
    
    
}