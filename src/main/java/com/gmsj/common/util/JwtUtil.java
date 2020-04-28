package com.gmsj.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gmsj.common.constant.HttpHeaderConstant;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Jwt工具类
 *
 * @author renbaojie
 */
public class JwtUtil {

    /**
     * 生成token,expireTime后过期
     *
     * @param userId 用户名
     * @param salt   盐
     * @param roles  角色数组
     * @return 加密的token
     */
    public static String createToken(String userId, String[] roles, String[] actions, String ip, String salt) {
        return JWT.create()
                .withClaim("userId", userId)
                .withClaim("ip", ip)
                .withArrayClaim("roles", roles)
                .withArrayClaim("actions", actions)
                // token有效期 15天
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15))
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(salt == null ? "sAlt" : salt));
    }

    /**
     * 获得token的签发时间,无需secret解密也能获得
     *
     * @return token中包含的签发时间
     */
    public static Date getIssuedAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getIssuedAt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的用户id, 无需secret解密也能获得
     *
     * @return token中包含的用户id
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的角色数组, 无需secret解密也能获得
     *
     * @return token中包含的角色数组
     */
    public static String[] getRoles(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("roles").asArray(String.class);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的行为数组, 无需secret解密也能获得
     *
     * @return token中包含的角色数组
     */
    public static String[] getActions(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("actions").asArray(String.class);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的ip, 无需secret解密也能获得
     *
     * @return token中包含的ip
     */
    public static String getIp(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("ip").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */
    public static boolean isTokenExpired(String token) {
        Date now = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(now);
    }

    /**
     * 从请求头的 Authorization 中获取token串
     */
    public static String getTokenFromAuthorization(String authorization) {
        if (authorization != null && !"".equals(authorization)) {
            if (!authorization.startsWith(HttpHeaderConstant.HEADER_SCHEME)) {
                return null;
            } else {
                String[] authArr = authorization.split(" ");
                return authArr.length < 2 ? null : authArr[1];
            }
        } else {
            return null;
        }
    }

    /**
     * 生成随机盐,长度32位
     *
     * @return 随机盐
     */
    public static String createSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
