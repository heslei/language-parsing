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
	public void substituirMarcadorPorItalicoHTML(){
		String input = "//palavra//";
		String expected = "<i>palavra</i>";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorPorUndelineHTML(){
		String input = "__palavra__";
		String expected = "<u>palavra</u>";
		
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
	
	@Test
	public void substituirMarcadorPorImageHTML(){
		String input = "[image src=\"caminho qualquer\"]";
		String expected = "<img src=\"caminho qualquer\" />";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorHTTPPorAnchorHTML(){
		String input = "http://www.google.com";
		String expected = "<a href=\"http://www.google.com\">http://www.google.com</a>";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorHTTPSPorAnchorHTML(){
		String input = "https://www.google.com";
		String expected = "<a href=\"https://www.google.com\">https://www.google.com</a>";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorHTTPcomLabelPorAnchorHTML(){
		String input = "[http://www.google.com](Google)";
		String expected = "<a href=\"http://www.google.com\">Google</a>";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);
	}

}
