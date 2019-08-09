package com.ztest.chapter13.base;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/09
 * \* Time: 10:19
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 13 分页用
 * \
 */
public class BaseEntity implements Serializable {

    /**
     * 分页页码，默认页码为1
     */
    protected int page = 1;

    /**
     * 分页每页数量，默认20
     */
    protected int size = 20;

    /**
     * 排序列名称，默认为id
     */
    protected String sidx = "id";

    /**
     * 排序正序
     */
    protected String sord = "asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }


}
