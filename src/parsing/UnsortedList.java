package parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnsortedList implements IParser{

	@Override
	public String parse(Pattern pattern, String content) {
		
		Matcher matcher = pattern.matcher(content);
		List<String> itens = new ArrayList<String>();
		
		// TODO Heslei Lista temporaria até encontrar uma solucao melhor substituir texto em multiplas linhas
		StringBuffer textToReplace = new StringBuffer();
	
		boolean find = matcher.find();

		while (find == true) {

			String result = matcher.group(1);
			itens.add(result);
			
			textToReplace.append(matcher.group());
			textToReplace.append("\n");
			
			find = matcher.find();
		}
		String allResult = populate(itens); 
		return content.replace(textToReplace.toString(), allResult);
		
	}
	
	String populate(List<String> itens) {
		
		if (itens.size() == 0) {
			return "";
		}
		
		StringBuffer sb = new StringBuffer("<ul>\n");
		
		for (Object string : itens) {
			sb.append("<li>");
			sb.append(string);
			sb.append("</li>\n");
		}
		sb.append("</ul>");
		
		return sb.toString();
	}
	
}