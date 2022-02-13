package org.sur.domino.logic.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {DominoItemValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, 
	ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface DominoItemConstraint {

	/**
	 * 
	 * @return
	 */
	String message() default "Field is not valid";  
	
	/**
	 * 
	 * @return
	 */
	Class<?>[] groups() default {};
	
	/**
	 * 
	 * @return
	 */
	Class<? extends Payload>[] payload() default {};

}
