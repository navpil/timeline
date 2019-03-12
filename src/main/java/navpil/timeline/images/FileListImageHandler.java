package navpil.timeline.images;

import java.util.List;

class FileListImageHandler extends AbstractFSImageHandler {

    private final List<String> images;

    FileListImageHandler(String root, List<String> images) {
        super(root);
        this.images = images;
    }

    @Override
    protected String getFileName(int counter) {
        int index = counter - 1;
        if (0 <= index && index < images.size()) {
            return images.get(index);
        } else {
            return "noimage.jpg";
        }
    }
}
