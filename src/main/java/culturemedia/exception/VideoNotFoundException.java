package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CultureMediaException {
    public VideoNotFoundException() {
        super("Video not found"); //TODO ACTUALIZAR MENSAJE
    }

    public VideoNotFoundException(String title) {
        super(MessageFormat.format("Invalid title for the video {0}", title));
    }

}