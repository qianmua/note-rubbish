package _2020_10_13_.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapTest {
    public static void main(String[] args) {
        List<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
