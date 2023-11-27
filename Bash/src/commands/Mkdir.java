package commands;

import java.io.File;

public class Mkdir {    
    public static void mkdir(String path) {
            File directory = new File(path);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Verzeichnis erstellt: " + path);
            } else {
                System.err.println("Fehler beim Erstellen des Verzeichnisses: " + path);
            }
        } else {
            System.out.println("Verzeichnis existiert bereits: " + path);
        }
    }
}
    


