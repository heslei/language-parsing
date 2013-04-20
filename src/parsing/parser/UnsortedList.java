package parsing.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnsortedList implements Parser{

	@Override
	public String parse(Pattern pattern, String content) {
		
		final Matcher matcher = pattern.matcher(content);
		final List<String> itens = new ArrayList<String>();
		
		// TODO Heslei Lista temporaria até encontrar uma solucao melhor substituir texto em multiplas linhas
		String textToReplace = "";
	
		boolean find = matcher.find();

		while (find == true) {

			String result = matcher.group(1);
			itens.add(result);
			
			textToReplace += matcher.group()  + "\n";
			
			find = matcher.find();
		}
		String allResult = populate(itens); 
		return content.replace(textToReplace, allResult);
		
	}
	
	String populate(List<String> itens) {
		
		if (itens.size() == 0) {
			return "";
		}
		
		String html = "<ul>\n";
		
		for (Object string : itens) {
			html += "<li>" + string + "</li>\n";
		}
		html += "</ul>";
		
		return html;
	}
	
}