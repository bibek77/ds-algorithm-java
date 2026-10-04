package com.github.bibek77.dsa.designPrinciples.lsp3;

/**
 * @author bibek
 */
public class ReadableFile implements Readable {

    @Override
    public void read() {
        System.out.println("Read from a file");
    }
}
