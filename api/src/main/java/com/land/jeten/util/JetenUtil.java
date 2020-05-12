package com.land.jeten.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConvertException;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JetenUtil {

  static String secret = "secret";

  /**
   * jeten_jwt
   */
  static String ISSUER = "jeten_jwt";
  /**
   * 登陆使用的token
   */
  static String SUBJECT = "login_token";

  /**
   *
   */
  static String AUDIENCE = "system_user";

  public static <T> T convert(Class<T> type, Object value) throws ConvertException {
    return Convert.convert((Type)type, value);
  }



  public static Date getDateHour(Date date, int offset){
    return DateUtil.offset(date, DateField.HOUR, offset);
  }


  public static String createToken(String loginName, String username) {
    Date nowDate = new Date();
    Date expireDate = getDateHour(nowDate, 2);

    Map<String, Object> map = new HashMap<>();
    map.put("alg", "HS256");
    map.put("typ", "JWT");
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create().withHeader(map)
            /* 设置 载荷 Payload */
            .withClaim("loginName", loginName).withClaim("userName", username)
            .withIssuer(ISSUER)// 签名是有谁生成 例如 服务器
            .withSubject(SUBJECT)// 签名的主题
            // .withNotBefore(new Date())//该jwt都是不可用的时间
            .withAudience(AUDIENCE)// 签名的观众 也可以理解谁接受签名的
            .withIssuedAt(nowDate) // 生成签名的时间
            .withExpiresAt(expireDate)// 签名过期的时间
            /* 签名 Signature */
            .sign(algorithm);

  }
//
//
//  public static String createToken(String userName, String role) {
//    Date nowDate = new Date();
//    Date expireDate = getDateHour(nowDate, 2);
//
//    Map<String, Object> map = new HashMap<String, Object>();
//    map.put("alg", "HS256");
//    map.put("typ", "JWT");
//    Algorithm algorithm = Algorithm.HMAC256(secret);
//    String token = JWT.create().withHeader(map)
//            /* 设置 载荷 Payload */
//            .withClaim("loginName", userName)
//            .withClaim("userName", "张三")
//            .withClaim("deptName", "技术部")
//            .withClaim("role", role)
//            .withIssuer("SERVICE")// 签名是有谁生成 例如 服务器
//            .withSubject("this is test token")// 签名的主题
//            // .withNotBefore(new Date())//该jwt都是不可用的时间
//            .withAudience("APP")// 签名的观众 也可以理解谁接受签名的
//            .withIssuedAt(nowDate) // 生成签名的时间
//            .withExpiresAt(expireDate)// 签名过期的时间
//            /* 签名 Signature */
//            .sign(algorithm);
//    return token;
//  }


  public long getSnowId(){
    //参数1为终端ID
    //参数2为数据中心ID
    Snowflake snowflake = IdUtil.createSnowflake(1, 1);
    return snowflake.nextId();
  }


  public static String jwtRefresh(String token) throws ServletException {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm)
              .withIssuer(ISSUER)
              .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      long time = jwt.getExpiresAt().getTime();
      System.out.println("getExpiresAt:[" + new Date(time) +"]");
      long now = System.currentTimeMillis();
      // 30 分钟 （毫秒）
      long offset = 30 * 60 * 1000;
      if(offset >= time-now){

        String loginName = jwt.getClaim("loginName").asString();
        String userName = jwt.getClaim("userName").asString();
        return createToken(loginName, userName);
      }else{
        return token;
      }
    } catch (JWTVerificationException e){
      log.error(e.getMessage(), e);
      // token过期 会报异常，所以不需要判断token是否过期了。
      throw new ServletException("请先登陆！");
      //Invalid signature/claims
    }
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

  public static boolean isBlank(String str) {
    return StrUtil.isBlank(str);
  }
  public static boolean isNotBlank(String str) {
    return StrUtil.isNotBlank(str);
  }

  public static boolean ObjIsBlank(Object object) {
    return ObjectUtil.isEmpty(object);
  }

  public static void main(String[] args) {

  }

}
