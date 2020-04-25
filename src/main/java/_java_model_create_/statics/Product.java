package _java_model_create_.statics;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 20:11
 */
public class Product {
    private String pA = "A";
    private String pB = "B";
    private String pC = "C";
    private String pD = "D";

    @Override
    public String toString() {
        return "Product{" +
                "pA='" + pA + '\'' +
                ", pB='" + pB + '\'' +
                ", pC='" + pC + '\'' +
                ", pD='" + pD + '\'' +
                '}';
    }

    public String getpA() {
        return pA;
    }

    public void setpA(String pA) {
        this.pA = pA;
    }

    public String getpB() {
        return pB;
    }

    public void setpB(String pB) {
        this.pB = pB;
    }

    public String getpC() {
        return pC;
    }

    public void setpC(String pC) {
        this.pC = pC;
    }

    public String getpD() {
        return pD;
    }

    public void setpD(String pD) {
        this.pD = pD;
    }
}
