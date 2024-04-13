package culturemedia.service;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll();
    void save(View view);
    void save(Video video) ;
}


