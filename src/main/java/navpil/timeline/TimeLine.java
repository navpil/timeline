package navpil.timeline;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import navpil.timeline.images.ImageHandler;
import navpil.timeline.music.MusicPlayer;

import static navpil.timeline.images.ImageHandlerFactory.getImageHandler;
import static navpil.timeline.music.MusicPlayerFactory.getMusicPlayer;

public class TimeLine extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        String root = "./resources";

        ImageHandler imageHandler = getImageHandler(root);
        MusicPlayer player = getMusicPlayer(root);

        Button next = new Button("Next");
        Button prev = new Button("Prev");

        ImageView imageView = new ImageView();
        player.playCurrentTrack();

        disableCorrectButtons(imageHandler, next, prev);
        imageView.setY(30);
        imageView.setPreserveRatio(true);

        next.setLayoutX(50);

        next.setOnAction(ev -> {
            Image nextImage = imageHandler.getNextImage();
            setImageWithResize(imageView, nextImage);
            player.playNextTrack();
            disableCorrectButtons(imageHandler, next, prev);

        });
        prev.setOnAction(ev -> {
            Image prevImage = imageHandler.getPrevImage();
            setImageWithResize(imageView, prevImage);
            player.playPreviousTrack();
            disableCorrectButtons(imageHandler, next, prev);
        });
        Group group = new Group(prev, next, imageView);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();

        this.stage = stage;
        this.stage.setMaximized(true);
        setImageWithResize(imageView, imageHandler.getCurrentImage());

    }

    private void setImageWithResize(ImageView imageView, Image nextImage) {
        double height = stage.getHeight() - 80;
        double width = stage.getWidth();

        if (height / width > nextImage.getHeight() / nextImage.getWidth()) {
            imageView.setFitWidth(width);
            imageView.setY((height - ((nextImage.getHeight() * (width / nextImage.getWidth())))) / 2);
            imageView.setX(0);
        } else {
            imageView.setFitHeight(height);
            imageView.setX((width - ((nextImage.getWidth() * (height / nextImage.getHeight())))) / 2);
            imageView.setY(30);
        }

        imageView.setImage(nextImage);
    }

    private void disableCorrectButtons(ImageHandler imageHandler, Button next, Button prev) {
        if (!imageHandler.hasNextImage()) {
            next.setDisable(true);
        } else {
            next.setDisable(false);
        }
        if (!imageHandler.hasPrevImage()) {
            prev.setDisable(true);
        } else {
            prev.setDisable(false);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
