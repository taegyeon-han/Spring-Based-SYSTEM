package com.freehoon.web.login.service;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;
 
public class  EncryptionProcess  {
    
    public static String Encryption(String uid, String pwd) throws Exception{
        
        if(pwd == null){
            return "";
        }
        
        byte[] hashValue = null;
        
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        
        md.reset();
        md.update(uid.getBytes());
        
        hashValue = md.digest(pwd.getBytes());
        
        return new String(Base64.encodeBase64(hashValue));
    }
    
    public static String Encryption2(String name, String ID_CARD_SERIAL) throws Exception{
        
        if(name == null){
            return "";
        }
        
        byte[] hashValue = null;
        
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        
        md.reset();
        md.update(name.getBytes());
        
        hashValue = md.digest(ID_CARD_SERIAL.getBytes());
        
        return new String(Base64.encodeBase64(hashValue));
    }
 
}
