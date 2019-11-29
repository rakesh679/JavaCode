package DecryptAndEncrypt;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/* Decrypt encrypted string into plain string with aes algoritham*/ 

public class DecryptAndEncrypt {

 public String decrypt(String str,String k) throws Exception {
    // Decode base64 to get bytes
	 
	 Cipher  dcipher = Cipher.getInstance("AES");
	 Key aesKey = new SecretKeySpec(k.getBytes(), "AES");
	 dcipher.init(dcipher.DECRYPT_MODE, aesKey);
	//System.out.println(aesKey);
    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
    byte[] utf8 = dcipher.doFinal(dec);
    //System.out.println(utf8);
 // Decode using utf-8
     return new String(utf8, "UTF8");
  }

 
 public String encrypt(String str,String k) throws Exception {
	 Cipher ecipher = Cipher.getInstance("AES");
	 Key aeskey = new SecretKeySpec(k.getBytes(),"AES");
	 byte[] utf8 = str.getBytes("UTF8");
	 ecipher.init(ecipher.ENCRYPT_MODE, aeskey );
	
	 byte[] enc = ecipher.doFinal(utf8);
	 
	 return new sun.misc.BASE64Encoder().encode(enc);
	 
}
 public String encrypt(String str,String k,String Algo) throws Exception {
	 Cipher ecipher = Cipher.getInstance(Algo);
	 Key aeskey = new SecretKeySpec(k.getBytes(),Algo);
	 byte[] utf8 = str.getBytes("UTF8");
	 ecipher.init(ecipher.ENCRYPT_MODE, aeskey );
	
	 byte[] enc = ecipher.doFinal(utf8);
	 
	 return new sun.misc.BASE64Encoder().encode(enc);
	 
}
 public String decrypt(String str,String k,String Algo) throws Exception {
	    // Decode base64 to get bytes
		 
		 Cipher  dcipher = Cipher.getInstance(Algo);
		 Key aesKey = new SecretKeySpec(k.getBytes(), Algo);
		 dcipher.init(dcipher.DECRYPT_MODE, aesKey);
		//System.out.println(aesKey);
	    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
	    byte[] utf8 = dcipher.doFinal(dec);
	    //System.out.println(utf8);
	 // Decode using utf-8
	     return new String(utf8, "UTF8");
	  }

    public static void main(String args []) throws Exception
    {
        String original = "rakesh";
        String data = "CfPcX0G+e7TLKKMyyvrvrQ==";
        String k = "qertyuiopasdfghw"; //AES key length must be 16
        String k1 = "qertyuio";  // DES key length must be 8 
        String data1 = "rakesh";
        String data2 = "nAtvNq7uHKE=";
        String Algo= "DES";
        String Algo1= "AES";
        DecryptAndEncrypt decrypter = new DecryptAndEncrypt();
         System.out.println("Original String: " + original);
         
         System.out.println("encrypted String in DES: " + decrypter.encrypt(data1, k1,Algo));
         System.out.println("Decrypted String in DES: " + decrypter.decrypt(data2, k1,Algo));
         System.out.println("encrypted String in AES: " + decrypter.encrypt(data1, k,Algo1));
         System.out.println("Decrypted String in AES: " + decrypter.decrypt(data, k,Algo1));
    }
}
