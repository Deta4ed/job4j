package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Vitaly Lobach (deta4ed@gmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
	/**
	* Test echo.
	*/ 
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
	    String input = "Vitaly";
	    String expect = "Echo, echo, echo : Vitaly"; 
	    Calculate calc = new Calculate();
	    String result = calc.echo(input);
	    assertThat(result, is(expect));
	}
 
}