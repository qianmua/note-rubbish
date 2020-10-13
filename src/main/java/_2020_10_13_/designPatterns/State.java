package _2020_10_13_.designPatterns;

/**
 *状态模式
 * @author ACER
 */
public class State {
    public static void main(String[] args) {
        MyTvController myTvController = new MyTvController();
        myTvController.powerOn();
        myTvController.nextChannel();
        myTvController.preChannel();
        myTvController.turnOff();
        myTvController.turnOn();


        myTvController.powerOff();
        myTvController.turnOn();
        myTvController.turnOff();
        myTvController.preChannel();
        myTvController.nextChannel();
    }
}

interface TvState{
    void turnOn();
    void turnOff();
    void nextChannel();
    void preChannel();
}

class PowerOnState implements TvState{

    @Override
    public void turnOn() {
        System.out.println("调高音量！");
    }

    @Override
    public void turnOff() {
        System.out.println("降低音量！");
    }

    @Override
    public void nextChannel() {
        System.out.println("下一个频道！");
    }

    @Override
    public void preChannel() {
        System.out.println("上一个频道！");
    }
}

class PowerOffState implements TvState{

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void nextChannel() {

    }

    @Override
    public void preChannel() {

    }
}

interface TvController{
    void powerOn();
    void powerOff();
}

class MyTvController implements TvController , TvState{
    TvState tvState;

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }

    @Override
    public void powerOn() {
        System.out.println("开机！");
        setTvState(new PowerOnState());
    }

    @Override
    public void powerOff() {
        System.out.println("关机！");
        setTvState(new PowerOffState());
    }

    @Override
    public void turnOn() {
        tvState.turnOn();
    }

    @Override
    public void turnOff() {
        tvState.turnOff();
    }

    @Override
    public void nextChannel() {
        tvState.nextChannel();
    }

    @Override
    public void preChannel() {
        tvState.preChannel();
    }
}