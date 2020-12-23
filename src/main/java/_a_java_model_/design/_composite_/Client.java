package _a_java_model_.design._composite_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/23  12:52
 * @description :
 */
public class Client {

    private CompositeEntity compositeEntity = new CompositeEntity();

    public void printData(){
        for (String datum : compositeEntity.getData()) {
            System.out.println(datum);
        }
    }
    public void setData(String data1 , String data2){
        compositeEntity.setData(data1, data2);
    }


}
