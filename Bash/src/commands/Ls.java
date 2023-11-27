package commands;

import java.io.File;

public class Ls {

    private Ls() {

    }

    public static void ls(String currentDirectroy) {
        File currentDir = new File(currentDirectroy);
        String[] fileList = currentDir.list();
        if (fileList != null) {
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        }
    }

}
