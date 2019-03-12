package navpil.timeline.music;

class FileSystemMusicPlayer extends AbstractFSMusicPlayer {

    FileSystemMusicPlayer(String root) {
        super(root);
    }

    @Override
    protected String getTrackName(int counter)    {
        return counter + ".mp3";
    }
}
