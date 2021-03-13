package _2_demo_;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/8  19:26
 */
public class DemoLiangStream {

    //为了安全性，数据库不会存储用户手机号码, 只会存custoemrCode，
    //可以理解customerCode可以查询到手机号(通过CustomerService里面的getCustomerCodeFromApi方法)

    private static final String OLD_GROUP = "中年组";
    private static final String YONG_GROUP = "青年组";
    private List<User> userList1;

    @Before
    public void initVal(){
        userList1 = new ArrayList<User>(){{
            add(new User("1" , "1" ,18 , true , false));
            add(new User("2" , "1" ,123 , true , false));
            add(new User("3" , "1" ,11 , true , false));
            add(new User("4" , "1" ,32 , true , false));
            add(new User("5" , "1" ,43 , true , false));
            add(new User("6" , "1" ,11 , true , false));
        }};
    }

    @Test
    public void m1(){
        System.out.println(groupUser(userList1));
    }

    /**
     * 按照年龄分组, 30岁以下为"青年组", 30岁以上为"中年组", 过滤掉已删除(deleted=true)或不可用(enabled=false)用户
     */
    public Map<String, List<User>> groupUser(List<User> userList) {
        return userList
                .stream()
                .filter(uF -> !uF.getDeleted() && uF.getEnabled())
                .collect(Collectors
                        .groupingBy(uAge -> uAge.getAge() < 30 ? YONG_GROUP : OLD_GROUP));
    }

    /**
     * 按照年龄分组, 30岁以下为"青年组", 30岁以上为"中年组", 过滤掉已删除或不可用用户，并填充号码
     * 号码从CustomerService.getCustomerCodeFromApi 获取
     */
    public Map<String, List<User>> groupUserAndFillPhone(List<User> userList) {
        return userList
                .stream()
                .filter(uF -> !uF.getDeleted() && uF.getEnabled())
                .peek(uPhone -> {
                    String Phone = "";
//                    CustomerService.getCustomerCodeFromApi(uPhone.getCustomerCode) // getPhone
                    uPhone.setPhone(uPhone.getPhone());
                })
                .collect(Collectors
                        .groupingBy(uAge -> uAge.getAge() < 30 ? YONG_GROUP : OLD_GROUP));
    }
}

@Data
@AllArgsConstructor
class User {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 客户编号
     */
    private String customerCode;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 是否可用 true-可用状态 false-不可用
     */
    private Boolean enabled;
    /**
     * 是否已删除 true-已删除 false-未删除
     */
    private Boolean deleted;
}