package navpil.timeline.images;

import javafx.scene.image.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class AbstractFSImageHandler implements ImageHandler {
    private final String root;
    private int counter;

    AbstractFSImageHandler(String root) {
        this.root = root;
        counter = 1;
    }

    @Override
    public boolean hasNextImage() {
        return Files.exists(Paths.get(root).resolve(getFileName(counter + 1)));
    }

    @Override
    public boolean hasPrevImage() {
        return Files.exists(Paths.get(root).resolve(getFileName(counter - 1)));
    }

    @Override
    public Image getNextImage() {
        counter++;
        return getCurrentImage();
    }

    @Override
    public Image getPrevImage() {
        counter--;
        return getCurrentImage();
    }

    @Override
    public Image getCurrentImage() {
        try {
            return new Image(Files.newInputStream(Paths.get(root).resolve(getFileName(counter))));
        } catch (IOException e) {
            return null;
        }
    }

    protected abstract String getFileName(int counter);

}
