package parsing;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
	
	@Test
	public void substituirMarcadorPorNegritoHTML() {
		
		String input = "**palavra**";
		String expected = "<b>palavra</b>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);		
	}
	
	@Test
	public void substituirMarcadorPorItalicoHTML(){
		String input = "//palavra//";
		String expected = "<i>palavra</i>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorPorUndelineHTML(){
		String input = "__palavra__";
		String expected = "<u>palavra</u>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void subtituirMultiplosMarcadoresParaHTML(){
		String input = "__um **exemplo //qualquer//**__";
		String expected = "<u>um <b>exemplo <i>qualquer</i></b></u>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);	
	}
	
	@Test
	public void substituirMarcadorPorImageHTML(){
		String input = "[image src=\"caminho qualquer\"]";
		String expected = "<img src=\"caminho qualquer\" />";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorHTTPPorAnchorHTML(){
		String input = "http://www.google.com";
		String expected = "<a href=\"http://www.google.com\">http://www.google.com</a>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorHTTPSPorAnchorHTML(){
		String input = "https://www.google.com";
		String expected = "<a href=\"https://www.google.com\">https://www.google.com</a>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorHTTPcomLabelPorAnchorHTML(){
		String input = "[http://www.google.com](Google)";
		String expected = "<a href=\"http://www.google.com\">Google</a>";
		
		String result = Parser.parse(input);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void substituirMarcadorListaPorULHTML() {
		String input = "* item 1\n* item 2\n* item 3\n";
		String expected = "<ul>\n<li>item 1</li>\n<li>item 2</li>\n<li>item 3</li>\n</ul>";

		String result = Parser.parse(input);

		Assert.assertEquals(expected, result);
	}
}
