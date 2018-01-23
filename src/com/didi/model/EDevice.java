package com.didi.model;

import java.math.BigDecimal;
import java.util.Date;

public class EDevice {
	
	
	public static Integer RENTAL_BY_HOUR=1;
	public static Integer RENTAL_BY_DAY=2;
	public static Integer RENTAL_BY_MONTH=3;
	
	public static Integer ELECTRIC_LESS=1;
	public static Integer ELECTRIC_ENOUGH=2;
	public static Integer IN_CHARGEING=3;
	public static Integer DEVICE_BAD=99;
	public static Integer DEVICE_REPAIR=98;
	public static Integer DEVICE_NULL=100;
	
	public static Integer IN_READY=4;
	public static Integer IN_BUSY=5;
	
		
	public static Integer SALE=1;
	public static Integer NOT_SALE=2;	
		
	//有线充电宝
	public static Integer POWER_BACK=1; 
	
	//无线充电宝
	public static Integer WIRESS_POWER_BACK=2;
	
	public static Integer STARTER=3;
	
	//48V﮵��  battery
	public static Integer LI_BATTERY_48=4;
	
	//64V﮵��
	public static Integer  LI_BATTERY_64=5;
	
	//72V﮵��
    public static Integer LI_BATTERY_72=6;
	
	//48V�����
    public static Integer LI_BATTERY_CHARGE_48=7;
    
	//64V�����
    public static Integer LI_BATTERY_CHARGE_64=8;
        
	//72V�����
    public static Integer LI_BATTERY_CHARGE_72=9;
		
    private String id;

    private String deviceNo;

    private String userId;

    private String supplier;

    private String manager;

    private String owner;

    private String name;

    private Integer type;

    private String description;

    private Integer state;

    private BigDecimal shareMoney;

    private BigDecimal saveMoney;

    private String imgUrl;

    private Date createTime;

    private Date updateTime;

    private Integer rental;

    private BigDecimal price;

    private Integer rentalH;

    private Integer rentalM;

    private Integer rentalType;

    private Integer chargeDdb;

    private Integer isbuy;

    private Float kW;

    private Float kM;

    private Float kD;

    private Integer changeDdb;

    private String function;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getShareMoney() {
        return shareMoney;
    }

    public void setShareMoney(BigDecimal shareMoney) {
        this.shareMoney = shareMoney;
    }

    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRentalH() {
        return rentalH;
    }

    public void setRentalH(Integer rentalH) {
        this.rentalH = rentalH;
    }

    public Integer getRentalM() {
        return rentalM;
    }

    public void setRentalM(Integer rentalM) {
        this.rentalM = rentalM;
    }

    public Integer getRentalType() {
        return rentalType;
    }

    public void setRentalType(Integer rentalType) {
        this.rentalType = rentalType;
    }

    public Integer getChargeDdb() {
        return chargeDdb;
    }

    public void setChargeDdb(Integer chargeDdb) {
        this.chargeDdb = chargeDdb;
    }

    public Integer getIsbuy() {
        return isbuy;
    }

    public void setIsbuy(Integer isbuy) {
        this.isbuy = isbuy;
    }

    public Float getkW() {
        return kW;
    }

    public void setkW(Float kW) {
        this.kW = kW;
    }

    public Float getkM() {
        return kM;
    }

    public void setkM(Float kM) {
        this.kM = kM;
    }

    public Float getkD() {
        return kD;
    }

    public void setkD(Float kD) {
        this.kD = kD;
    }

    public Integer getChangeDdb() {
        return changeDdb;
    }

    public void setChangeDdb(Integer changeDdb) {
        this.changeDdb = changeDdb;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }
}