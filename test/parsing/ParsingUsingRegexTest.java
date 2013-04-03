package parsing;

import org.junit.Assert;
import org.junit.Test;

public class ParsingUsingRegexTest {

	@Test
	public void parseMarcadorImagemParaHTML(){
		String input = "[image src=\"caminho qualquer\"]";
		String expected = "<img src=\"caminho qualquer\" />";
		
		String result = new Parser().parse(input);
		
		Assert.assertEquals(expected, result);
	}
}
