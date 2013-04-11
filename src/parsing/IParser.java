package parsing;

import java.util.regex.Pattern;

interface IParser {
	String parse(Pattern pattern, String content);
}