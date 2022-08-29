package ippo.assignment2;
/**Room class with items and walls-UUN-s2002073*/
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Room implements iRoom {
    private Set<Item> items;
    private Map<Direction, Wall> walls;

    public Room() {
        this.items = new HashSet<>();
        this.walls = new HashMap<>();
    }

    public Room(Set<Item> items, HashMap<Direction, Wall> walls) {
        this.items = new HashSet(items);
        this.walls = new HashMap(walls);
    }
    public Set<Item> getItems()
    {
        return this.items;
    }

    public Map<Direction, Wall> getWalls() {
        return this.walls;
    }

    public void addWall(Direction direction, Wall wall){
        this.walls.put(direction, wall);
    }

    public Image getImage(Direction direction){
        return walls.get(direction).getImage();
    }
}
