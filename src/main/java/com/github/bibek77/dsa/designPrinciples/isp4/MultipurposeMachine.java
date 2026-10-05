package com.github.bibek77.dsa.designPrinciples.isp4;

/**
 * @author bibek
 */
public class MultipurposeMachine  implements Scanner, Printer, Copier{
    @Override
    public void copyDoc(Document doc) {
        System.out.println("Copy Doc");
    }

    @Override
    public void print(Document doc) {
        System.out.println("Print doc");
    }

    @Override
    public void scan(Document doc) {
        System.out.println("Scan Doc");
    }
}
