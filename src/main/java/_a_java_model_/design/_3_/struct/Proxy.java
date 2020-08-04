package _a_java_model_.design._3_.struct;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/8/4  22:25
 * @description :
 */
public class Proxy {

    public static void main(String[] args) {

    }

    interface Sub{
        void say();
    }

    static class SubRes implements Sub{

        @Override
        public void say() {
            System.out.println("A");
        }
    }



    static class Proxy2 implements Sub{

        private SubRes subRes;

        public void setSubRes(SubRes subRes) {
            this.subRes = subRes;
        }

        @Override
        public void say() {
            this.zhekou();
            this.subRes.say();
            jifen();
        }

        public void zhekou(){
            System.out.println("折扣");
        }

        public void jifen(){
            System.out.println("jifen");
        }
    }


}
