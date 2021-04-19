package com.gz.fangcj.util;

import com.gz.fangcj.constant.GlobalConstant;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Description IP地址工具类
 * @Author Fangchenjiang
 * @Date 2021/4/19 15:20
 */
public class IpRequestUtil {
    /**
     * Gets request.
     *
     * @return the request
     */
    public static HttpServletRequest getRequest() {
        try {
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
        }
        return null;
    }

    public static HttpServletResponse getResponse() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获得用户远程地址
     *
     * @param request the request
     * @return the string
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        try {
            String ipAddress = request.getHeader(GlobalConstant.X_REAL_IP);
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(GlobalConstant.X_FORWARDED_FOR);
            }
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(GlobalConstant.PROXY_CLIENT_IP);
            }
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(GlobalConstant.WL_PROXY_CLIENT_IP);
            }
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(GlobalConstant.HTTP_CLIENT_IP);
            }
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader(GlobalConstant.HTTP_X_FORWARDED_FOR);
            }
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
            if (StringUtils.hasLength(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (GlobalConstant.LOCALHOST_IP.equals(ipAddress) || GlobalConstant.LOCALHOST_IP_16.equals(ipAddress)) {
                    //根据网卡取本机配置的IP
                }
            }
            // 对于通过多个代理的情况, 第一个IP为客户端真实IP,多个IP按照','分割 //"***.***.***.***".length() = 15
            if (ipAddress != null && ipAddress.length() > GlobalConstant.MAX_IP_LENGTH) {
                if (ipAddress.indexOf(GlobalConstant.Symbol.COMMA) > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(GlobalConstant.Symbol.COMMA));
                }
            }
            return ipAddress;
        } catch (Exception e) {
        }
        return null;
    }

    public static String getLocalAllIpv4() {
        String localAddr = "";
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress inetAddress = ips.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) {
                        localAddr += inetAddress.getHostAddress() + ",";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        localAddr = localAddr.substring(0, localAddr.length() - 1);
        return localAddr;
    }
}
