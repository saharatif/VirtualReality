package ippo.assignment2;
/**Room interface for Room Class-UUN-s2002073**/

import java.util.Map;
import java.util.Set;

public interface iRoom {
    Map<Direction, Wall> getWalls();
    Set<Item> getItems();
}
