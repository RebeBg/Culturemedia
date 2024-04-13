package culturemedia.service;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;

public class CultureMediaServiceImpl implements CultureMediaService {
    public List<Video> findAll() {
    }

    public Video addVideo(Video video) throws CultureMediaException {
        if (video.gettitle() == null || video.gettitle().isEmpty()) {
            throw VideoNotFoundException("The video title cannot be null or empty.");
        }

        if (video.getduracion() <= 0) {
            throw DurationNotValidException("Video duration must be > 0.");
        }

    }
}



