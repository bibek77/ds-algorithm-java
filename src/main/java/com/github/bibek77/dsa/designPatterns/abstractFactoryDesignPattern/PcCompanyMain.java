package com.github.bibek77.dsa.designPatterns.abstractFactoryDesignPattern;

/**
 * @author bibek
 */
public class PcCompanyMain {
    public static void main(String[] args) {
        Company asusCompany = new AsusManufacturer();
        Monitor asusMonitor = asusCompany.createMonitor();
        Gpu asusGpu = asusCompany.createGpu();

        Company msiCompany = new MsiManufacturer();
        Gpu msiGpu = msiCompany.createGpu();
        Monitor msiMonitor = msiCompany.createMonitor();
    }
}
