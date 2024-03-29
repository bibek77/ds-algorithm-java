package com.github.bibek77.dsa.designPatterns.abstractFactoryDesignPattern;

/**
 * @author bibek
 */
public class AsusManufacturer extends Company {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
