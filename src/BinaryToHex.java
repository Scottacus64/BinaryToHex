
import java.util.Scanner;
import java.lang.Math;
public class BinaryToHex
{	
		public static void main(String[] args)
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Please enter a binary number: ");
			String binaryNumberAsString = keyboard.nextLine();
//	Get the number of 4 bit nibbles in the binary number
			int nibble = (binaryNumberAsString.length()-1)/4;
			String hexResult = "";
// Add additional zeros of the binary number to make the number of digits a multiple of 4			
			int pad = binaryNumberAsString.length()%4;
			pad = 4 - pad; //subtract from 4 so if the mod is 3, only add 1 extra 0
			if (pad > 3) //if the mod was 0 add no extra 0's
					pad = 0;
// Step through as add 0's to the front of the binaryNumberAsString
			for(int i = pad; i>0; i--)
				binaryNumberAsString = '0' + binaryNumberAsString;

			int decimalTranslation = 0; //Decimal equivalent
			int binaryDigitTranslated = 0;
			//take 4 bit nibble
			for(int i = nibble; i >= 0; i--) // rem nibble is the number of 4 bit segments
			{
				String temp = "";
				int x = 0; //Exponent
				for(int z = 4; z > 0; z--) // one for each of the 4 bits in the nibble
					{
						temp = (binaryNumberAsString.charAt(i*4 + z - 1) + temp);
					}
				for(int w = 3; w >= 0; w--) // 3 to 0 to go right to left and from bucket 3 to 0
					{	
						if(temp.charAt(w) == '1')
							{
							binaryDigitTranslated = (int)(Math.pow(2,  x));
							decimalTranslation = decimalTranslation + binaryDigitTranslated;
							}
						x++;
					}
				String map = "0123456789ABCDEF";
				hexResult = map.charAt(decimalTranslation) + hexResult;
				decimalTranslation = 0;
			}
		System.out.println("'" + binaryNumberAsString + "' in hexadecimal is '" + hexResult + "'");	
		}
	
	
}
