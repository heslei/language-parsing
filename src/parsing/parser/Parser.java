package parsing.parser;

import java.util.regex.Pattern;

public interface Parser {
	String parse(Pattern pattern, String content);
}