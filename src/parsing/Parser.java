package parsing;

public class Parser {

	enum Markers {
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

	}

	public String parse(String input) {

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
	}

}
