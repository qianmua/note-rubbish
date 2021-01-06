package _a_java_model_.design._3_.create.abstractFactory;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  19:24
 * @description :
 */
public final class FactoryProducer {
    public static AbstractFactory getFactory(String choice){

        if (choice.equalsIgnoreCase("S"))
            return new ShapeFactory();

        if (choice.equalsIgnoreCase("A"))
            return new ColorFactory();

        return null;
    }

}
