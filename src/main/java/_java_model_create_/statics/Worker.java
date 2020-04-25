package _java_model_create_.statics;


/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 20:12
 */
public class Worker extends Builder {
    private Product product;
    public Worker(){
        product = new Product();
    }
    @Override
    Builder builderA(String str) {
        product.setpA(str);
        return this;
    }

    @Override
    Builder builderB(String str) {
        product.setpB(str);
        return this;
    }

    @Override
    Builder builderC(String str) {
        product.setpC(str);
        return this;
    }

    @Override
    Builder builderD(String str) {
        product.setpD(str);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
