package by.pvt.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Around(value = "@annotation(CustomLogging)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Запуск контроллера");
        Object object = joinPoint.proceed();
        log.info("Закрываем контроллер");
        return object;
    }
}
