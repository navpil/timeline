package navpil.timeline.music;

import java.util.List;

class SongListMusicPlayer extends AbstractFSMusicPlayer {

    private final List<String> songs;

    SongListMusicPlayer(String root, List<String> songList) {
        super(root);
        this.songs = songList;
    }

    @Override
    protected String getTrackName(int counter) {
        int index = counter - 1;
        if (0 <= index && index < songs.size()) {
            return songs.get(index);
        } else {
            return "nosong.mp3";
        }
    }
}
