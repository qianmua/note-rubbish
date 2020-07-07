package _a_java_model_.design._3_.struct.adapter;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  22:08
 * @description :
 */
public class ObjAdapter {

    /**
     *  持有 源 类  的 实例 而不是 直接 继承
     *  //
     *  符合 复用原则
     *  //
     *  用关系 代替 继承
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    // 被适配类
    class VO220{
        public int out220(){
            int v = 220;
            System.out.println(v + " /V");
            return v;
        }
    }

    // 适配 接口
    interface IVO5{
        int out5();
    }

    // 适配器
    class OAdapter implements IVO5{
        private VO220 vo220;

        public OAdapter(VO220 vo220) {
            this.vo220 = vo220;
        }

        @Override
        public int out5() {
            // 注意 小心 NPE
            int src = vo220.out220();
            // 处理
            src /= 5;
            return src;
        }
    }

    // 使用者
    class Phone{
        public void charging(IVO5 ivo5){
            if (ivo5.out5() == 5){
                System.out.println("适配");
            }else {
                System.out.println("fail <> 5 ");
            }
        }
    }
    // 使用 者
    class Client{
        public void use(){
            new Phone().charging(new OAdapter(new VO220()));
        }
    }

}

