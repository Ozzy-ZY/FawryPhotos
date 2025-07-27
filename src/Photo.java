import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
public class Photo {
    private final int id;
    private String path;
    private final LocalDate date;
    private HashSet<String> tags;
    private final Coordinate coordinate;

    public Photo(int id, String path, LocalDate date, String locationName, Set<String> tags, Coordinate coordinate) {
        this.id = id;
        this.path = path;
        this.date = date;
        this.tags = new HashSet<>(tags);
        this.coordinate = coordinate;
    }
    public Coordinate getCoordinate() {
        return coordinate;
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

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = new HashSet<>(tags);
    }

    @Override
    public String toString() {
        return String.format("Photo %d, %s, %s,\n Tags: %s", id, path, date, tags.toString());
    }
}
