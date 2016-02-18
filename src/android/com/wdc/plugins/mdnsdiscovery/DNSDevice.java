package com.wdc.plugins.mdnsdiscovery;

/**
 * Copyright 2015 Western Digital Corporation. All rights reserved.
 */
public class DNSDevice {
    private String name;
    private String ipAddress;
    private String modelNumber;
    private String serialNumner;
    private String modelName;
    private String vendor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerialNumner() {
        return serialNumner;
    }

    public void setSerialNumner(String serialNumner) {
        this.serialNumner = serialNumner;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
