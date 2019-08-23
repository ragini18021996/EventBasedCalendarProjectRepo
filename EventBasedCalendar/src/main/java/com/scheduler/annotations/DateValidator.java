package com.scheduler.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;




@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PresentOrFutureValidator.class)
@Documented
public @interface DateValidator {

	public String value() default "DEPT";
	public String message() default "Must Start with DEPT";
	public Class<?>[] groups() default{};
	public Class <? extends Payload>[] payload() default{};



}