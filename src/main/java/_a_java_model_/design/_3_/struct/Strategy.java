package _a_java_model_.design._3_.struct;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  22:35
 * @description :
 */
public class Strategy {
    /**
     * 策略模式
     * @param args
     */
    public static void main(String[] args) {

    }


    // 持有 了 alg 得引用
    private class Context{
        private Alg alg;

        public Context(Alg alg) {
            this.alg = alg;
        }

        void mm(){
            // 实现 加密
            this.alg.alg();
        }
    }

    private interface Alg{
        void alg();
    }

    private class MD5 implements Alg{

        @Override
        public void alg() {
            System.out.println("md5");
        }
    }
    private class MDs implements Alg{

        @Override
        public void alg() {
            System.out.println("md6");
        }
    }

}

