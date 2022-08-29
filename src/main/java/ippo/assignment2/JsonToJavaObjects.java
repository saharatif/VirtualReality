package ippo.assignment2;
/**Json file to java object mapper class-UUN-s2002073**/
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonToJavaObjects {
    public static void main(String[] args) {
       InputStream inputStream1= JsonToJavaObjects.class.getClassLoader().getResourceAsStream("map.json");
        assert inputStream1 != null;
        Reader reader1=new InputStreamReader(inputStream1);
        ObjectMapper mapper=new ObjectMapper();
        try {
            MyPojo myPojo=mapper.readValue(reader1, MyPojo.class);
            System.out.println(myPojo.toString());
        }catch (JsonParseException e){
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


