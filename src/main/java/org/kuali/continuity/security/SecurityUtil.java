// 
// Copyright 2011 Kuali Foundation, Inc. Licensed under the
// Educational Community License, Version 2.0 (the "License"); you may
// not use this file except in compliance with the License. You may
// obtain a copy of the License at
// 
// http://www.opensource.org/licenses/ecl2.php
// 
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an "AS IS"
// BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing
// permissions and limitations under the License.
// 
package org.kuali.continuity.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.ui.rememberme.InvalidCookieException;
import org.springframework.util.StringUtils;

public class SecurityUtil {
    /**
     * Locates the Spring Security Shibleth cookie in the request.
     *
     * @param request the submitted request which is to be authenticated
     * @param key key to be checked
     * @return the cookie value (if present), null otherwise.
     */
    public static boolean isShiblethCookieExists(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();

        if ((cookies == null) || (cookies.length == 0)) {
            return false;
        }

        for (int i = 0; i < cookies.length; i++) {
            if (key.equals(cookies[i].getName())) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Sets the cookie on the response
     *
     * @param tokens the tokens which will be encoded to make the cookie value.
     * @param maxAge the value passed to {@link Cookie#setMaxAge(int)}
     * @param request the request
     * @param response the response to add the cookie to.
     */
    public static void setCookie(String[] tokens, int maxAge, String key, HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = encodeCookie(tokens);
        Cookie cookie = new Cookie(key, cookieValue);
        cookie.setMaxAge(maxAge);
        cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
        response.addCookie(cookie);
    }
    
    public static void setRootCookie(String[] tokens, int maxAge, String key, HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = encodeCookie(tokens);
        Cookie cookie = new Cookie(key, cookieValue);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    
    /**
     * Inverse operation of decodeCookie.
     *
     * @param cookieTokens the tokens to be encoded.
     * @return base64 encoding of the tokens concatenated with the ":" delimiter.
     */
    public static String encodeCookie(String[] cookieTokens) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < cookieTokens.length; i++) {
            sb.append(cookieTokens[i]);

            if (i < cookieTokens.length - 1) {
                sb.append("::");
            }
        }

        String value = sb.toString();
        sb = new StringBuffer(encode(value));
        while (sb.charAt(sb.length() - 1) == '=') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    /**
     * Decodes the cookie and splits it into a set of token strings using the ":" delimiter.
     *
     * @param cookieValue the value obtained from the submitted cookie
     * @return the array of tokens.
     * @throws InvalidCookieException if the cookie was not base64 encoded.
     */
    private static String[] decodeCookie(String cookieValue) throws InvalidCookieException {
        for (int j = 0; j < cookieValue.length() % 4; j++) {
            cookieValue = cookieValue + "=";
        }
        if (!Base64.isArrayByteBase64(cookieValue.getBytes())) {
            throw new InvalidCookieException( "Cookie token was not Base64 encoded; value was '" + cookieValue + "'");
        }
        String cookieAsPlainText = decode(cookieValue);
        return StringUtils.delimitedListToStringArray(cookieAsPlainText, "::");
    }
    
    /*
     * Get Cookie value
     * 
     * @param cookies cookies array from http request
     * @param cookieName cookie Name to be looked up
     * @param defaultValue value returned if no cookie found
     * */
    public static String getCookieValue(Cookie[] cookies, String cookieName) {
    	if (cookies == null || cookieName == null) return null;
    	
    	for(int i=0; i < cookies.length; i++) {
    		Cookie cookie = cookies[i];
    		if (cookieName.equals(cookie.getName()))
    			return (decodeCookie(cookie.getValue())[0]);
    	}
    	return null;
    }
    
    public static String encode(String data){
    	return new String(Base64.encodeBase64(data.getBytes()));
    }
    
    public static String decode(String data){
    	return new String(Base64.decodeBase64(data.getBytes()));
    }
    
    /*
     * Check if the custom url has correct syntax
     * */
    public static boolean uriSyntaxCheck(String data){
    	String pattern = "^[a-zA-Z_\\-]+";
    	return data.matches(pattern);
    }
}
