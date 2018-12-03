package  com.hzfc.utils;

import java.security.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author LinYingZhi 2011-11-23 
 *
 */
public class TmsfDesUtil {
    
    public static final String KEY_STRING = "www.tmsf.com";//生成密钥的字符串,
    static Key key;       
      
    /**    
     * 根据参数生成KEY    
     *     
     * @param strKey    
     */      
    public static void getKey(String strKey) {       
        try {       
            KeyGenerator _generator = KeyGenerator.getInstance("DES");       
            _generator.init(new SecureRandom(strKey.getBytes()));       
            key = _generator.generateKey();     
            _generator = null;       
        } catch (Exception e) {       
            e.printStackTrace();       
        }       
    }       
      
    /**    
     * 加密String明文输入,String密文输出    
     *     
     * @param strMing    
     * @return    
     */      
    public static String getEncString(String strMing) {    
    	TmsfDesUtil.getKey(KEY_STRING);// 生成密匙       
        byte[] byteMi = null;       
        byte[] byteMing = null;       
        String strMi = "";       
        BASE64Encoder base64en = new BASE64Encoder();       
        try {       
            byteMing = strMing.getBytes("UTF8");       
            byteMi = getEncCode(byteMing);       
            strMi = base64en.encode(byteMi);       
        } catch (Exception e) {       
            e.printStackTrace();       
        } finally {       
            base64en = null;       
            byteMing = null;       
            byteMi = null;       
        }       
        return strMi;       
    }       
      
    /**    
     * 解密 以String密文输入,String明文输出    
     *     
     * @param strMi    
     * @return    
     */      
    public static String getDesString(String strMi) {   
    	TmsfDesUtil.getKey(KEY_STRING);// 生成密匙       
        BASE64Decoder base64De = new BASE64Decoder();       
        byte[] byteMing = null;       
        byte[] byteMi = null;       
        String strMing = "";       
        try {       
            byteMi = base64De.decodeBuffer(strMi);       
            byteMing = getDesCode(byteMi);       
            strMing = new String(byteMing, "UTF8");       
        } catch (Exception e) {       
            e.printStackTrace();       
        } finally {       
            base64De = null;       
            byteMing = null;       
            byteMi = null;       
        }       
        return strMing;       
    }       
      
    /**    
     * 加密以byte[]明文输入,byte[]密文输出    
     *     
     * @param byteS    
     * @return    
     */      
    private static byte[] getEncCode(byte[] byteS) {       
        byte[] byteFina = null;       
        Cipher cipher;       
        try {       
            cipher = Cipher.getInstance("DES");       
            cipher.init(Cipher.ENCRYPT_MODE, key);       
            byteFina = cipher.doFinal(byteS);       
        } catch (Exception e) {       
            e.printStackTrace();       
        } finally {       
            cipher = null;       
        }       
        return byteFina;       
    }       
      
    /**    
     * 解密以byte[]密文输入,以byte[]明文输出    
     *     
     * @param byteD    
     * @return    
     */      
    private static byte[] getDesCode(byte[] byteD) {       
        Cipher cipher;       
        byte[] byteFina = null;       
        try {       
            cipher = Cipher.getInstance("DES");       
            cipher.init(Cipher.DECRYPT_MODE, key);       
            byteFina = cipher.doFinal(byteD);       
        } catch (Exception e) {       
            e.printStackTrace();       
        } finally {       
            cipher = null;       
        }       
        return byteFina;       
      
    }       
    
    public static void main(String[] args) {       
         
    	System.out.println("###############字符串加密###############");
    	System.out.println("10000001加密---->" + TmsfDesUtil.getEncString("10000001")); 
        System.out.println("30000341加密---->" + TmsfDesUtil.getEncString("30000341")); 
        System.out.println("30000342加密---->" + TmsfDesUtil.getEncString("30000342")); 
        System.out.println("30000343加密---->" + TmsfDesUtil.getEncString("30000343")); 
        System.out.println("30000344加密---->" + TmsfDesUtil.getEncString("30000344")); 
        System.out.println("99999999加密---->" + TmsfDesUtil.getEncString("99999999")); 
        System.out.println("###############字符串解密###############");        
        System.out.println(TmsfDesUtil.getDesString("t6FFjCM8r3ZuNjPIgPL/1w=="));
        
    }       
    
}
