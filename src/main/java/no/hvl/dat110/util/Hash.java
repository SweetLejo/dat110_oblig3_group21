package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity)  {
		
		BigInteger hashint = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(entity.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
			hashint = new BigInteger(1, digest);
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException("No md5 algorithm", e);
		}

		return hashint;
	}
	
	public static BigInteger addressSize() {
		return BigInteger.valueOf(2).pow(128);
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
