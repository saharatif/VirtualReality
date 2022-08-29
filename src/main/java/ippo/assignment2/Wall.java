package ippo.assignment2;
/**Wall class to access the image associated**/
import javafx.scene.image.Image;

public class Wall {

    private Image image;
    private Room room;

    public Wall(Image image, Room room) {
        this.image = image;
        this.room = room;
    }

    public Wall(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
