package com.liyang.jpa.audit.server.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.liyang.jpa.audit.server.config.JpaRestfulAuditServerSupport;

@Retention(RUNTIME)
@Target(TYPE)
@Inherited
@Import(JpaRestfulAuditServerSupport.class)
public @interface EnableJpaRestfulAuditServer {

}
