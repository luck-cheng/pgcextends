package com.ponloo.extend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017/7/17.
 */
@Configuration
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties", encoding = "utf-8")
public class TokenConfig {
    @Value("${token.ponloo.secret}")
    private String secret;
    @Value("${token.ponloo.exp}")
    private String exp;
    @Value("${token.ponloo.payload}")
    private String payload;
    @Value("${token.ponloo.time}")
    private Long exptime;
    @Value("${token.ponloo.heard}")
    private String rHeard;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getExptime() {
        return exptime;
    }

    public void setExptime(Long exptime) {
        this.exptime = exptime;
    }

    public String getrHeard() {
        return rHeard;
    }

    public void setrHeard(String rHeard) {
        this.rHeard = rHeard;
    }
}
