package app.object;

import java.util.List;

public class PagesObject {
    private @Setter @Getter String startedDateTime;
    private @Setter @Getter String id;
    private @Setter @Getter String title;
    private @Setter @Getter List<PageTimingsObject> pageTimings;
}