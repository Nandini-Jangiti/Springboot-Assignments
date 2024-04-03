package com.ust.empapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String flatNo;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;


//    @JoinColumn(name = "id")
//    private Employee emp;

    public Address(Long addressId, String flatNo, String streetName, String city, String state, String zipCode, Employee emp) {
        this.addressId = addressId;
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

    }

    public Address() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    @Override
    public String toString() {
        return "Address{" +
                "id=" + addressId +
                ", flatNo='" + flatNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +

                '}';
    }
}
