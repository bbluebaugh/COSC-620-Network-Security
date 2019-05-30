#Caeser Cipher Brute Force
#Version 0.0.1 9/19/18
#Start with string to test algorithm
#message = 'GUVF VF ZL FRPERG ZRFFNTR.'
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

#use input file to make more general purpose 
f = open('input.txt', 'r')
message2 = f.read()

#Go through every possble key:
for key in range(len(LETTERS)):
	#importatn to set translated to the blank string so
	#previous iteration's value for the translated is clear
	translated = ''
	f = open("output.txt", 'a')

	for symbol in message2:
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
	#Create output file with all possible plaintexts
	f.write(translated + '\n')
	f.close()
	
	#display the current key and its decryption
	print('Key #%s: %s' % (key, translated))