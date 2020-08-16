package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.User;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void userInvalidPasswordTest(){
        User user = new User("bationo", "1234556", "Aristide BATIONO", "ROLE_USER");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate( user );
        assertEquals( 1, constraintViolations.size() );
    }

    @Test
    public void userValidPasswordTest(){
        User user = new User("bationo", "Bationo@2020", "Aristide BATIONO", "ROLE_USER");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate( user );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void bidListInvalidTest(){
        BidList bid = new BidList("Account Test", "Type Test", 0);
        Set<ConstraintViolation<BidList>> constraintViolations = validator.validate( bid );
        assertEquals( 1, constraintViolations.size() );
    }

    @Test
    public void bidListValidTest(){
        BidList bid = new BidList("Account Test", "Type Test", 0.1);
        Set<ConstraintViolation<BidList>> constraintViolations = validator.validate( bid );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void curvePointInvalidTest(){
        CurvePoint curvePoint = new CurvePoint(10, 10d, 00);
        Set<ConstraintViolation<CurvePoint>> constraintViolations = validator.validate( curvePoint );
        assertEquals( 1, constraintViolations.size() );
    }

    @Test
    public void curvePointValidTest(){
        CurvePoint curvePoint = new CurvePoint(10, 10d, 01);
        Set<ConstraintViolation<CurvePoint>> constraintViolations = validator.validate( curvePoint );
        assertEquals( 0, constraintViolations.size() );
    }
}
