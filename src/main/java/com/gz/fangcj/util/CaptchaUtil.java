package com.gz.fangcj.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Description 验证码工具类
 * @Author Fangchenjiang
 * @Date 2021/4/19 10:39
 */
public class CaptchaUtil {
    public static final String CAPTCHA_KEY = "captcha";

    private static final Logger logger = LoggerFactory.getLogger(CaptchaUtil.class);
    private CaptchaUtil(){}

    /**
     * 随机字符字典
     */
    private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * 随机数
     */
    private static Random random = new Random();

    /**
     * 获取4位随机数
     */
    private static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 4; i++)
        {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    /**
     * 获取随机数颜色
     */
    private static Color getRandomColor() {
        return new Color(random.nextInt(255),random.nextInt(255),
                random.nextInt(255));
    }

    /**
     * 返回某颜色的反色
     * @param c 颜色
     */
    private static Color getReverseColor(Color c){
        return new Color(255 - c.getRed(), 255 - c.getGreen(),
                255 - c.getBlue());
    }

    /**
     * 获取验证码
     * @param request
     * @param response
     * @throws Exception
     */
    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception{

        response.setContentType("image/jpeg");
        String randomString = getRandomString();
        request.getSession().setAttribute(CAPTCHA_KEY, randomString);

        logger.info("session:{},captcha:{} ", request.getSession().getId(), randomString);

        int width = 120;
        int height = 50;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 22, 33);
        for (int i = 0, n = random.nextInt(100); i < n; i++){
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi,"jpeg",out);
        out.flush();
    }

    /**
     * 验证码校验
     * @param request 请求
     * @param captcha 验证码
     * @return 是否验证通过
     */
    public static boolean verificationCaptcha(HttpServletRequest request, String captcha){
        String correctCaptcha = (String) request.getSession().getAttribute(CAPTCHA_KEY);
        logger.info("session:{},captcha:{}, userCaptcha:{}",request.getSession().getId(),correctCaptcha, captcha);
        if (correctCaptcha != null && correctCaptcha.equalsIgnoreCase(captcha)){
            return true;
        }
        return false;
    }
}
