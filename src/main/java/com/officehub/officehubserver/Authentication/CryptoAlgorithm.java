package com.officehub.officehubserver.Authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;



public class CryptoAlgorithm {
	
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * Test 암호화(Salt 컬럼이 현재 없으므로 임시 Salt 문구를 넣어서 암호화 테스트용)
	 */
	
	public static String getEncrypt_test(String source) {
		return getEncrypt(source, "test");
	}
	
	
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * @param salt(String) SALT 값
	 */
	public static String getEncrypt(String source, String salt) {
		return getEncrypt(source, salt.getBytes());
	}
	
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * @param salt(byte[]) SALT 값
	 */
	public static String getEncrypt(String source, byte[] salt) {
		
		String result = "";
		
		byte[] a = source.getBytes();
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			// 암호화 방식 지정 메소드
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
			
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * SALT생성
	 */
	public static String generateSalt() {
		Random random = new Random();
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < salt.length; i++) {
			// byte 값을 Hex 값으로 바꾸기.
			sb.append(String.format("%02x",salt[i]));
		}
		
		return sb.toString();
	}
	
}
