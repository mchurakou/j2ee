package com.mikalai.j2ee.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {


    @Inject
    private Logger logger;


    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.info("before " + ic.getTarget().getClass().getName() +" " + ic.getMethod().getName());
        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
            logger.info("after " + ic.getTarget().getClass().getName() +" " + ic.getMethod().getName());
        }
    }
}