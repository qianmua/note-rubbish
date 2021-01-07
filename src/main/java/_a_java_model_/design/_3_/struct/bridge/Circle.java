package _a_java_model_.design._3_.struct.bridge;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  10:52
 * @description :
 */
public class Circle extends Shape{

    protected Circle(DrawAPI drawAPI) {
        super(drawAPI);
        // init value

    }

    @Override
    public void draw() {
        super.drawAPI.drawCircle(1,2,3);
    }
}
