package parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;

import parsing.Parser.Regex;

public class RegexTest {
	
	@Test
	public void encontrarAnchorNaString(){
		String input = "http://www.google.com";
		Pattern pattern = Regex.ANCHOR.pattern();
		Matcher matcher = pattern.matcher(input);
		boolean find = matcher.find();
		Assert.assertTrue(find);
		
	}
	
	@Test
	public void encontrarAnchorComLabelNaString(){
		String input = "[http://www.google.com](Google)";
		Pattern pattern = Regex.ANCHOR_LABEL.pattern();
		Matcher matcher = pattern.matcher(input);
		boolean find = matcher.find();
		Assert.assertTrue(find);
		
	}
	
	
	
	
	
	

	@Test
	public void encontrarMarcadorDeImagemNoTexto() {
		String input = "     [image src=\"caminho qualquer\"] **bold** [image src=\"caminho qualquer2\"] ";

		Pattern pattern = Regex.IMAGE.pattern();

		Matcher matcher = pattern.matcher(input);

		boolean find = matcher.find();

		Assert.assertEquals("[image src=\"caminho qualquer\"]", matcher.group());
	}

	@Test
	public void substituirMarcadorPorHMTL() {
		String input = "     [image src=\"caminho qualquer\"] **bold** [image src=\"caminho qualquer2\"] ";
		String result = null;

		Pattern pattern = Regex.IMAGE.pattern();
		Matcher matcher = pattern.matcher(input);

		boolean find = matcher.find();
		while (find == true) {

			String[] args = new String[matcher.groupCount()];
			
			for (int i = 1; i <= matcher.groupCount(); i++) {
				args[i-1] = matcher.group(i);
			}

			result = Regex.IMAGE.replaceValues(args);
			
			input = matcher.replaceFirst(result);
			matcher = pattern.matcher(input);
			find = matcher.find();
		}

		Assert.assertEquals("     <img src=\"caminho qualquer\" /> **bold** <img src=\"caminho qualquer2\" /> ", input);
	}
}
