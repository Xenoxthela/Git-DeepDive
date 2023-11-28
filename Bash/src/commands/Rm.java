package commands;

import java.io.File;

public class Rm {

    private Rm() {
    }

    public static void rm(String path, boolean recursive, String currentDirectory) {
        File file = new File(currentDirectory, path);

        if (file.isDirectory()) {
            if (recursive) {
                deleteDirectory(file);
            } else {
                if (file.list().length == 0 && file.delete()) {
                    System.out.println("Deleted empty directory " + path);
                } else {
                    System.out.println("rm: cannot remove '" + path + "': Directory not empty");
                }
            }
        } else if (file.delete()) {
            System.out.println("Deleted " + path);
        } else {
            System.out.println("rm: cannot remove '" + path + "': No such file or directory");
        }
    }

    private static void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        dir.delete();
    }
}
