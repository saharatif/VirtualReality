package ippo.assignment2;

/**Interface and methods for the World Model-UUN-s2002073**/

import javafx.scene.image.Image;

import java.util.Set;

public interface iModel {
    void turn(Turn turn);
    void moveForward();
    void pickUp(String item);
    void putDown(String item);
    Image getCurrentImage();
    Set<Item> getItemsInRoom();
    Set<Item> getItemsCarried();

}
