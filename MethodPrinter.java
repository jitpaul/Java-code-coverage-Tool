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
	public void visitLineNumber(int line, Label start) {		
			mv.visitLdcInsn(cName+":"+line+"\n");
			mv.visitMethodInsn(INVOKESTATIC, "TestCompetition/JavaAgent/StatementCoverageData", "lineExecuted", "(Ljava/lang/String;)V", false);
			super.visitLineNumber(line, start);
	}
}