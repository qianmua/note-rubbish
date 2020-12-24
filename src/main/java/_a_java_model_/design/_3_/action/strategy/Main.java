package _a_java_model_.design._3_.action.strategy;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  15:54
 * @description :
 */
public class Main {

    /*
    策略模式
    应用实例： 1、诸葛亮的锦囊妙计，每一个锦囊就是一个策略。 2、旅行的出游方式，选择骑自行车、坐汽车，每一种旅行方式都是一个策略。
    3、JAVA AWT 中的 LayoutManager。
    优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
    缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
    使用场景： 1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，
    那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。 2、一个系统需要动态地在几种算法中选择一种。
     3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
    注意事项：如果一个系统的策略多于四个，就需要考虑使用混合模式，解决策略类膨胀的问题。
     */
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.call(11.0, ReChargeTypeEnum.BUSI_ACCOUNTS.getValue()));
    }
}
