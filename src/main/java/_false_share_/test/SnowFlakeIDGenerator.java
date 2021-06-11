package _false_share_.test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/10  11:14
 */
public class SnowFlakeIDGenerator {
    public final Sequence SEQUENCE = new Sequence();

    public String generateId() {
        return String.valueOf(SEQUENCE.nextId());
    }

    public String generateId(Object... param) {
        return generateId();
    }
}
