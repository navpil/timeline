package navpil.timeline.images;

import javafx.scene.image.Image;

public interface ImageHandler {

    boolean hasNextImage();
    boolean hasPrevImage();
    Image getNextImage();
    Image getPrevImage();

    Image getCurrentImage();
}
