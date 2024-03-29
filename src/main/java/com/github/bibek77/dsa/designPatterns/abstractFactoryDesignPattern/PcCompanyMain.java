package com.github.bibek77.dsa.designPatterns.abstractFactoryDesignPattern;

/**
 * @author bibek
 */
public class PcCompanyMain {
    public static void main(String[] args) {
        Company asusCompany = new AsusManufacturer();
        asusCompany.createMonitor();
        asusCompany.createGpu();

        Company msiCompany = new MsiManufacturer();
        msiCompany.createGpu();
        msiCompany.createMonitor();
    }
}
