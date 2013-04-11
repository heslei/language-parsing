package parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacement implements IParser {

	private final String replacement;

	public Replacement(String replacement) {
		this.replacement = replacement;
	}

	@Override
	public String parse(Pattern pattern, String content) {

		Matcher matcher = pattern.matcher(content);
		String result = content;
		
		boolean find = matcher.find();

		if (find == true) {

			String[] args = groups(matcher);

			String replacement = String.format(this.replacement, args);

			result = matcher.replaceFirst(replacement);

			parse(pattern, result);
		}

		return result;
	}

	private String[] groups(Matcher matcher) {

		String[] args = new String[matcher.groupCount()];

		for (int i = 1; i <= matcher.groupCount(); i++) {
			args[i - 1] = matcher.group(i);
		}

		return args;
	}

}
