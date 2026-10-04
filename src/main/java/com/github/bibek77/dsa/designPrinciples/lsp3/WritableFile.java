package com.github.bibek77.dsa.designPrinciples.lsp3;

/**
 * @author bibek
 */
public class WritableFile extends ReadableFile implements Writable {

    @Override
    public void write() {
        System.out.println("Writing to a file .....");
    }
}
