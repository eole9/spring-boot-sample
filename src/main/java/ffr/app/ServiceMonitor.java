package ffr.app;

/**
 * Created by Fred on 03/05/2015.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

    private static Logger log = LoggerFactory.getLogger(ServiceMonitor.class);

    private long begin;
    private long end;

    @Before("execution(* services..*Service.*(..))")
    public void logServicBeforeAccess(JoinPoint joinPoint) {

        if (log.isDebugEnabled()) {

            System.out.println(" -> " + joinPoint);
            System.out.println(" -> " + joinPoint.toShortString());
            System.out.println(" -> " + joinPoint.toLongString());
            System.out.println(" -> " + joinPoint.getKind());
            System.out.println(" -> " + joinPoint.getSignature());

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(joinPoint.getSignature().getName());
            stringBuilder.append("(");
            if (joinPoint.getArgs() != null) {
                for (int i = 0; i < joinPoint.getArgs().length; i++) {
                    Object arg = joinPoint.getArgs()[i];
                    if (i > 0) {
                        stringBuilder.append(", ");
                    }
                    if (arg != null) {
                        stringBuilder.append(arg.toString());
                    } else {
                        stringBuilder.append("null");
                    }
                }
            }
            stringBuilder.append(")");
        }
        begin = System.currentTimeMillis();
    }

    @After("execution(* services..*Service.*(..))")
    public void logServiceAfterAccess(JoinPoint joinPoint) {
        end = System.currentTimeMillis();
        log.info(joinPoint + " (" + (end - begin) + "ms)");
    }
}