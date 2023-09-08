package com.zerobase.api.aop

import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect
@Component
class LogAspect {
    val logger = KotlinLogging.logger {  }

    @Pointcut("within(com.zerobase.api..*)")
    private fun isApi() {}

    @Pointcut("within(com.zerobase.api..*)")
    private fun save() {}

    @Pointcut("within(com.zerobase.api..*)")
    private fun find() {}

    @Around("isApi()")
    fun loggingAspect(joinPoint: ProceedingJoinPoint): Any {
        val stopWatch = StopWatch()
        stopWatch.start()

        val result = joinPoint.proceed()

        stopWatch.stop()

        logger.info { "${joinPoint.signature.name} ${joinPoint.args[0]} ${stopWatch.lastTaskTimeMillis}" }

        return result
    }

    @Around("save()")
    fun loggingSave(joinPoint: ProceedingJoinPoint): Any {

        val result = joinPoint.proceed()

        logger.info{ "Save" }

        return result;
    }

    @Around("find()")
    fun loggingFind(joinPoint: ProceedingJoinPoint): Any {

        val result = joinPoint.proceed()

        logger.info{ "Find" }

        return result;
    }
}