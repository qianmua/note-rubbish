package _java_use_script_;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/28  15:57
 * @description :
 */
public class Main {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        Bindings bindings = engine.createBindings();

        bindings.put("factor" , 1);

        engine.setBindings(bindings , ScriptContext.ENGINE_SCOPE);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int i = scanner.nextInt();
            int i1 = scanner.nextInt();
            System.out.println("has input valuable :" + i + "," + i1);

            engine.eval(new FileReader(System.getProperty("user.dir") + "/src/main/java/_java_use_script_/sum.js"));

            if (engine instanceof Invocable){
                Invocable in = (Invocable) engine;

                Double d = (Double) in.invokeFunction("formula" , i , i1);
                System.out.println("resulet is : " + d);
            }
        }
    }
}
