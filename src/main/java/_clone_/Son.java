package _clone_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/31  17:18
 * @description :
 */
@Data
@AllArgsConstructor
public class Son implements Serializable , Cloneable {

    private static final long serialVersionUID = 207987820575050876L;

    private String name;

    private Father father;

    @Override
    protected Son clone()  {
        Son c = null;
        try {
            c = (Son) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return c;
    }
}
