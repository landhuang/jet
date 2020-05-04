package com.land.jeten.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConvertException;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JetenUtil {

  public static <T> T convert(Class<T> type, Object value) throws ConvertException {
    return Convert.convert((Type)type, value);
  }

  public static String getToken(){
    return createToken();
  }


  public static String createToken() {

    String secret = "secret";// token 密钥
    Algorithm algorithm = Algorithm.HMAC256("secret");

    // 头部信息
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("alg", "HS256");
    map.put("typ", "JWT");

    Date nowDate = new Date();
    //结果：2017-03-03 22:33:23
    Date expireDate = DateUtil.offset(nowDate, DateField.HOUR, 2);

    String token = JWT.create()
            .withHeader(map)// 设置头部信息 Header
            .withIssuer("SERVICE")//设置 载荷 签名是有谁生成 例如 服务器
            .withSubject("this is test token")//设置 载荷 签名的主题
            // .withNotBefore(new Date())//设置 载荷 定义在什么时间之前，该jwt都是不可用的.
            .withAudience("APP")//设置 载荷 签名的观众 也可以理解谁接受签名的
            .withIssuedAt(nowDate) //设置 载荷 生成签名的时间
            .withExpiresAt(expireDate)//设置 载荷 签名过期的时间
            .sign(algorithm);//签名 Signature
    return token;
  }

  public long getSnowId(){
    //参数1为终端ID
    //参数2为数据中心ID
    Snowflake snowflake = IdUtil.createSnowflake(1, 1);
    long id = snowflake.nextId();
    return id;
  }
}
