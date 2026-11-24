package studentrecords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

// saves and loads the student accounts in accounts.csv (username,password)
public class AccountStorage {

    // checks if the username is already taken
    public static boolean usernameExists(String username) throws IOException {
        for (String line : readLines()) {
            String[] p = line.split(",", -1);
            if (p.length >= 2 && p[0].equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    // checks if the username and password match an account in the file
    public static boolean checkLogin(String username, String password) throws IOException {
        for (String line : readLines()) {
            String[] p = line.split(",", -1);
            if (p.length >= 2 && p[0].equalsIgnoreCase(username) && p[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // adds a new account at the end of the file
    public static void save(String username, String password) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(username + "," + password);
        Files.write(Paths.get("accounts.csv"), lines,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    // reads all the lines, empty list if there is no file yet
    private static List<String> readLines() throws IOException {
        if (!Files.exists(Paths.get("accounts.csv"))) {
            return new ArrayList<>();
        }
        return Files.readAllLines(Paths.get("accounts.csv"));
    }
}
