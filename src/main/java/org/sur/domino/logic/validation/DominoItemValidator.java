package org.sur.domino.logic.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sur.domino.model.DominoItem;

public class DominoItemValidator implements 
	ConstraintValidator<DominoItemConstraint, DominoItem>{

	private static Logger logger = LoggerFactory.getLogger(DominoItemValidator.class);
	
	public boolean isValid(DominoItem dominoItem, ConstraintValidatorContext context) {
		boolean valid = false;
		logger.info("isValid: Begin");
		boolean rule1;
		try {
			context.disableDefaultConstraintViolation();

			rule1 = checkNotEqualValues(dominoItem, context);
					
			valid = rule1;
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return valid;
	}
	
	private void addConstraintViolation(
			String errorPropertyName, 
			ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(
                "{" + errorPropertyName + "}"
        ).addConstraintViolation();	    		
	}
	
	private boolean checkNotEqualValues(
			DominoItem dominoItem, 
			ConstraintValidatorContext context) {
		Boolean valid = new Boolean(false);
		try {
			if ((dominoItem != null) && 
					(dominoItem.getFirst() != null) && 
					(dominoItem.getSecond() != null)) {
				valid = !dominoItem.getFirst().equals(dominoItem.getSecond());
			}
			if (!valid) {
				addConstraintViolation(
						DominoItemErrorPropertyNames.notEqualValues, 
						context);
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		}
		return valid;
	}

}
