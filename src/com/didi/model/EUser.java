package com.didi.model;

import java.util.Date;

public class EUser {
	
	public static Integer MANAGER =97; 
	public static Integer CORPORATE=98;
	public static Integer CORPORATE_MANAGER=96;
	public static Integer NORMAL=1;	
	public static Integer CHARGEMAN=99;
	
    private String id;

    private String address;

    private Integer electric;

    private Integer orders;

    private String signature;

    private Integer state;

    private Date createTime;

    private String qrImg;

    private String invideUser;

    private String password;

    private String name;

    private String nickName;

    private Integer sex;

    private String phone;

    private String email;

    private Integer age;

    private String idCard;

    private Integer pubdicIdcardType;

    private String wechatId;

    private String carId;

    private String profileImage;

    private Integer role;

    private Date lastLoginTime;

    private String photo;

    private String walletId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getElectric() {
        return electric;
    }

    public void setElectric(Integer electric) {
        this.electric = electric;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getQrImg() {
        return qrImg;
    }

    public void setQrImg(String qrImg) {
        this.qrImg = qrImg == null ? null : qrImg.trim();
    }

    public String getInvideUser() {
        return invideUser;
    }

    public void setInvideUser(String invideUser) {
        this.invideUser = invideUser == null ? null : invideUser.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Integer getPubdicIdcardType() {
        return pubdicIdcardType;
    }

    public void setPubdicIdcardType(Integer pubdicIdcardType) {
        this.pubdicIdcardType = pubdicIdcardType;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage == null ? null : profileImage.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId == null ? null : walletId.trim();
    }
}