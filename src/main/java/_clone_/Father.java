package _clone_;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/31  17:18
 * @description :
 */
@AllArgsConstructor
@Data
public class Father implements Serializable {
    private static final long serialVersionUID = -6869191589601076370L;
    private String name;
}
