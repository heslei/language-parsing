package parsing;

import java.util.regex.Pattern;

public enum Parser {

		ITALIC("//(.*?)//", new Replacement("<i>%s</i>")),
		BOLD("\\*\\*(.*?)\\*\\*", new Replacement("<b>%s</b>")),
		UNDERLINE("__(.*?)__", new Replacement("<u>%s</u>")),
		IMAGE("\\[image src=\"(.*?)\"\\]", new Replacement("<img src=\"%s\" />")),
		ANCHOR("(^https?://.*| +https?://.*) *", new Replacement("<a href=\"%1$s\">%1$s</a>")),
		ANCHOR_LABEL("\\[(https?://.*?)\\]\\((.*?)\\)", new Replacement("<a href=\"%s\">%s</a>")),
		LIST("\\* (.*)", new UnsortedList());

	private Pattern pattern;
	private IParser parser;

	private Parser(String regex, IParser parser) {
		this.pattern = Pattern.compile(regex);
		this.parser = parser;
	}

	public Pattern pattern() {
		return pattern;
	}

	public static String parse(final String input) {
		String result = input;

		for (Parser regex : Parser.values()) {
			result = regex.parser.parse(regex.pattern, result);

		}
		return result;
	}

}
