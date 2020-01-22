package Topics;

import java.time.LocalDate;

public class Topic {
    private static int idTemp;
    private final int id;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;

    public Topic(String title, String description, String additionalSource) {
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.creationDate = LocalDate.now();
        this.complete = false;
//toimiiko id, nollaa kun ohjelman sulkee?
        this.id = setId();
    }

    public int getId() {
        return this.id;
    }

    public int setId() {
        return this.idTemp++;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalSource() {
        return additionalSource;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", title: " + this.title + ", description: " + this.description;
/*
        return this.id + "\n"
                + this.title + "\n"
                + this.description + "\n"
                + this.additionalSource + "\n"
                + this.complete + "\n"
                + this.creationDate + "\n";
*/
    }
}