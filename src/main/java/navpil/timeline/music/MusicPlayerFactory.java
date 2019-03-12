package navpil.timeline.music;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MusicPlayerFactory {

    public static MusicPlayer getMusicPlayer(String root) {
        MusicPlayer musicPlayer;
        Path imageList = Paths.get(root).resolve("songs.list");
        if (Files.exists(imageList)) {
            try {
                musicPlayer = new SongListMusicPlayer(root, Files.readAllLines(imageList));
            } catch (IOException e) {
                musicPlayer = new FileSystemMusicPlayer(root);
            }
        } else {
            musicPlayer = new FileSystemMusicPlayer(root);
        }
        return musicPlayer;
    }


}
