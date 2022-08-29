package ippo.assignment2;
/**MyPojo class to set and get objects from the json file for the application-UUN-s2002073**/

import org.codehaus.jackson.annotate.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "Room"
})

public class MyPojo {
    @JsonProperty("Room")
    private List<Room> room = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Room")
    public List<Room> getRoom() {
        return room;
    }

    @JsonProperty("Room")
    public void setRoom(List<Room> room) {
        this.room = room;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonPropertyOrder({
            "Name",
            "Image"
    })
    public class Item {

        @JsonProperty("Name")
        private String name;
        @JsonProperty("Image")
        private String image;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("Name")
        public String getName() {
            return name;
        }

        @JsonProperty("Name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("Image")
        public String getImage() {
            return image;
        }

        @JsonProperty("Image")
        public void setImage(String image) {
            this.image = image;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
        @JsonPropertyOrder({
                "Name",
                "Item",
                "walls"
        })
        public class Room {

            @JsonProperty("Name")
            private String name;
            @JsonProperty("Item")
            private List<Item> item = null;
            @JsonProperty("walls")
            private List<Wall> walls = null;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            @JsonProperty("Name")
            public String getName() {
                return name;
            }

            @JsonProperty("Name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("Item")
            public List<Item> getItem() {
                return item;
            }

            @JsonProperty("Item")
            public void setItem(List<Item> item) {
                this.item = item;
            }

            @JsonProperty("walls")
            public List<Wall> getWalls() {
                return walls;
            }

            @JsonProperty("walls")
            public void setWalls(List<Wall> walls) {
                this.walls = walls;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }

        @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
        @JsonPropertyOrder({
                "Room",
                "Image",
                "Direction"
        })
        public class Wall {

            @JsonProperty("Room")
            private String room;
            @JsonProperty("Image")
            private String image;
            @JsonProperty("Direction")
            private String direction;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            @JsonProperty("Room")
            public String getRoom() {
                return room;
            }

            @JsonProperty("Room")
            public void setRoom(String room) {
                this.room = room;
            }

            @JsonProperty("Image")
            public String getImage() {
                return image;
            }

            @JsonProperty("Image")
            public void setImage(String image) {
                this.image = image;
            }

            @JsonProperty("Direction")
            public String getDirection() {
                return direction;
            }

            @JsonProperty("Direction")
            public void setDirection(String direction) {
                this.direction = direction;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }
    }
}

