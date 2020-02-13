package com.geeksfarm.training.asynctaskexample.model;

import java.util.ArrayList;

public class Contact {

    private String name, gender;
    private ArrayList<Address> addresses;

    public Contact(String name, String gender, ArrayList<Address> addresses) {
        this.name = name;
        this.gender = gender;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public static class Address{
        private String addressName, detailAddress, city, postalCode;

        public Address(String addressName, String detailAddress, String city, String postalCode) {
            this.addressName = addressName;
            this.detailAddress = detailAddress;
            this.city = city;
            this.postalCode = postalCode;
        }

        public String getAddress() {
            return addressName;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public String getCity() {
            return city;
        }

        public String getPostalCode() {
            return postalCode;
        }
    }
}
