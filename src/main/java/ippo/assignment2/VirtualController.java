package ippo.assignment2;
/**Controller class for interaction between World model and view-UUN-s2002073**/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VirtualController {
    Group root;
    iModel model;

    public Double orgTranslateXA, orgTranslateYB, orgSceneXA, orgSceneYB;
    @FXML
    private ImageView roomImageView =new ImageView();
    @FXML
    private ImageView iv1, iv3,iv2;


    @FXML
    Menu pickupMenu, dropMenu,map,clear;
    public void leftButtonPressed(ActionEvent event) {
        model.turn(Turn.LEFT);
        roomImageView.setImage(model.getCurrentImage());
        showCurrentItems();
    }
    public void rightButtonPressed(ActionEvent event) {
        model.turn(Turn.RIGHT);
        roomImageView.setImage(model.getCurrentImage());
        showCurrentItems();
    }
    public void forwardButtonPressed(ActionEvent event) {
        model.moveForward();
        roomImageView.setImage(model.getCurrentImage());
        showCurrentItems();
        updateMenu();
    }
    public void initializeController(Group root) {
        this.root = root;
        model = new WorldModel();
        map.getItems().add(new MenuItem("Show Map"));
        clear.getItems().add(new MenuItem("Clear Map"));
        roomImageView.setImage(model.getCurrentImage());
        showCurrentItems();
        updateMenu();
    }
    private void showCurrentItems(){
        if(!model.getItemsInRoom().isEmpty())
            iv1.setImage(model.getItemsInRoom().iterator().next().getItem());
        else
            iv1.setImage(null);
    }
    public void updateMenu(){
        pickupMenu.getItems().clear();
        dropMenu.getItems().clear();
        model.getItemsInRoom().forEach(item -> pickupMenu.getItems().add(new MenuItem(item.getName())));
        model.getItemsCarried().forEach(item -> dropMenu.getItems().add(new MenuItem(item.getName())));
    }

    public void putDown(ActionEvent event) {
        MenuItem item = (MenuItem) event.getTarget();
        model.putDown(item.getText());
        dropMenu.getItems().remove(item);
        pickupMenu.getItems().add(item);
        showCurrentItems();
    }
    public void pickUp(ActionEvent event) {
        MenuItem item = (MenuItem) event.getTarget();
        model.pickUp(item.getText());
        pickupMenu.getItems().remove(item);
        dropMenu.getItems().add(item);
        showCurrentItems();
    }


    public void iv1Dragged(MouseEvent mouseEvent) {
        double offsetX = mouseEvent.getSceneX() - orgSceneXA;
        double offsetY = mouseEvent.getSceneY() - orgSceneYB;
        double newTranslateX = orgTranslateXA + offsetX;
        double newTranslateY = orgTranslateYB + offsetY;

        ((ImageView) (mouseEvent.getSource())).setTranslateX(newTranslateX);
        ((ImageView) (mouseEvent.getSource())).setTranslateY(newTranslateY);
    }

    public void iv1Pressed(MouseEvent mouseEvent) {
        orgSceneXA = mouseEvent.getSceneX();
        orgSceneYB = mouseEvent.getSceneY();
        orgTranslateXA = ((ImageView) (mouseEvent.getSource())).getTranslateX();
        orgTranslateYB = ((ImageView) (mouseEvent.getSource())).getTranslateY();
    }

    public void iv2Dragged(MouseEvent mouseEvent) {
        double offsetX = mouseEvent.getSceneX() - orgSceneXA;
        double offsetY = mouseEvent.getSceneY() - orgSceneYB;
        double newTranslateX = orgTranslateXA + offsetX;
        double newTranslateY = orgTranslateYB + offsetY;

        ((ImageView) (mouseEvent.getSource())).setTranslateX(newTranslateX);
        ((ImageView) (mouseEvent.getSource())).setTranslateY(newTranslateY);
    }

    public void iv2Pressed(MouseEvent mouseEvent) {
        orgSceneXA = mouseEvent.getSceneX();
        orgSceneYB = mouseEvent.getSceneY();
        orgTranslateXA = ((ImageView) (mouseEvent.getSource())).getTranslateX();
        orgTranslateYB = ((ImageView) (mouseEvent.getSource())).getTranslateY();
    }


    public void Map(ActionEvent event) {
   iv3.setImage(new Image("map.png"));
    }

    public void Clear(ActionEvent event) {
        iv3.setImage(null);
    }
}

