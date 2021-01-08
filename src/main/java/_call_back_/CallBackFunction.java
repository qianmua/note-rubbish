package _call_back_;

import java.util.Map;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  10:24
 * @description :
 */
@FunctionalInterface
public interface CallBackFunction {
    Map<String , String> execute();
}
