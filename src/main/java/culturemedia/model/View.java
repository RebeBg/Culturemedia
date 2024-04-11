package culturemedia.model;
import java.time.LocalDateTime;

public record View(String userFullName, LocalDateTime starPlayingTime, Integer age, Video video) {
    @Override
    public String userFullName() {
        return userFullName;
    }

    @Override
    public LocalDateTime starPlayingTime() {
        return starPlayingTime;
    }

    @Override
    public Integer age() {
        return age;
    }

    @Override
    public Video video() {
        return video;
    }
}
