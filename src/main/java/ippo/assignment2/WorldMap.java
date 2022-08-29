package ippo.assignment2;
/**Initialization of the rooms, items-UUN-s2002073**/
import javafx.scene.image.Image;

import java.util.Set;

public class WorldMap {
    private Room livingRoom;
    private Room corridor;
    private Room kitchen;
    private Room bedroom;

    public WorldMap(){
        livingRoom = constructRoom(new Room(), new Image("LR-Front.jpg"),
                new Image("LR-Left.jpg"), new Image("LR-Right.jpg"), new Image("LR-Back.jpg"));
        corridor = constructRoom(new Room(), new Image("CR-Front.jpg"),
                new Image("CR-Left.jpg"), new Image("CR-Right.jpg"), new Image("CR-Back.jpg"));
        kitchen = constructRoom(new Room(), new Image("KT-Front.jpg"),
                new Image("KT-Left.jpg"), new Image("KT-Right.jpg"), new Image("KT-Back.jpg"));
        bedroom = constructRoom(new Room(), new Image("BD-Front.jpg"),
                new Image("BD-Left.jpg"), new Image("BD-Right.jpg"), new Image("BD-Back.jpg"));

        livingRoom.getWalls().get(Direction.EAST).setRoom(corridor);
        corridor.getWalls().get(Direction.NORTH).setRoom(kitchen);
        corridor.getWalls().get(Direction.WEST).setRoom(livingRoom);
        kitchen.getWalls().get(Direction.SOUTH).setRoom(corridor);
        bedroom.getWalls().get(Direction.WEST).setRoom(corridor);
        corridor.getWalls().get(Direction.EAST).setRoom(bedroom);

        livingRoom.getItems().add(new Item("basket",new Image("basket.png")));
        livingRoom.getItems().add(new Item("laptop",new Image("laptop.png")));
        corridor.getItems().add(new Item("glasses",new Image("glasses.png")));
        corridor.getItems().add(new Item("hat",new Image("hat.png")));
        kitchen.getItems().add(new Item("skype",new Image("skype.png")));
        kitchen.getItems().add(new Item("pipe",new Image("pipe.png")));
        bedroom.getItems().add(new Item("camera",new Image("camera.png")));
        bedroom.getItems().add(new Item("bow",new Image("bow.png")));
    }

    public Room getInitialRoom(){
        return this.livingRoom;
    }
    public Set<Item> getInitialSet() { return this.livingRoom.getItems();}

    private Room constructRoom(Room room, Image front, Image left, Image right, Image back){
        room.getWalls().put(Direction.NORTH, new Wall(front, room));
        room.getWalls().put(Direction.WEST, new Wall(left, room));
        room.getWalls().put(Direction.SOUTH, new Wall(back, room));
        room.getWalls().put(Direction.EAST, new Wall(right, room));
        return room;
    }

}
