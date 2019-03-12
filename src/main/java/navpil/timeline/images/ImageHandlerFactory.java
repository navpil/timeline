package navpil.timeline.images;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageHandlerFactory {
    public static ImageHandler getImageHandler(String root) {
        ImageHandler imageHandler;
        Path imagesList = Paths.get(root).resolve("images.list");
        if (Files.exists(imagesList)) {
            try {
                imageHandler = new FileListImageHandler(root, Files.readAllLines(imagesList));
            } catch (IOException e) {
                imageHandler = new FileSystemImageHandler(root);
            }
        } else {
            imageHandler = new FileSystemImageHandler(root);
        }
        return imageHandler;
    }
}
