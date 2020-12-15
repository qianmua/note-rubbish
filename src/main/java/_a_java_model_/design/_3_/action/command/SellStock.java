package _a_java_model_.design._3_.action.command;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/15  14:26
 * @description :
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
