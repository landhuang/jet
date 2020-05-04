package com.land.jeten.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConvertException;

import java.lang.reflect.Type;

public class JetenUtil {

  public static <T> T convert(Class<T> type, Object value) throws ConvertException {
    return Convert.convert((Type)type, value);
  }
}
