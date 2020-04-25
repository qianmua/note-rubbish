package _java_model_create_.statics;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 20:17
 */
public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        //链式
        Product product = worker.getProduct();
        Product product1 = worker.builderA("哈哈哈").builderB("来了").getProduct();
        System.out.println(product);
        System.out.println(product1);
    }
}
