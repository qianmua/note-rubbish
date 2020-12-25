package _a_java_model_.design._3_.create.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/25  9:51
 * @description :
 */
public abstract class Pizza {
    // 参数
    public enum Topping {HAM , MUSHROOM , ONION , PEPPER , SAUSAGE}

    final Set<Topping> toppings;

    // Builder<T extends Builder<T>> 表示 自类型 // 递归类型参数
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));

            return self();
        }
        protected abstract T self();
        abstract Pizza build();
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}
