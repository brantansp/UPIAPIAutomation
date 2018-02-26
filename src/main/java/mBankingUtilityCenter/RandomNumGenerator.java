package mBankingUtilityCenter;

import java.security.SecureRandom;
import java.util.Random;
import java.math.BigInteger;

/**
 * 
 * @author brantansp
 *
 */
public class RandomNumGenerator {
	static final String AB = "012345I6789ABCDE";
	static SecureRandom rnd = new SecureRandom();
	
	public static void main(String[] args) {
        System.out.println(genarate(32));
	}
	
	public static String genarate( int len ){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		}
	
}










