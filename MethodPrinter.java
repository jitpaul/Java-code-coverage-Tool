package TestCompetition.JavaAgent;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

class MethodPrinter extends MethodVisitor implements Opcodes {

	String cName;
	
    public MethodPrinter(final MethodVisitor mv, String className) {
        super(ASM5, mv);
        this.cName=className;
    }
	
	@Override
	public void visitCode() {
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn(cName + " executed");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		super.visitCode();
	}
	
	@Override
	public void visitLineNumber(int line, Label start) {
		    //mv.visitLdcInsn(line);
			//mv.visitLdcInsn(cName);
			//mv.visitMethodInsn(INVOKESTATIC, "TestCompetition/JavaAgent/StatementCoverageData", "MarkLineAsExecuted", "(ILjava/lang/String;)V", false);
	    	//mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			super.visitLineNumber(line, start);
	}
}