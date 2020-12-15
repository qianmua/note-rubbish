package _a_java_model_.design._3_.action.Iterator;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/15  14:51
 * @description :
 */
public class Main {

    /*
    迭代器模式


     */
    public static void main(String[] args) {
        NameRepository repository = new NameRepository();

        for (Iterator i = repository.getIterator() ; i.hasNext(); ){
            Object next = i.next();

            System.out.println("name : " + next);
        }
    }
}
