package TestCompetition.JavaAgent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import java.io.*;

public class MyClassFileTransformer implements ClassFileTransformer{

    @Override
    public byte[] transform(ClassLoader classLoader, String s, Class<?> aClass, ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException 
    {
            if ((s.startsWith("org/joda/time")) && !("org/joda/time/Listener".equals(s))) 
			//if ("org/joda/time/Period".equals(s))
			{
            // ASM Code
			System.out.println("Entered");
            ClassReader reader = new ClassReader(bytes);
            ClassWriter writer = new ClassWriter(reader, 0);
            ClassPrinter visitor = new ClassPrinter(writer);
            reader.accept(visitor, 0);
            return writer.toByteArray();
			}
			
			return null;
    }

}

