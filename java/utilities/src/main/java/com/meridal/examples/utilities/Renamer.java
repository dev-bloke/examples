package com.meridal.examples.utilities;

import java.io.File;
import java.util.*;

public class Renamer {

    private int prefix;
    private final Scanner input = new Scanner(System.in);

    public Renamer(final int prefix) {
        this.prefix = prefix;
    }

    public static void main(String[] args) {
        final int prefix = Integer.parseInt(args[0]) - 1;
        final Renamer renamer = new Renamer(prefix);
        renamer.run();
    }

    public void run() {
        final List<File> files = this.getFileList(".");
        this.rename(files);
    }

    private List<File> getFileList(final String dirName) {
        final List<File> files = new ArrayList<>();
        final File dir = new File(dirName);
        final List<String> fileNames = Arrays.asList(dir.list());
        Collections.sort(fileNames);
        for (final String fileName : fileNames) {
            files.add(new File(fileName));
        }
        return files;
    }

    private void rename(final List<File> files) {
        char current = 'a';
        int target = 0;
        int count = 0;
        for (final File file : files) {
            if (file.isFile()) {
                final String oldName = file.getName();
                if (!oldName.startsWith(".")) {
                    if (count == target) {
                        target = getNextTarget();
                        prefix++;
                        count = 0;
                        current = 'A';
                    }
                    final String suffix = oldName.substring(oldName.indexOf("."));
                    final String newName = Integer.toString(prefix) + current + suffix;
                    final File newFile = new File(newName);
                    System.out.println(oldName + " -> " + newName);
                    file.renameTo(newFile);
                    current++;
                    count++;
                }
            }
        }
    }

    private int getNextTarget() {
        System.out.print("How many next? ");
        String next = this.input.nextLine();
        return Integer.parseInt(next);
    }
}
