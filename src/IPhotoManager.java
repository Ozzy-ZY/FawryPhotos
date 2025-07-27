import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IPhotoManager {
    void uploadPhoto(Photo photo);
    List<Photo> searchByTag(String tag);
    List<Photo> searchByDate(LocalDate date);
    List<Photo> searchByLocation(String locationName);
    List<Photo> searchByMultipleTags(Set<String> tags);
}
