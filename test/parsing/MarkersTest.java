package parsing;

import org.junit.Assert;
import org.junit.Test;

import parsing.Parser.Markers;

public class MarkersTest {

	@Test
	public void bold(){
		Assert.assertEquals("**", Markers.BOLD.mark());
		Assert.assertEquals("<b>", Markers.BOLD.beginHtml());
		Assert.assertEquals("</b>", Markers.BOLD.endHtml());
	}
	
	@Test
	public void italic(){
		Assert.assertEquals("//", Markers.ITALIC.mark());
		Assert.assertEquals("<i>", Markers.ITALIC.beginHtml());
		Assert.assertEquals("</i>", Markers.ITALIC.endHtml());
	}
	
	@Test
	public void underline(){
		Assert.assertEquals("__", Markers.UNDERLINE.mark());
		Assert.assertEquals("<u>", Markers.UNDERLINE.beginHtml());
		Assert.assertEquals("</u>", Markers.UNDERLINE.endHtml());
	}
}
