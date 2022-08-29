package ippo.assignment2;
/**Item class for each item in the Room-UUN-s2002073**/
import javafx.scene.image.Image;

public class Item {
    private Image item;
    private String name;

    public Item(String name,Image item ) {
        this.item = item;
        this.name = name;
    }

    public Image getItem() {
        return item;
    }

    public void setItem(Image item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}