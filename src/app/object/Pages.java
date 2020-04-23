package app.object;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Pages {

    private @Setter @Getter String startedDateTime;
    private @Setter @Getter String id;
    private @Setter @Getter String title;
    private @Setter @Getter List<PageTimings> pageTimings;

}