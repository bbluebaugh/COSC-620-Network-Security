#Caeser Cipher Brute Force
message = 'GUVF VF ZL FRPERG ZRFFNTR.'
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
f = open('input.txt', 'r')
message2 = f.read()

#Go through every possble key:
for key in range(len(LETTERS)):
	#importatn to set translated to the blank string so
	#previous iteration's value for the translated is clear
	translated = ''

	for symbol in message:
		if symbol in LETTERS:
			#get the number of the symbol
			num = LETTERS.find(symbol)
			num = num - key

			#wrap around if the number is 26 or larger or
			#less than 0
			if num < 0:
				num = num + len(LETTERS)

			#add number's symbol at the end of the translation
			translated = translated + LETTERS[num]
		else:

			#add the symbol without encrypting or decrypting
			translated = translated + symbol

	#display the current key and its decryption
	print('Key #%s: %s' % (key, translated))