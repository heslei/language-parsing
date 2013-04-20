language-parsing
================

Basicamente é fazer um método que recebe uma String que pode ter os seguintes marcadores (entre outros):

`**palavra**`
`//palavra//`
`__palavra__`

e convertê-la em um string que seja um html

  <b>palavra</b>
	<i>palavra</i>
	<u>palavra</u>

Por exemplo:

	__um **exemplo //qualquer//**__

vira

	<u>um <b>exemplo <i>qualquer</i></b></u>

Adicionar suporte para as seguintes tags:

	[image src="caminho qualquer"] => <img src="caminho qualquer" />

	http://www.google.com => <a href="http://www.google.com">http://www.google.com</a>
	
	https://www.google.com => <a href="https://www.google.com">https://www.google.com</a>
	
	[http://www.google.com](Google) => <a href="http://www.google.com">Google</a>
	
							<ul>
	* item 1					<li>item 1</li>
	* item 2			=>		<li>item 2</li>
	* item 3					<li>item 3</li>
							</ul>
Adicionar suporte à tabelas

	| a | b | c |    <table><tr><td>a</td><td>b</td><td>c</td></tr>
	| 1 | 2 | 3 | => <tr><td>1</td><td>2</td><td>3</td></tr></table>
