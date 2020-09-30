package _a_java_model_.design._3_.action.concrete2;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  19:40
 * @description :
 */
public class DeptManager extends Handler {
    @Override
    public String handleFeeRequest(String u, double m) {
        String s = "";
        if (m < 1000){
            /// b可以处理
            if ("A".equals(u)){
                s = "B处理SUCCESS" + u + "的要求,值为" + m;
            }else {
                s = "B处理FAIL" + u + "的要求,值为" + m;
            }
        }else {
            // 下一责任链
            if (super.getSuccessor() != null){
                return successor.getSuccessor().handleFeeRequest(u , m);
            }
        }
        return s;
    }
}
