import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhotoManager manager = new PhotoManager();

        // Upload some Egyptian photos
        manager.uploadPhoto(new Photo(1, "pyramids.jpg", LocalDate.of(2023, 3, 10),
                "Giza", Set.of("pyramids", "history", "egypt", "tourism"), new Coordinate(50,50)));

        manager.uploadPhoto(new Photo(2, "nile.jpg", LocalDate.of(2023, 4, 22),
                "Cairo", Set.of("nile", "river", "sunset", "egypt"), new Coordinate(12,15)));

        manager.uploadPhoto(new Photo(3, "mosque.jpg", LocalDate.of(2023, 4, 22),
                "Cairo", Set.of("mosque", "islamic", "architecture", "egypt"), new Coordinate(20,20)));

        manager.uploadPhoto(new Photo(4, "museum.jpg", LocalDate.of(2023, 5, 15),
                "Cairo", Set.of("museum", "antiquities", "egypt", "pharaohs"), new Coordinate(20,30)));

        // Search by single tag
        System.out.println("Photos with tag 'egypt':");
        manager.searchByTag("egypt").forEach(System.out::println);
        System.out.println("Photos between Dates:");
        manager.getPhotosFromToDate(LocalDate.of(2023,3,10), LocalDate.of(2023,4,22))
                .forEach(System.out::println);
        // Search by date
        System.out.println("Photos taken on 2023-04-22:");
        manager.searchByDate(LocalDate.of(2023, 4, 22)).forEach(System.out::println);

        // Search by location
        System.out.println("Photos taken in Cairo:");
        manager.searchByLocation("Cairo").forEach(System.out::println);

        // Search by multiple tags
        System.out.println("Photos with tags [egypt, museum]:");
        manager.searchByMultipleTags(Set.of("egypt", "museum")).forEach(System.out::println);
    }
}