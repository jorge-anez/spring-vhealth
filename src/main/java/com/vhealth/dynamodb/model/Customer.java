package com.vhealth.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "CUSTOMER")
public class Customer {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String make;
    private String model;
    private String phoneNumber;
    private String vin;
    private String year;
    @DynamoDBHashKey(attributeName="CUSTOMER_ID")
    public String getId() {
        return id;
    }
    @DynamoDBAttribute(attributeName="EMAIL")
    public String getEmail() {
        return email;
    }
    @DynamoDBAttribute(attributeName="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
    @DynamoDBAttribute(attributeName="LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    @DynamoDBAttribute(attributeName="MAKE")
    public String getMake() {
        return make;
    }
    @DynamoDBAttribute(attributeName="MODEL")
    public String getModel() {
        return model;
    }
    @DynamoDBAttribute(attributeName="PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @DynamoDBAttribute(attributeName="VIN")
    public String getVin() {
        return vin;
    }
    @DynamoDBAttribute(attributeName="YEAR")
    public String getYear() {
        return year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
