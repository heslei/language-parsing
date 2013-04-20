package parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;

public class RegexTest {
	
	@Test
	public void encontrarAnchorNaString(){
		String input = "http://www.google.com";
		Pattern pattern = Engine.ANCHOR.pattern();
		Matcher matcher = pattern.matcher(input);
		boolean find = matcher.find();
		Assert.assertTrue(find);
	}
	
	@Test
	public void encontrarAnchorComLabelNaString(){
		String input = "[http://www.google.com](Google)";
		Pattern pattern = Engine.ANCHOR_LABEL.pattern();
		Matcher matcher = pattern.matcher(input);
		boolean find = matcher.find();
		Assert.assertTrue(find);
	}
	
	@Test
	public void encontrar1ItemNaListaCom3ItensNaString(){
		String input = "* item 1\n* item 2\n* item 3";
		Pattern pattern = Engine.LIST.pattern();
		Matcher matcher = pattern.matcher(input);
		boolean find = matcher.find();
		Assert.assertTrue(find);
		Assert.assertEquals("item 1", matcher.group(1));
	}
	
	@Test
	public void encontrarListaCom3ItensNaString(){
		String input = "* item 1\n* item 2\n* item 3";
		Pattern pattern = Engine.LIST.pattern();
		Matcher matcher = pattern.matcher(input);
		
		boolean find = matcher.find();
		Assert.assertTrue(find);
		Assert.assertEquals("item 1", matcher.group(1));
		
		find = matcher.find();
		Assert.assertTrue(find);
		Assert.assertEquals("item 2", matcher.group(1));
		
		find = matcher.find();
		Assert.assertTrue(find);
		Assert.assertEquals("item 3", matcher.group(1));
		
		find = matcher.find();
		Assert.assertFalse(find);
		
	}

	@Test
	public void encontrarMarcadorDeImagemNoTexto() {
		String input = "     [image src=\"caminho qualquer\"] **bold** [image src=\"caminho qualquer2\"] ";

		Pattern pattern = Engine.IMAGE.pattern();

		Matcher matcher = pattern.matcher(input);

		boolean find = matcher.find();

		Assert.assertEquals("[image src=\"caminho qualquer\"]", matcher.group());
	}

	@Test
	public void encontrarTabelaComUmaColunaDuasLinhasNaString(){
		String input = "|a|b|\n|c|d|";
		Pattern pattern = Engine.TABLE.pattern();
		Matcher matcher = pattern.matcher(input);
		
		boolean find = matcher.find();
		Assert.assertTrue(find);
		Assert.assertEquals("a|b", matcher.group(1));
		
		find = matcher.find();
		Assert.assertTrue(find);
		Assert.assertEquals("c|d", matcher.group(1));
		
		find = matcher.find();
		Assert.assertFalse(find);
		
	}
	
}
