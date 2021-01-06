package _a_java_model_.design._3_.create.abstractFactory;

import org.apache.commons.lang3.StringUtils;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  19:21
 * @description :
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (StringUtils.isEmpty(shape))
            return null;

        if (shape.equalsIgnoreCase("A"))
            return new A();
        if (shape.equalsIgnoreCase("B"))
            return new B();
        if (shape.equalsIgnoreCase("C"))
            return new C();

        return null;
    }
}
