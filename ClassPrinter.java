package TestCompetition.JavaAgent;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import java.util.*;
import java.io.*;

public class ClassPrinter extends ClassVisitor {

    private String cName;
	public static String temp;
	
	public ClassPrinter(final ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }
	
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cName = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        return mv == null ? null : new MethodPrinter(mv, cName);
    }
	
}
