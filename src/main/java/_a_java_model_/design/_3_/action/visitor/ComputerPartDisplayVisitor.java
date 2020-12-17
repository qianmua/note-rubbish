package _a_java_model_.design._3_.action.visitor;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/17  16:34
 * @description :
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("A");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("B");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("C");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("E");
    }
}
