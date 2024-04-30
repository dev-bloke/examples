package com.meridal.examples.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HexFormat;

public class FileFinder {

    private static final String DIVIDER = "+--------------+-------------------------------------------------+" +
            "------+------+------+------+------+";
    private static final String TITLES = "| Offset       | Bytes                                           |" +
            " 512  | 1024 | 2048 | 4096 | 8192 |";
    private static final HexFormat hexFormat = HexFormat.ofDelimiter(" ").withUpperCase();
    private final String filename;
    private final String hex;

    public static void main(String[] args) {
        final FileFinder finder = new FileFinder(args);
        finder.run();
    }

    public FileFinder(final String[] parameter) {
        this.filename = parameter[0];
        this.hex = this.parseSearch(parameter);
    }

    public void run() {
        try (InputStream input = new FileInputStream(this.filename)) {
            this.searchFile(input);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    private String parseSearch(String[] input) {
        final int size = input.length;
        String space = "";
        final StringBuilder builder = new StringBuilder();
        for (int i = 1; i < size; i++) {
            builder.append(space);
            builder.append(input[i]);
            space = " ";
        }
        final String search = builder.toString();
        System.out.println("Searching for: " + search);
        return search;
    }

    private void printHeadings() {
        System.out.println(DIVIDER);
        System.out.println(TITLES);
        System.out.println(DIVIDER);
    }

    private void printFooter() {
        System.out.println(DIVIDER);
    }

    private void searchFile(final InputStream input) throws Exception {
        long offset = 0;
        boolean more = true;
        this.printHeadings();
        while (more) {
            final String next = this.nextSixteenBytes(input);
            if (next.isEmpty()) {
                more = false;
            } else {
                this.searchSixteenBytes(next, offset);
                offset += 16;
            }
        }
        this.printFooter();
    }

    private String nextSixteenBytes(final InputStream input) throws Exception {
        final byte[] buffer = new byte[16];
        final int bytesRead = input.read(buffer, 0, 16);
        final StringBuilder builder = new StringBuilder();
        if (bytesRead > 0) {
            final byte[] data = Arrays.copyOfRange(buffer, 0, bytesRead);
            builder.append(hexFormat.formatHex(data));
        }
        return builder.toString();
    }

    private void searchSixteenBytes(final String sixteen, final long offset) {
        if (sixteen.startsWith(this.hex) && (offset % 512 == 0)) {
            final String strOffset = String.format("%012d", offset);
            System.out.println("| " + strOffset + " | " + sixteen + " " +
                this.startOfBuffer(offset,512) +
                this.startOfBuffer(offset, 1024) +
                this.startOfBuffer(offset, 2048) +
                this.startOfBuffer(offset, 4096) +
                this.startOfBuffer(offset, 8192) + "|");
        }
    }

    private String startOfBuffer(final long offset, final long bufferSize) {
        return (offset % bufferSize == 0) ? "| Yes  " : "| No   ";
    }
}
