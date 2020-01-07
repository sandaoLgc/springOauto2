package com.jln.common.web.util;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class Base {
	public static String getuuid() {
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
	}
	public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        return ipAddress;
    }
	public static long getCurrentTime() {
		return System.currentTimeMillis() / 1000;
	}
	public static String encryptpassword(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}

    /**
     * 正则表达式去掉字符串中的数字
     * @param tmp 传入字符串
     * @return   去掉数字后的字符串
     */
	public static String toDigital(String tmp){
        return Pattern.compile("[\\d]").matcher(tmp).replaceAll("");
    }

    /**
     * 获取当前系统的年+月+日字符串
     * @return
     */
    public static String getYTD(){
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int monthValue = date.getMonthValue();
        int month = date.getDayOfMonth();
        return year+""+monthValue+""+month;
    }

    /**
     * 取传入位数少一位数的零
     * @param digit
     * @return
     */
    public static String  zeroFile(Integer digit){
        if(digit<=0){
            return null;
        }
        digit=digit-1;
        String anInt = (int) Math.pow(10, digit)+"";
        int index = anInt.indexOf("0");
        if(-1==index){
            return null;
        }
        return anInt.substring(index);
    }

    /**
     * 处理批次号,将原字符串传入后数值加一后返回
     * @param str  如:0001001
     * @return  如:0001002
     */
    public static String getZeroFile(String str){
        int oldeLength=str.length();
        int parseInt = Integer.parseInt(str)+1;
        String thisstr=parseInt+"";
        int thisLength=thisstr.length();
        String file = Base.zeroFile(oldeLength - (thisLength-1));
        if(null==file){
            return thisstr;
        }
        return file+thisstr;
    }
}
