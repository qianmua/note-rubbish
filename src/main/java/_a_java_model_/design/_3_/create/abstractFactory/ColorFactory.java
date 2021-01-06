package _a_java_model_.design._3_.create.abstractFactory;

import org.apache.commons.lang3.StringUtils;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  19:22
 * @description :
 */
public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        if (StringUtils.isEmpty(color))
            return null;

        if (color.equalsIgnoreCase("C_A"))
            return new C_A();

        if (color.equalsIgnoreCase("C_B"))
            return new C_B();

        if (color.equalsIgnoreCase("C_C"))
            return new C_C();

        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
