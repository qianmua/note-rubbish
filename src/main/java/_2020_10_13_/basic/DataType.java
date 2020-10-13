package _2020_10_13_.basic;

/**
 * 变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。
 * 内置数据类型(基本数据类型):
 * 1 六种数字类型 ( byte, short, int, long, float, double) + void
 *                  8     16    32    64    32      64
 * 2 一种字符类型 char(16位Unicode字符)
 * 3 一种布尔型 boolean(1位)
 */
public class DataType {

    public static void main(String[] args) {
        //对于两个非new生成的Integer对象，进行比较时，
        // 如果两个变量的值在区间**-128到127**之间，则比较结果为true，
        // 如果两个变量的值不在此区间，则比较结果为false
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);//true

        Integer c = 127;
        Integer d = 100;
        System.out.println(c == d);//false

        d=127;
        System.out.println(c == d);//true

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);//false

//        public static Integer valueOf(int i) {
//            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
//                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
//            return new Integer(i);
//        }

    }
}
