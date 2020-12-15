package _a_java_model_.design._3_.action.command;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/15  14:29
 * @description :
 */
public class Main {

    // 命令模式
    /*
    将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
    在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，但某些场合，
    比如需要对行为进行记录、撤销或重做、事务等处理时，这种无法抵御变化的紧耦合的设计就不太合适。

    在某些场合，比如要对行为进行"记录、撤销/重做、事务"等处理，这种无法抵御变化的紧耦合是不合适的。
    在这种情况下，如何将"行为请求者"与"行为实现者"解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。


    如何解决：通过调用者调用接受者执行命令，顺序：调用者→命令→接受者。

     */
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}
