package com.ecommerce.posgrado.util;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 22:15
 * Project Name: posgrado
 */
public class HtmlGeneratorUtil {

    public static String generateConfirmationTemplate(String name, String url) {
        return "<html>" +
                "<body>" +
                "<h1> Hello " + name + ",</h1>" +
                "<p>Please click the button below to confirm your account:</p>" +
                "<a href='" + url + "'>" +
                "<button>Confirm Account</button>" +
                "</a>" +
                "</body>" +
                "</html>";
    }

}
