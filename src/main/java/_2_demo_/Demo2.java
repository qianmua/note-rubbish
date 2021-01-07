package _2_demo_;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  13:41
 * @description :
 */
public class Demo2 {

    public static void main(String[] args) {
        // safe enum
        double g = Planet.EARTH.getSfG();
        for (Planet value : Planet.values()) {
            System.out.printf("%s %f %n" , value , value.sfW(g));
        }

        // abs enum
        double x = 1.1 ,y = 2.2;
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f  = %f %n" , x , op , y , op.apply(x , y));
        }
        for (Operation op : Operation.values()) {
            System.out.println(Operation.formString(op.toString()).get());
        }
    }

    /*
    switch
     */
    enum PayrollDay{
        MON , TUE , WED , THU , FRI , SAT (PayType.WEEKEND) , SUN(PayType.WEEKEND);

        private final PayType payType;

        PayrollDay(PayType payType){
            this.payType = payType;
        }

        /**
         * default
         */
        PayrollDay(){
            this(PayType.WEEKDAY);
        }

        int pay(int minutesWorked, int payState){
            return payType.pay(minutesWorked , payState);
        }

        private enum PayType{
            WEEKDAY{
                @Override
                int overtimePay(int minus, int payRate) {
                    return minus <= MINUS_PER_SHIFT ? 0 : (minus - MINUS_PER_SHIFT) * payRate / 2 ;
                }
            },
            WEEKEND{
                @Override
                int overtimePay(int minus, int payRate) {
                    return minus * payRate / 2;
                }
            };

            abstract int overtimePay(int minus, int payRate);

            private static final int MINUS_PER_SHIFT = 8 * 60;

            int pay(int minusWorked , int payRate ){
                int basePay = minusWorked * payRate;
                return basePay + overtimePay(minusWorked, payRate);
            }

        }


    }


    /*
    abstract
     */
    private enum Operation{
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        } ,
        MINUS("-") {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;
        private static final Map<String , Operation> stringToEnum = Stream
                .of(values())
                .collect(Collectors.toMap(Object::toString , e -> e));

        Operation(String symbol){
            this.symbol = symbol;
        }

        public abstract double apply(double x , double y);

        @Override
        public String toString() {
            return symbol;
        }

        public static Optional<Operation> formString(String symbol){
            return Optional.ofNullable(stringToEnum.get(symbol));
        }
    }

    /*
    1
     */
    private enum Planet{
        MERCURY(3E+23 , 2E6),
        EARTH(5E+23 , 2.3E6),
        VENUS(4E+21 , 3E7),
        MARS(6E+22 , 1E8),
        JUPITER(3E+27 , 3.5E6),
        SATURN(3E+26 , 1.9E6),
        URANUS(4E+25 , 2.8E7),
        NEPTUNE(6E+28 , 2.9E6);

        private final double mass;
        private final double radius;
        private final double sfG;

        private static final double G = 6.6E-11;

        Planet(final double mass, final double radius){
            this.mass = mass;
            this.radius = radius;

            this.sfG = G * mass / (radius * radius);
        }

        public double getMass() {
            return mass;
        }

        public double getRadius() {
            return radius;
        }

        public double getSfG() {
            return sfG;
        }
        public double sfW(double mess){
            return mess * sfG; // f = ma
        }
    }
}
