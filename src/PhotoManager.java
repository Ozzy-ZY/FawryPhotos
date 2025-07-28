import java.time.LocalDate;
import java.util.*;

public class PhotoManager implements IPhotoManager {
    private List<Photo> photos;
    private HashMap<String, CityZone> cities;
    private TreeMap<LocalDate, ArrayList<Photo>> dateIndex;
    // I can also use a HashMap instead of the TreeMap to get better performance
    // but I used the b tree as it's the most used in DBs
    public PhotoManager() {
        this.photos = new ArrayList<>();
        this.cities = new HashMap<>();
        this.dateIndex = new TreeMap<>();
        cities.put("Cairo", new CityZone("Cairo", 20,20,15));
        cities.put("Giza", new CityZone("Giza", 50,50, 10));

    }
    @Override
    public void uploadPhoto(Photo photo) { // o(1) time
        if(dateIndex.containsKey(photo.getDate())) {
            dateIndex.get(photo.getDate()).add(photo);
        }
        else {
            ArrayList<Photo> indexEntry = new ArrayList<>();
            indexEntry.add(photo);
            dateIndex.put(photo.getDate(), indexEntry);
        }
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
    public List<Photo> SearchByDateIndexed(LocalDate date) {
        List<Photo> result = new ArrayList<>();
        if(dateIndex.containsKey(date)){
            result = dateIndex.get(date);
        }
        return result;
    }
    public List<Photo> getPhotosFromToDate(LocalDate fromDate, LocalDate toDate) {
        List<Photo> result = new ArrayList<>();
        var vals = dateIndex.subMap(fromDate, true, toDate, true).values();
        vals.forEach(result::addAll);
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
    public List<Photo> searchByMultipleTags(Set<String> tags) { // N * K k is the size of search Tags
        List<Photo> result = new ArrayList<>();
        for(Photo photo: photos) {
            if(photo.getTags().containsAll(tags)) {
                result.add(photo);
            }
        }
        return result;
    }
}
