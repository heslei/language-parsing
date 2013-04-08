package parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	enum Regex {
		//IMAGE("\\[image src=\"([\\w\\s\\d:\\/]*)\"\\]", "<img src=\"%s\"/>");
		ITALIC("//(.*?)//", "<i>%s</i>"),
		BOLD("\\*\\*(.*?)\\*\\*", "<b>%s</b>"),
		UNDERLINE("__(.*?)__", "<u>%s</u>"),
		IMAGE("\\[image src=\"(.*?)\"\\]", "<img src=\"%s\" />"),
		ANCHOR("(^https?://.*| +https?://.*) *", "<a href=\"%1$s\">%1$s</a>"),
		ANCHOR_LABEL("\\[(https?://.*?)\\]\\((.*?)\\)", "<a href=\"%s\">%s</a>"),
		LIST("\\* (.*?)","<ul><li>%s</li></ul>");

		private Pattern pattern;
		private String html;

		private Regex(String regex, String html) {
			this.pattern = Pattern.compile(regex);
			this.html = html;
		}

		public String replaceValues(Object... values) {
			return String.format(html, values);
		}

		public Pattern pattern() {
			return pattern;
		}
	}

	/*enum Markers {
		BOLD("**", "b"), ITALIC("//", "i"), UNDERLINE("__", "u");

		private String mark;
		private String beginHtml;
		private String endHtml;

		private Markers(String mark, String html) {
			this.mark = mark;
			this.beginHtml = String.format("<%s>", html);
			this.endHtml = String.format("</%s>", html);
		}

		public String beginHtml() {
			return beginHtml;

		}

		public String endHtml() {
			return endHtml;
		}

		public String mark() {
			return mark;
		}

	}*/
	
	
	public String parse(final String input){
		
		String result = input;
		
		for (Regex regex : Regex.values()) {
			result = parse(result, regex);
			
		}
		return result;
	}
	
	String parse(final String input, final Regex item){
		
		String result = input;
		
		Pattern pattern = item.pattern();
			
		Matcher matcher = pattern.matcher(result);
	
		boolean find = matcher.find();

		if (find == true) {

			String[] args = groups(matcher);

			String replacement = item.replaceValues(args);
			
			result = matcher.replaceFirst(replacement);
			
			parse(result, item);
		}
		
		return result;
	}
	
	private String[] groups(Matcher matcher){
		
		String[] args = new String[matcher.groupCount()];
		
		for (int i = 1; i <= matcher.groupCount(); i++) {
			args[i-1] = matcher.group(i);
		}
		
		return args;
	}

	/*public String parse(String input) {

		StringBuffer buffer = new StringBuffer(input);

		for (Markers mark : Markers.values()) {

			int index = buffer.indexOf(mark.mark);
			boolean isBegin = true;
			while (index >= 0) {

				if (isBegin) {
					replace(buffer, index, mark.beginHtml());
				} else {
					replace(buffer, index, mark.endHtml());
				}
				isBegin = !isBegin;
				index = buffer.indexOf(mark.mark);
			}
		}

		return buffer.toString();
	}

	private void replace(final StringBuffer buffer, int index,
			String textToReplace) {
		buffer.replace(index, index + 2, textToReplace);
	}*/

}
