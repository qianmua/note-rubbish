package _codebyte_;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;

import java.io.IOException;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/18  18:30
 */
public class JavassistChange {
    public static final String CLASS_AB_PATH = System.getProperty("user.dir") + "/mybatis-plus-sample-quickstart/src/test/java/com/fa/mycim/pms/" + "GaussQuery.class";

    public static void change() throws NotFoundException, CannotCompileException, IOException {

        ClassPool cp = ClassPool.getDefault();
        cp.insertClassPath(CLASS_AB_PATH);
        CtClass ct = cp.get("com.baomidou.mybatisplus.generator.config.querys.GaussQuery");
        CtMethod cm = ct.getMethod("tableFieldsSql", "()Ljava/lang/String;");
        cm.setBody("return \"SELECT DISTINCT T1.COLUMN_NAME,T2.COMMENTS,T1.DATA_TYPE, CASE WHEN CONSTRAINT_TYPE='P' THEN 'PRI' END AS KEY   FROM SYS.ADM_TAB_COLUMNS T1 LEFT JOIN SYS.ADM_COL_COMMENTS T2 ON (T1.TABLE_NAME = T2.TABLE_NAME  AND T1.COLUMN_NAME = T2.COLUMN_NAME) LEFT JOIN ( SELECT T5.TABLE_NAME,T5.CONS_COLS AS COLUMN_NAME, T5.CONSTRAINT_TYPE FROM SYS.ADM_CONSTRAINTS T5  WHERE  T5.CONSTRAINT_TYPE = 'P')T3 ON (T1.TABLE_NAME  = T3.TABLE_NAME AND T1.COLUMN_NAME = T3.COLUMN_NAME) WHERE T1.TABLE_NAME = '%s' \";");
        ct.writeFile("./out");
    }

    public static void main(String[] args) {
        try {
            change();
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }
    }
}
