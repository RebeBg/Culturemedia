package culturemedia.repository;
import java.util.List;
import culturemedia.model.Video;
public interface VideoRepository {
    List<Video> findAll();
    Video addVideo(Video video);
    List<Video> find(String title) throws VideoNotFoundException;
    List<Video> find(Double fromDuration, Double toDuration) throws DurationNotValidException;

}
