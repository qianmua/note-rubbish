package _a_java_model_.design._3_.struct.adapter;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  21:52
 * @description :
 */
public class ClassAdapter {

    public static void main(String[] args) {

    }


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
class CAdapter extends VO220 implements IVO5{

    @Override
    public int out5() {
        int src = out220();
        // 处理
        src = 5;
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

