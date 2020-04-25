package _java_model_create_.factory;

import _java_model_create_.builder.Builder;
import _java_model_create_.builder.Pro;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 18:11
 */
public class Work extends Builder {

    private Pro pro;
    public Work(){
        pro = new Pro();
    }

    @Override
    public void meA() {
        pro.setProA("A");
        System.out.println("A");
    }

    @Override
    public void meB() {
        pro.setProB("B");
        System.out.println("B");
    }

    @Override
    public void meC() {
        pro.setProC("C");
        System.out.println("C");
    }

    @Override
    public void meD() {
        pro.setProD("D");
        System.out.println("D");
    }

    @Override
    public Pro getPro() {
        return pro;
    }
}
