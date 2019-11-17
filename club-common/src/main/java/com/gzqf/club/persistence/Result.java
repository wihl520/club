package com.gzqf.club.persistence;

/**
 * <p>Description: </p>
 * service处理响应的信息
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:24
 **/
public class Result<T> {

    /**
     * 失败的状态
     */
    public static final int ERROR_STATUS = 500;

    /**
     * 成功状态
     */
    public static final int SUCCESS_STATUS = 200;

    /**
     * 处理结果是否成功
     */
    private int status;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 出错的时候可以直接用，修改status状态
     *
     * @param message 失败处理响应内容
     * @return 响应的信息
     */
    public static Result fail(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(ERROR_STATUS);
        return result;
    }

    /**
     * 成功时可以调用
     *
     * @param message 成功处理响应内容
     * @param data    成功处理响应数据
     * @return 响应的信息
     */
    public static Result success(String message, Object data) {
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(SUCCESS_STATUS);
        result.setData(data);
        return result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
