package ippo.assignment2;
/**Model Class to interact with the Virtual Controller**/
import javafx.scene.image.Image;

import java.util.Set;

public class WorldModel implements iModel{
    private Player player;
    private WorldMap worldMap;
    private Room currRoom;
    private Set<Item> livingRoomSet;

    public WorldModel(){
        worldMap = new WorldMap();
        currRoom = worldMap.getInitialRoom();
        livingRoomSet=worldMap.getInitialSet();
        player = new Player(currRoom, Direction.NORTH, livingRoomSet);
    }

    @Override
    public void turn(Turn turn) {
        player.turn(turn);
    }

    @Override
    public void moveForward() {
        player.moveForward();
    }

    @Override
    public void pickUp(String item) {
           player.pickUp(item);
    }

    @Override
    public void putDown(String itemName) {
        player.putDown(itemName);
    }

    @Override
    public Image getCurrentImage(){
        Direction direction = player.getCurrDirection();
        return player.getImage(direction);
    }
    @Override
    public Set<Item> getItemsInRoom(){
        return player.getItemsInRoom();
    }
    @Override
    public Set<Item> getItemsCarried(){
        return player.getItemsCarried();
    }

}
