package com.midian.webtest.use;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * This Test for verify Parameter annotation
 * @author Young
 *
 */
public class passParameter {

    /**
     * 
     * @param parameter1
     * @param parameter2
     */
	@Parameters({"IndexURL","username"})
    @Test(groups="parameter")
    public void parameter(String IndexURL,int username )
    {
        System.out.println("parameter1 is "+IndexURL );
        System.out.println("parameter2 is "+username );
    }
}