package _java_model_create_.builder;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 18:09
 */
public class Pro {
    private String proA;
    private String proB;
    private String proC;
    private String proD;

    @Override
    public String toString() {
        return "Pro{" +
                "proA='" + proA + '\'' +
                ", proB='" + proB + '\'' +
                ", proC='" + proC + '\'' +
                ", proD='" + proD + '\'' +
                '}';
    }

    public String getProA() {
        return proA;
    }

    public void setProA(String proA) {
        this.proA = proA;
    }

    public String getProB() {
        return proB;
    }

    public void setProB(String proB) {
        this.proB = proB;
    }

    public String getProC() {
        return proC;
    }

    public void setProC(String proC) {
        this.proC = proC;
    }

    public String getProD() {
        return proD;
    }

    public void setProD(String proD) {
        this.proD = proD;
    }
}
