package _a_java_model_._7_;

import org.apache.ibatis.annotations.Options;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/14
 * @time 21:37
 */
public class DependenceInversion1 {

    /**
     * 依赖倒转
     * */
}

interface Option{
    String info();
}

class Email implements Option {
    @Override
    public String info(){
        return "Email";
    }
}

class WeChat implements Option {
    @Override
    public String info(){
        return "weChat";
    }
}

class Test{
    public void use(Option option){
        option.info();
    }
}