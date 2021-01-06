package _clone_;

import java.io.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/31  17:25
 * @description :
 */
public class CloneUtils {

    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;

        // java7 菱形表达式
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(stream)) {

            oos.writeObject(obj);
            // new
            ByteArrayInputStream bais = new ByteArrayInputStream(stream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            cloneObj = (T) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }
}
