package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.service.CultureMediaService;
import culturemedia.service.Impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CultureMediaServiceImplTest {

    private CultureMediaService cultureMediaService;

    @BeforeEach
    void init() {
        VideoRepository videoRepository = new VideoRepositoryImpl();
        cultureMediaService = new CultureMediaServiceImpl(videoRepository);
    }

    private void createVideos (){
        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));


        for ( Video video : videos ) {
            cultureMediaService.save( video );
        }
    }


    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        createVideos();
        List<Video> videos = cultureMediaService.findAll();
        assertEquals(3, videos.size());
    }


    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findAll());
    }

    @Test
    void when_FindByTittle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("Movie");
        });
    }

    @Test
    void when_FindByTittle_videos_should_be_returned_successfully() throws VideoNotFoundException {
        var video = new Video("01","Duna","Pelicula",3.5);
        cultureMediaService.save( video );
        List<Video> videos = cultureMediaService.find("Duna");
        assertEquals(1, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find(1.5,2.0);
        });
    }

    @Test
    void when_FindByDuration_videos_should_be_returned_successfully() throws VideoNotFoundException {
        var video = new Video("01","Micky","Pelicula",3.5);
        cultureMediaService.save( video );
        List<Video> videos = cultureMediaService.find(2.5,3.5);
        assertEquals(1, videos.size());
    }

}