package cm.md5;

import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

public class MD5 {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("m0lwuYw79Bk=   MD5加密后   " + string2MD5("m0lwuYw79Bk="));
		System.out.println("6W2R9dKYJiAfJAfVsP+M2w==   MD5加密后   " + string2MD5("6W2R9dKYJiAfJAfVsP+M2w=="));
		System.out.println("sa   MD5加密后   " + string2MD5("sa"));
		System.out.println("123456mm  MD5加密后   " + string2MD5("123456mm"));
		
		System.out.println("m0lwuYw79Bk=   加密后   " + getEncryptString("m0lwuYw79Bk="));
		System.out.println("6W2R9dKYJiAfJAfVsP+M2w==   加密后   " + getEncryptString("6W2R9dKYJiAfJAfVsP+M2w=="));
		System.out.println("sa   加密后   " + getEncryptString("sa"));
		System.out.println("123456mm  加密后   " + getEncryptString("123456mm"));

		System.out.println("sa   加密后   " + getEncryptString("sa"));
		System.out.println("cccccc  加密后   " + getEncryptString("cccccc"));
		
		System.out.println("m0lwuYw79Bk=   解密后   " + getDecryptString("m0lwuYw79Bk="));
		System.out.println("6W2R9dKYJiAfJAfVsP+M2w==   解密后   " + getDecryptString("6W2R9dKYJiAfJAfVsP+M2w=="));
		System.out.println("sa   解密后   " + getDecryptString("sa"));
		System.out.println("123456mm  解密后   " + getDecryptString("123456mm"));
		
	}

	
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
    }
    
	public static String getDecryptString(String str) {
		try {
			Key key;
			String KEY_STR = "myKey";
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			byte[] strBytes = Base64.decodeBase64(new String(str).getBytes()); 
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public static String getEncryptString(String str) {
		try {
			Key key;
			String KEY_STR = "myKey";
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return new String(Base64.encodeBase64Chunked(encryptStrBytes));
                       
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
