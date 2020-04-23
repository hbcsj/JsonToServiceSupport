package app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/jjingun/Documents/GitHub/JsonToServiceSupport/src/temp/www.google.com.json");
        if (file.exists()) {
            System.out.println(file.getName());

            String content = null;
            try {
                content = FileUtils.readFileToString(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(content);
        }

    }
}