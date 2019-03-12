package navpil.timeline.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

abstract class AbstractFSMusicPlayer implements MusicPlayer {

    private final String root;
    private int counter;
    private MediaPlayer mediaPlayer;


    AbstractFSMusicPlayer(String root) {
        this.root = root;
        counter = 1;
    }

    @Override
    public void playNextTrack() {
        counter++;
        playCurrentTrack();
    }

    @Override
    public void playPreviousTrack() {
        counter--;
        playCurrentTrack();
    }

    @Override
    public void replayTrack() {
        playCurrentTrack();
    }

    @Override
    public void playCurrentTrack() {
        stopTrack();
        Path currentTrack = getCurrentTrack();
        if(!Files.exists(currentTrack)){
            return;
        }
        mediaPlayer = new MediaPlayer(new Media(currentTrack.toUri().toString()));
        mediaPlayer.play();
    }

    private Path getCurrentTrack() {
        return Paths.get(root).resolve(getTrackName(counter));
    }

    protected abstract String getTrackName(int counter);

    @Override
    public void stopTrack() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

}
