package _a_java_model_.design._3_.struct.bridge;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  10:50
 * @description :
 */
public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("green");
    }
}
