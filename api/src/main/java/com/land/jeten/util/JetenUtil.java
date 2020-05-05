package com.land.jeten.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConvertException;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JetenUtil {

  static String secret = "secret";

  public static <T> T convert(Class<T> type, Object value) throws ConvertException {
    return Convert.convert((Type)type, value);
  }

  public static String getToken(){
    return createToken();
  }

  public static Date getDateHour(Date date, int offset){
    return DateUtil.offset(date, DateField.HOUR, offset);
  }


  public static String createToken() {
    Date nowDate = new Date();
    Date expireDate = getDateHour(nowDate, 2);

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("alg", "HS256");
    map.put("typ", "JWT");
    Algorithm algorithm = Algorithm.HMAC256(secret);
    String token = JWT.create().withHeader(map)
            /* 设置 载荷 Payload */
            .withClaim("loginName", "zhuoqianmingyue").withClaim("userName", "张三").withClaim("deptName", "技术部")
            .withIssuer("SERVICE")// 签名是有谁生成 例如 服务器
            .withSubject("this is test token")// 签名的主题
            // .withNotBefore(new Date())//该jwt都是不可用的时间
            .withAudience("APP")// 签名的观众 也可以理解谁接受签名的
            .withIssuedAt(nowDate) // 生成签名的时间
            .withExpiresAt(expireDate)// 签名过期的时间
            /* 签名 Signature */
            .sign(algorithm);
            return token;
  }

  public long getSnowId(){
    //参数1为终端ID
    //参数2为数据中心ID
    Snowflake snowflake = IdUtil.createSnowflake(1, 1);
    long id = snowflake.nextId();
    return id;
  }

  public String checkToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256("secret");
    JWTVerifier verifier = JWT.require(algorithm).withIssuer("SERVICE").build(); // Reusable verifier instance
    DecodedJWT jwt = verifier.verify(token);

    String subject = jwt.getSubject();
    List<String> audience = jwt.getAudience();
    Map<String, Claim> claims = jwt.getClaims();
    for (Map.Entry<String, Claim> entry : claims.entrySet()) {
      String key = entry.getKey();
      Claim claim = entry.getValue();
      log.info("key:" + key + " value:" + claim.asString());
    }
    Claim claim = claims.get("loginName");

    log.info(claim.asString());
    log.info(subject);
    log.info(audience.get(0));
    return claim.asString();
  }

//  /**
//   * 获取用户名
//   * @param token
//   * @return
//   */
//  public static String getUsername(String token){
//    Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//    return claims.get("username").toString();
//  }
//
//  /**
//   * 获取用户角色
//   * @param token
//   * @return
//   */
//  public static String getUserRole(String token){
//    Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//    return claims.get("rol").toString();
//  }
//
//  /**
//   * 是否过期
//   * @param token
//   * @return
//   */
//  public static boolean isExpiration(String token){
//    Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//    return claims.getExpiration().before(new Date());
//  }
//
//  public String getMd5(String str) {
//    String s = SecureUtil.md5(str);
//    return s;
//  }
}
