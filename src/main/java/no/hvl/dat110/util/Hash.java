package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {


	public static BigInteger hashOf(String entity) {

		BigInteger hashint = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(entity.getBytes());
			hashint = new BigInteger(1,messageDigest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5
		// compute the number of bits = bitSize()
		// compute the address size = 2 ^ number of bits
		// return the address size

		int bits = bitSize();
		BigInteger bigInt = BigInteger.valueOf(2).pow(bits);

		return bigInt;
	}

	public static int bitSize() {

		int digestlen = 0;

		// find the digest length

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
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