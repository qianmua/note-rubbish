package _call_back_;


/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  10:30
 * @description :
 */
public class Tools {

    private Java7CallBack java7CallBack;

    public void setJava7CallBack(Java7CallBack java7CallBack) {
        this.java7CallBack = java7CallBack;
    }

    public void toolsCall(){
        int i = 10;
        while (i-- > 0)
            java7CallBack.sendMessage("message value :" + i);

    }
}
