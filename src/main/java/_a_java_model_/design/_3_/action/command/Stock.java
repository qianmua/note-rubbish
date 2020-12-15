package _a_java_model_.design._3_.action.command;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/15  14:22
 * @description :
 */
public class Stock {

    private String name = "asd";
    private Integer quantity = 10;

    public void buy(){
        System.out.println(" name  "+name + " quantity " + quantity + " bought");
    }

    public void sell(){
        System.out.println(" name  "+name + " quantity " + quantity + " sold");
    }


}
