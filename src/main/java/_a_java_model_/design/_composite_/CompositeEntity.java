package _a_java_model_.design._composite_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/23  11:20
 * @description : 组合实体。
 */
public class CompositeEntity {

    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1 , String data2){
        cgo.setData(data1 , data2);
    }

    public String[] getData(){
        return cgo.getData();
    }
}
