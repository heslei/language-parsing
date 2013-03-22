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
