package cn.tedu.jsdvn2203.csmall.server.util;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {

    /**
     * 签名密钥
     */
    private static final String SECRET_KEY = "fgS1sdfA3gsFSF5GS";

    /**
     * JWT过期时间：以分钟单位
     */
    private static final long EXPIRATION_I_MINUTE = 7 * 24 * 60;

    /**
     * 私有构造方法，避免外部随意创建对象
     */
    private JwtUtils() {
    }

    /**
     * 生成JWT
     *
     * @param claims
     * @return
     */
    public static String generate(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_I_MINUTE * 60 * 1000);//System.currentTimeMillis();//1970年1月1日0时0分0秒 到 此时此刻 的毫秒值

        String jwt = Jwts.builder()//JWT的组成部分：header（头） ，payload（载荷），signature（签名）
                .setHeaderParam("typ", "jwt")//header: 用于配置算法与此结果数据的类型
                .setHeaderParam("alg", "HS256")
                .setClaims(claims)//payload: 用于配置需要封装到JWT的数据
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)//signature:用于指定算法与密匙
                .compact(); //打包
        log.debug("加密验证信息:{}", jwt);
        return jwt;
    }

    /**
     * 解析JWT
     *
     * @param jwt
     * @return
     */
    public static Claims parse(String jwt){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
    }
}
