package _java8_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/23  10:21
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    // constructor/getter/setter/toString
}
