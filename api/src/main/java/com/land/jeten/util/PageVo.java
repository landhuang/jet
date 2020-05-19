package com.land.jeten.util;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {

  private List<T> data;
  private long totalCount;
  private long pageSize;
  private long pageNo;
  private long totalPage;
}
