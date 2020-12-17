package _a_java_model_.design._3_.action.visitor;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/17  15:22
 * @description :
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
