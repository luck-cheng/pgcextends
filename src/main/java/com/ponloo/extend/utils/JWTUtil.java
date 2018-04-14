package com.ponloo.extend.utils;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/17.
 */
public class JWTUtil {
    /*
    sub: 该JWT所面向的用户
    iss: 该JWT的签发者
    aud：接收方
    iat(issued at): 在什么时候签发的token
    exp(expires): 过期时间戳
    nbf(not before)：token在此时间之前不能被接收处理
    jti：JWT ID为web token提供唯一标识
    */
    public static String createJWT(String name,
                                   String userId,
                                   String audience,
                                   String issuer,
                                   long TTLMillis,
                                   String base64Security) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
//生成签名密钥 就是一个base64加密后的字符串,
        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary (base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm. getJcaName());
        /*设置json*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", name);
        jsonObject.put("userId", userId);
//添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setIssuedAt(now)
                .setSubject(jsonObject.toString()) //主题，也差不多是个人的一些信息
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey); //签名
//添加Token过期时间
        if (TTLMillis >= 0) {
//过期时间
            long expMillis = nowMillis + TTLMillis;
//现在是什么时间
            Date exp = new Date(expMillis);
//系统时间之前的token都是不可以被承认的
            builder.setExpiration(exp).setNotBefore(now);
        }
//生成JWT
        return builder.compact();
    }

    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

//    public static void main(String[] args) {
//        String jwt = JWTUtil.createJWT("testname", "userId", "client", "server", 1000000000, "dsfadf");
//        Claims claims = JWTUtil.parseJWT(jwt, "dsfadf");
//        System.out.println(claims);
//    }
}
