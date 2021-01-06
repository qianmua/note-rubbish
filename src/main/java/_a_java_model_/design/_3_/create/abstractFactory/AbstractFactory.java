package _a_java_model_.design._3_.create.abstractFactory;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  19:20
 * @description :
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
