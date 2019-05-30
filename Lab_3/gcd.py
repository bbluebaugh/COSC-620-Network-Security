#greatest common divisor program version 1.0.0 date: 11/8/18
#take in 2 parameters a,b to perform the function
def gcd(a, b):
	#initialize variables for the function
	x0, x1, y0, y1 = 1, 0, 0, 1
	#until a = 0 compute the next divisor
	while a !=0:
		q, b, a = b // a, a, b %a
		x0, x1 = x1, x0 - q * x1
		y0, y1 = y1, y0 - q * y1
	#b = greatest common divisor
	#x0 final x value for gcd(a,b) = d = ax + by
	#y0 final y value for gcd(a,b) = d = ax + by
	print(b, x0, y0)
	return b, x0, y0
gcd(3313772, 1587894)