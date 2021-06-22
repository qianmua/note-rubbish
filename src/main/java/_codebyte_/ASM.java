package _codebyte_;


import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM5;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/18  16:11
 */
public class ASM {
    public void asmCodeByteModify() throws Exception {
        ClassReader cr = GetByte.getClassReader();
        ClassWriter cw = new ClassWriter(0);

        ClassVisitor cv = new ClassVisitor(ASM5, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                if (name.equals("tableFieldsSql")) {
                    MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC, name, "()Ljava/lang/String;", null, exceptions);
                    mv.visitCode();
                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                    mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "com/Application", "test02", "()V", false);
                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                    return null;
                }
                return super.visitMethod(access, name, descriptor, signature, exceptions);
            }
        };
        //cr.accept(cv,ClassReader.SKIP_CODE|ClassReader.SKIP_DEBUG);
        cr.accept(cv, 0);
        byte[] bytesModifield = cw.toByteArray();

        GetByte.save(this.getClass(), ASM.class, bytesModifield);
    }
}
