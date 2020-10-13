package _2020_10_13_.JUC;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 */
public class Class06 {
    static class User{
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        //原子引用
        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        User z3 = new User(1,"张三");
        User l4 = new User(2,"李四");

        userAtomicReference.set(z3);

        System.out.println(userAtomicReference.compareAndSet(z3, l4) + "   " + userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(z3, l4) + "   " + userAtomicReference.get().toString());
    }
}
