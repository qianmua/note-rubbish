package _class_filed_;

import java.util.Objects;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/22  15:08
 */
public enum BaseTypeEnum {
    BOOLEAN("Boolean", Boolean.class, "boolean", boolean.class),
    INT("Integer", Integer.class, "int", int.class),
    LONG("Long", Long.class, "long", long.class),
    BYTE("Byte", Byte.class, "byte", byte.class),
    SHOT("Short", Short.class, "short", short.class),
    CHAR("Character", Character.class, "char", char.class),
    DOUBLE("Double", Double.class, "double", double.class),
    FLOAT("Float", Float.class, "float", float.class),

    EMPTY(null, null, null, null),
    ;

    private final String wrapper;
    private final Class<?> wrapperClazz;
    private final String simple;
    private final Class<?> clazz;

    BaseTypeEnum(String wrapper, Class<?> wrapperClazz, String simple, Class<?> clazz) {
        this.wrapper = wrapper;
        this.wrapperClazz = wrapperClazz;
        this.simple = simple;
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Class<?> getWrapperClazz() {
        return wrapperClazz;
    }

    public String getSimple() {
        return simple;
    }

    public String getWrapper() {
        return wrapper;
    }


    public static BaseTypeEnum match(Class<?> clazz){
        if (Objects.isNull(clazz)){
            return EMPTY;
        }
        BaseTypeEnum[] values = BaseTypeEnum.values();
        for (BaseTypeEnum v : values) {
            if (v.getClazz() == clazz) {
                return v;
            }
        }
        return EMPTY;
    }
}
