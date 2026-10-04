package com.github.bibek77.dsa.designPrinciples.lsp3;

/**
 * @author bibek
 */
public class Main {
    public static void main(String[] args) {
        WritableFile writableFile = new WritableFile();
        writableFile.write();
        writableFile.read();


        ReadableFile readableFile = new ReadableFile();
        readableFile.read();

        readAnyFile(readableFile);
        readAnyFile(writableFile);

    }

    public static void readAnyFile(ReadableFile readableFile) {
        readableFile.read();
    }
}
