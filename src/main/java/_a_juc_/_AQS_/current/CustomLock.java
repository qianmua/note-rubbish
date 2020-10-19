package _a_juc_._AQS_.current;

import sun.misc.Unsafe;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/18  14:01
 * @description : aqs lock
 */
public class CustomLock {

    /**
     * 状态
     */
    private volatile int state = 0 ;

    /**
     * 持有 锁 的线程
     */
    private Thread lockHolder;

    /**
     * 线程 等待队列
     */
    private ConcurrentLinkedQueue<Thread> waitQueue = new ConcurrentLinkedQueue<>();

    /**
     * add lock
     */
    public void lock(){
        if (acquire()) {
            return;
        }
        Thread currentThread = Thread.currentThread();

        // add wait queue
        waitQueue.add(currentThread);

        // lock fail
        // cas
        for (;;) {
            /// sleep
            // un use cpu and acquire
            // park LockSupport
            if (( currentThread == waitQueue.peek() ) && acquire()){
                // 移除 队列
                waitQueue.poll();
                return ;
            }
            LockSupport.park(currentThread);
        }

    }

    /**
     * un lock
     */
    public void unLock() {

        // 当前 ？
        if (Thread.currentThread() != lockHolder){
            throw new RuntimeException("this lock holder is not current thread");
        }

        // change status
        int state = getState();

        if (compareAndSwapState(state , 0)){
            setLockHolder(null);
            Thread first = waitQueue.peek();
            if (null != first){
                // 唤醒队列 -> first
                LockSupport.unpark(first);
            }
        }
    }


    private boolean acquire() {
        // use unsafe?
        // 反射

        Thread currentThread = Thread.currentThread();
        // init state
        int c = getState();

        if (c == 0){
            // 无锁

            // safe
            // 空队列？
            // 队列头？
            if ( (waitQueue.size() == 0 || currentThread == waitQueue.peek() )
                    && compareAndSwapState(0 , 1)){
                // 当前 thread
                setLockHolder(currentThread);
                return true;
            }
        }
        return false;
    }

    /**
     * cas
     * @param exec int
     * @param update int
     * @return bool
     */
    public final boolean compareAndSwapState(int exec , int update){
        assert unsafe != null;
        return unsafe.compareAndSwapInt(this , stateOffset , exec , update);
    }

    // unsafe
    private static final Unsafe unsafe = UnSafeInstance.refelectGetUnsafe();

    private static long stateOffset;


    /**
     * init
     */
    static {
        try {
//            assert unsafe != null;
            stateOffset = Objects.requireNonNull(unsafe).objectFieldOffset(CustomLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }
}
