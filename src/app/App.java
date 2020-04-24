package app;

import java.io.File;
import java.io.IOException;

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

            try {
                JsonData jsonData = new Gson().fromJson(content, JsonData.class);

                for (JsonData.Log.Pages pages : jsonData.log.pages) {
                    System.out.println("Url: " + pages.title);
                }

                for (JsonData.Log.Entries entries : jsonData.log.entries) {
                    JsonData.Log.Entries.Response response = entries.response;
                    System.out.println(String.format("Status: %s, StatusText: %s", response.status, response.statusText));
                }

            //     ObjectMapper mapper = new ObjectMapper();
            //     HashMap<String, Object> map = mapper.readValue(content, HashMap.class);

            //     for (String key : map.keySet()) {
            //         // System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));

            //         // 최상위 루트
            //         HashMap<String, Object> logMap = (HashMap<String, Object>) map.get("log");
            //         // pages 데이터
            //         List<Pages> pagesList = (List<Pages>) logMap.get("pages");
            //         // entries 데이터
            //         List<HashMap<String, Object>> entriesList = (List<HashMap<String, Object>>) logMap.get("entries");

            //         for (Pages pages : pagesList) {
            //             System.out.println(pages.getTitle());
            //             System.out.println(pages.getPageTimings());
            //         }

            //         for (HashMap<String, Object> entriesMap : entriesList) {
            //             for (String keyHeader : entriesMap.keySet()) {
            //                 if ("response".equals(keyHeader)) {
            //                     System.out.println(String.format("%s : %s", keyHeader,
            //                     entriesMap.get(keyHeader)));
            //                 }
            //             }
            //         }
            //     }

            // } catch (JsonParseException e) {
            //     e.printStackTrace();
            // } catch (JsonMappingException e) {
            //     e.printStackTrace();
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}}