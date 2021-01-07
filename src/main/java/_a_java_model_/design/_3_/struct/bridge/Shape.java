package _a_java_model_.design._3_.struct.bridge;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  10:51
 * @description :
 */
public abstract class Shape {

    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
