package _class_filed_;

import com.baomidou.mybatisplus.annotations.TableField;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/22  15:21
 */
public class Convert {

    public <T> Map<String, Object> convertToMap(T t) {
        Map<String , Object> bilibili = new HashMap<>(8);

        // 内部类,如果是内部类需要去除掉外部类的字段引用
        boolean isMemberClass = t.getClass().isMemberClass();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                // 基本类型,基本类型默认值问题.
                //  这里 判断对基本类型无效
                // 取有值的;
                if (field.get(t) != null && StringUtils.isNotBlank(field.get(t).toString())) {
                    // 拿到mybatis plus 注解
                    // 数据库不需要的直接去掉
                    TableField annotation = field.getAnnotation(TableField.class);
                    if (Objects.nonNull(annotation)){
                        if (!annotation.exist()) {
                            continue;
                        }
                    }

                    BaseTypeEnum match = BaseTypeEnum.match(field.getType());
                    // 基本类型处理
                    if (match != BaseTypeEnum.EMPTY){
                        switch (match){
                            case INT:
                            case BYTE:
                            case CHAR:
                            case LONG:
                            case DOUBLE:
                            case FLOAT:
                            case SHOT:

                            default:
                                ;
                        }
                    }
                    if (isMemberClass){
                        // 过滤掉 final 修饰字段(内部内引用是final的,这里不好做判断)
                        if (Modifier.isFinal(field.getModifiers())) {
                            continue;
                        }
                    }
                    bilibili.put(field.getName() , field.get(t));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bilibili;
    }

}
