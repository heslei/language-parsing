package parsing;

import org.junit.Assert;
import org.junit.Test;

public class UnsortedListTest {

	@Test
	public void substituirMarcadorListaPorULHTML() {
		String input = "* item 1\n* item 2\n* item 3\n";
		String expected = "<ul>\n<li>item 1</li>\n<li>item 2</li>\n<li>item 3</li>\n</ul>";

		String result = new UnsortedList().parse(Parser.LIST.pattern(),
				input);

		Assert.assertEquals(expected, result);
	}

}
