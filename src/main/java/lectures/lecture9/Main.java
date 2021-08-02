package lectures.lecture9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        try  {
            byte[] input = new byte[10];
            System.out.println(System.in.read(input));
            System.out.println(Arrays.toString(input));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("D:\\data_science");

        try {
            getRecursiveFileSystemTree(file, "");

            Files.walk(Path.of(file.getAbsolutePath())).forEach(System.out::println);

            Console c = System.console();

            if (c == null) {
                System.out.println("Console unavailable");
            } else {
                char[] psw = c.readPassword(); // available with command line
                System.out.println("Haha, I know your password: " + new String(psw));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getRecursiveFileSystemTree(File file, String offset) throws IOException {
        if (file.isFile()) {
            System.out.println(offset + " " +file.getName());
        } else {
            for (File child : Objects.requireNonNull(file.listFiles())) {
                System.out.println(offset + " " + file.getName());
                getRecursiveFileSystemTree(child, offset + " ");
            }
        }
    }
}
