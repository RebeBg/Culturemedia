package culturemedia.service;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll();
    void addView(View view);
    void addVideo(Video video) throws CultureMediaException;
}


