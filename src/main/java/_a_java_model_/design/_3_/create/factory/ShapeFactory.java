package _a_java_model_.design._3_.create.factory;

import org.apache.commons.lang3.StringUtils;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  19:11
 * @description :
 */
public class ShapeFactory {

    public Shape getShape(String shapeName){
        if (StringUtils.isEmpty(shapeName))
            return null;

        if (shapeName.equalsIgnoreCase("A"))
            return new A();
        else if (shapeName.equalsIgnoreCase("B"))
            return new B();
        else if (shapeName.equalsIgnoreCase("C"))
            return new C();

        return null;
    }
}
