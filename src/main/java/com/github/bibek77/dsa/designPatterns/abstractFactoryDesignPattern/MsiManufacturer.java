package com.github.bibek77.dsa.designPatterns.abstractFactoryDesignPattern;

/**
 * @author bibek
 */
public class MsiManufacturer extends Company {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
