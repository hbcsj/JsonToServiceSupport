package app;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.apache.commons.io.FileUtils;

import app.object.JsonData;

public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("./www.google.com.json");
        if (file.exists()) {
            String content = null;
            try {
                content = FileUtils.readFileToString(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            jsonToGson(content);
            jsonToJacson(content);
        }
    }

    public static void jsonToGson(String content) {
        try {
            JsonData jsonData = new Gson().fromJson(content, JsonData.class);

            for (JsonData.Log.Pages pages : jsonData.log.pages) {
                System.out.println("Url: " + pages.title);
            }

            for (JsonData.Log.Entries entries : jsonData.log.entries) {
                JsonData.Log.Entries.Response response = entries.response;
                System.out.println(String.format("Status: %s, StatusText: %s", response.status, response.statusText));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jsonToJacson(String content) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> map = mapper.readValue(content, HashMap.class);

            for (String key : map.keySet()) {
                // System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));

                // 최상위 루트
                HashMap<String, Object> logMap = (HashMap<String, Object>) map.get("log");
                // pages 데이터
                List<HashMap<String, Object>> pagesList = (List<HashMap<String, Object>>) logMap.get("pages");
                // entries 데이터
                List<HashMap<String, Object>> entriesList = (List<HashMap<String, Object>>) logMap.get("entries");

                for (HashMap<String, Object> pagesMap : pagesList) {
                    for (String keyHeader : pagesMap.keySet()) {
                        System.out.println(String.format("%s : %s", keyHeader, pagesMap.get(keyHeader)));
                    }

                    for (HashMap<String, Object> entriesMap : entriesList) {
                        HashMap<String, Object> responseMap = (HashMap<String, Object>) entriesMap.get("response");
                        System.out.println(String.format("Status: %s, StatusText: %s", responseMap.get("status"), responseMap.get("statusText")));
                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}