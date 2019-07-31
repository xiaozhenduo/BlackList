package common.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @program BlackList
 * @description:
 * @author: 肖振铎
 * @create: 2019/07/30 11:28
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseFrom<T> implements Serializable {

    //当前页
    private Integer current;

    //页面显示数据量
    private Integer pageSize;

    //From数据
    private Class<T> From;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Class<T> getFrom() {
        return From;
    }

    public void setFrom(Class<T> from) {
        From = from;
    }
}
