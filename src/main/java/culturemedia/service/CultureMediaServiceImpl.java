package culturemedia.service;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;

public class CultureMediaServiceImpl implements CultureMediaService {
    public List<Video> findAll() {
        // Implementación del método findAll()
    }

    public Video addVideo(Video video) throws CultureMediaException {
        if (video.gettitle() == null || video.gettitle().isEmpty()) {
            throw VideoNotFoundException("The video title cannot be null or empty.");
        }

        if (video.getduracion() <= 0) {
            throw DurationNotValidException("Video duration must be > 0.");
        }

        // Implementación del método addVideo(Video video)
    }
}



