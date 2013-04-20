package parsing.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Table implements Parser{

	@Override
	public String parse(Pattern pattern, String content) {
		
		final Matcher matcher = pattern.matcher(content);
		final List<String> itens = new ArrayList<String>();
		
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
		
		String html = "<table>";
		
		for (String line : itens) {
			html += tableRow(line);
		}
		
		html += "</table>";
		
		return html;
	}

	private String tableRow(String line) {
		String html;
		String[] lineItens = splitLine(line);
		html = "<tr>";
		html += tableData(lineItens);
		html += "</tr>";
		return html;
	}
	
	String tableData(String[] itens){
		String tds = "";
		for (String item : itens) {
			tds += "<td>" + item.trim() +"</td>";
		}
		return tds;
	}
	
	String[] splitLine(String line){
		return line.split("\\|");
	}
	
}