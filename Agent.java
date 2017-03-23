package TestCompetition.JavaAgent;

import java.lang.instrument.Instrumentation;
import org.objectweb.asm.Opcodes;

public class Agent 
{	
    public static void premain(String agentArgs, Instrumentation inst)
    {
        inst.addTransformer(new MyClassFileTransformer()); 

    }
}