package _2_demo_._class_init_;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/13  13:41
 */
public class Main {

    /**
     * clinit方法在我们第一次主动使用这个类的时候会触发执行，比
     * 如我们访问这个类的静态方法或者静态字段就会触发执行clinit，
     * 但是这个过程是不可逆的，也就是说当我们执行一遍之后再也不会执行了，
     * 如果在执行这个方法过程中出现了异常没有被捕获，那这个类将永远不可用，
     * 虽然我们上面执行BadClass.doSomething()的时候catch住了异常，
     * 但是当代码跑到这里的时候，在jvm里已经将这个类打上标记了，
     * 说这个类初始化失败了，下次再初始化的时候就会直接返回并抛出类似的异常
     * java.lang.NoClassDefFoundError: Could not initialize class BadClass，
     * 而不去再次执行初始化的逻辑，
     *
     * 如果clinit执行失败了，抛了一个未被捕获的异常，
     * 那将这个类的状态设置为initialization_error,并且无法再恢复，
     * 因为jvm会认为你这次初始化失败了，下次肯定也是失败的，
     * 为了防止不断抛这种异常，所以做了一个缓存处理，不是每次都再去执行clinit，
     */
    public static void main(String[] args) {
        try{
            ClassInit.DoSomething();
        }catch (Throwable e){
            e.printStackTrace();
        }
        ClassInit.DoSomething();
    }
}
