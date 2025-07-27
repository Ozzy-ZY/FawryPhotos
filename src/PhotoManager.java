import java.time.LocalDate;
import java.util.*;

public class PhotoManager implements IPhotoManager {
    private List<Photo> photos;
    private HashMap<String, CityZone> cities;
    public PhotoManager() {
        this.photos = new ArrayList<>();
        this.cities = new HashMap<>();
        cities.put("Cairo", new CityZone("Cairo", 20,20,15));
        cities.put("Giza", new CityZone("Giza", 50,50, 10));

    }
    @Override
    public void uploadPhoto(Photo photo) { // o(1) time
        photos.add(photo);
    }

    @Override
    public List<Photo> searchByTag(String tag) { // O(N) time
        List<Photo> result = new ArrayList<>();
        for(Photo photo: photos) {
            if(photo.getTags().contains(tag)) {
                result.add(photo);
            }
        }
        return result;
    }

    @Override
    public List<Photo> searchByDate(LocalDate date) { // O(N)
        List<Photo> result = new ArrayList<>();
        for(Photo photo: photos) {
            if(photo.getDate().equals(date)) {
                result.add(photo);
            }
        }
        return result;
    }

    @Override
    public List<Photo> searchByLocation(String locationName) { // O(N)
        List<Photo> result = new ArrayList<>();
        var cityZone = cities.get(locationName);
        if(cityZone == null) {
            return result;
        }
        result = photos.stream().filter(photo -> cityZone.inRange(photo.getCoordinate())).toList();
        return result;
    }

    @Override
    public List<Photo> searchByMultipleTags(Set<String> tags) { //
        List<Photo> result = new ArrayList<>();
        for(Photo photo: photos) {
            if(photo.getTags().containsAll(tags)) {
                result.add(photo);
            }
        }
        return result;
    }
}
