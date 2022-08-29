package ippo.assignment2;
/**Player class to move from room to room and moving objects-UUN-s2002073**/
import javafx.scene.image.Image;
import java.util.*;

public class Player {
    private Room room = new Room();
    private Direction currDirection;
    private HashSet<Item> carriedItems;

    public Player() {
        this.room = new Room();
        this.carriedItems = new HashSet();
    }

    public Player(Room room, Direction currDirection, Set<Item> items) {
        this.room = room;
        this.currDirection = currDirection;
        this.carriedItems = new HashSet();
    }

    public void turn(Turn turn) {
        this.currDirection = getNewPosition(turn);
    }

    public Room getRoom() {
        return this.room;
    }

    public void moveForward() {
        Room nextRoom = room.getWalls().get(currDirection).getRoom();
        if(!nextRoom.equals(room)){
            this.room = nextRoom;
        }
        else System.out.println("Not an Exit!!");
    }

    public void pickUp(String itemName) {
        for(Item currItem: room.getItems()){
            if(currItem.getName().equals(itemName)) {
                carriedItems.add(currItem);
                room.getItems().remove(currItem);
                return;
            }
        }
    }

    public void putDown(String itemName) {
        Iterator<Item> iterator = carriedItems.iterator();
        while(iterator.hasNext()){
            Item currItem = iterator.next();
            if(currItem.getName().equals(itemName)) {
                room.getItems().add(currItem);
                carriedItems.remove(currItem);
                return;
            }
        }
    }

    public Image getImage(Direction direction) {
        return this.room.getImage(direction);
    }

    public Set<Item> getItemsCarried() {

        return carriedItems;
    }

    public Set<Item> getItemsInRoom() {
        return room.getItems();
    }

    public Direction getCurrDirection() {
        return currDirection;
    }


    private boolean canMove(){
        return room.getWalls().get(currDirection).getRoom().equals(room);
    }


    private Direction getNewPosition(Turn turn) {
        if (turn == Turn.LEFT) {
            switch (currDirection) {
                case NORTH:
                    return Direction.WEST;
                case WEST:
                    return Direction.SOUTH;
                case SOUTH:
                    return Direction.EAST;
                case EAST:
                    return Direction.NORTH;
            }
        }
        else if (turn == Turn.RIGHT){
            switch (currDirection) {
                case NORTH:
                    return Direction.EAST;
                case WEST:
                    return Direction.NORTH;
                case SOUTH:
                    return Direction.WEST;
                case EAST:
                    return Direction.SOUTH;
            }

        }
        return null;
        }
    }
