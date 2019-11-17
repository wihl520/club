package com.gzqf.club.web.support;

import lombok.Data;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.Writer;

/**
 * <p>Description: </p>
 * 自定义分页标签
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 16:24
 **/
@Data
public class PageTag extends BodyTagSupport {

    /**
     * 总条数
     */
    private int count;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 当前第几页
     */
    private int current;

    @Override
    public int doStartTag() throws JspException {
        return BodyTag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            // 计算总页数
            int pageCount = count / pageSize;
            if (count % pageSize > 0) {
                pageCount++;
            }
            Writer writer = pageContext.getOut();
            // start 从第几页开始
            int start = current - 4 < 1 ? 1 : current - 4;
            // end 写到第几页
            int end = current + 4 > pageCount ? pageCount : current + 4;

            int prePage = current - 1 < 1 ? 1 : current - 1;
            int nextPage = current + 1 >= pageCount ? pageCount : current + 1;
            // 首先写第一页
            writer.write("<li><a href=\"javascript:page(1)\"> 首页 </a></li>");
            writer.write("<li><a href=\"javascript:page(" + prePage + ")\"> 上一页 </a></li>");
            for (int i = start; i <= end; i++) {
                if (i != current) {
                    writer.write("<li><a href=\"javascript:page(" + i + ")\">" + i + "</a></li>");
                } else {
                    // 它本身的页数不能跳转，比如当前是第7页，点7没有反应
                    writer.write("<li><a href=\"javascript:void(0)\">" + i + "</li>");
                }

            }
            writer.write("<li><a href=\"javascript:page(" + nextPage + ")\"> 下一页 </a></li>");
            // 最后写最后一页
            writer.write("<li><a href=\"javascript:page(" + pageCount + ")\"> 尾页 </a></li>");
            writer.write("<li> 当前页:<input type=\"text\" id=\"number\" value=\"" + current + "\" style=\"width: 20px\"></li>");
            writer.write("<li> <input type=\"button\" id=\"skip\" value=\"跳转\" ></li>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.SKIP_BODY;
    }


}
