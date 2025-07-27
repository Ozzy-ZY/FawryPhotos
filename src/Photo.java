import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Photo {
    private int id;
    private String path;
    private LocalDate date;
    private String locationName;
    private HashSet<String> tags;

    public Photo(int id, String path, LocalDate date, String locationName, Set<String> tags) {
        this.id = id;
        this.path = path;
        this.date = date;
        this.locationName = locationName;
        this.tags = new HashSet<>(tags);
    }
    public void AddTag(String tag) {
        tags.add(tag);
    }
    public void RemoveTag(String tag) {
        tags.remove(tag);
    }
    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = new HashSet<>(tags);
    }

    @Override
    public String toString() {
        return String.format("Photo %d, %s, %s, %s\n Tags: %s", id, path, date, locationName, tags.toString());
    }
}
