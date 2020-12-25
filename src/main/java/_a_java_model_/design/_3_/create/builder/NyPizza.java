package _a_java_model_.design._3_.create.builder;

import java.util.Objects;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/25  9:58
 * @description :
 */
public class NyPizza extends Pizza{

    public enum Size {SMALL , MEDIUM , LARGE};

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }


        @Override
        protected Builder self() {
            return this;
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

}
