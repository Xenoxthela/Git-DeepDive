package commands;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Cd {

    private Cd() {

    }

    public static void cd(String path, String currentDirectory) {
        File currentDir = new File(currentDirectory);
        String[] fileList = currentDir.list();
        if (Arrays.asList(fileList).contains(path)) {
            System.setProperty("user.dir", new File(path).getAbsolutePath());
            System.out.println("Directory changed to " + currentDirectory + "/" + path);
        } else if (path.equals("..")) {
            String parent = Paths.get(System.getProperty("user.dir")).getParent().toAbsolutePath().toString();
            System.setProperty("user.dir", parent);
        } else {
            System.out.println("No such file or directory");
        }
    }

}
