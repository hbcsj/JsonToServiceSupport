package app.object;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class JsonData {

    @SerializedName("log")
    public Log log;

    public class Log {
        @SerializedName("pages")
        public List<Pages> pages;

        @SerializedName("entries")
        public List<Entries> entries;

        public class Pages {
            @SerializedName("title")
            public String title;
        }

        public class Entries {
            @SerializedName("response")
            public Response response;

            public class Response {
                @SerializedName("status")
                public String status;

                @SerializedName("statusText")
                public String statusText;
            }
        }
    }
}