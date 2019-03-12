package navpil.timeline.images;

class FileSystemImageHandler extends AbstractFSImageHandler implements ImageHandler {

    FileSystemImageHandler(String root) {
        super(root);
    }

    @Override
    protected String getFileName(int counter) {
        return "" + (counter) + ".jpg";
    }

}
