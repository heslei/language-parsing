package parsing;

import org.junit.Assert;
import org.junit.Test;

public class ParseTest {
	
	@Test
	public void substituirMarcadorPorNegritoHTML() {
		
		String input = "**palavra**";
		String expected = "<b>palavra</b>";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);		
	}
	
	@Test
	public void subtituirMultiplosMarcadoresParaHTML(){
		String input = "__um **exemplo //qualquer//**__";
		String expected = "<u>um <b>exemplo <i>qualquer</i></b></u>";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);	
	}

}
