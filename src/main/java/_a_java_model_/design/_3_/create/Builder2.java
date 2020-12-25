package _a_java_model_.design._3_.create;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  19:06
 * @description :
 */
public class Builder2 {

    private final String name;
    private final String address;
    private final Integer age;
    private final String tel;

    private Builder2(Builder builder) {
        name = builder.name;
        address = builder.address;
        age = builder.age;
        tel = builder.tel;
    }

    /**
     * builder model
     */
    public static void main(String[] args) {
        Builder2 build = new Builder("James").address("A").build();
        System.out.println(build.address);
        System.out.println(build.age);
        System.out.println(build.tel);
        System.out.println(build.name);
    }


    public static class Builder {
        private final String name;
        private String address;
        private Integer age;
        private String tel;

        public Builder(String name) {
            this.name = name;
        }

        /*public Builder name(String name) {
            this.name = name;
            return this;
        }*/

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;

        }

        public Builder tel(String tel) {
            this.tel = tel;
            return this;

        }

        public Builder2 build(){
            return new Builder2(this);
        }

    }

}

