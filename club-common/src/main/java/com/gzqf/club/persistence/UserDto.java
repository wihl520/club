package com.gzqf.club.persistence;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 16:16
 **/
public class UserDto<T> {

    /**
     * 成功的状态
     */
    public static final int SUCCESS_STATUS = 200;

    /**
     * 失败的状态
     */
    public static final int FAIL_STATUS = 500;

    /**
     * 记住密码
     */
    private boolean remember;

    /**
     * 自动登录
     */
    private boolean autologin;

    /**
     * 返回的结果是什么状态
     */
    private int status;

    /**
     * 验证码
     */
    private String verificationcode;

    /**
     * 邮件验证码
     */
    private String emailcode;

    /**
     * 处理返回的信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 设置失败的方法
     * （1）设置状态，（2）赋予错误的信息
     *
     * @param message 成功响应内容
     * @return UserDto 状态数据
     */
    public static UserDto fail(String message) {
        UserDto userDto = new UserDto();
        userDto.setStatus(FAIL_STATUS);
        userDto.setMessage(message);
        return userDto;
    }

    /**
     * 设置成功的方法
     * （1）设置状态，（2）赋予成功的信息 (3)赋予数据值
     *
     * @param message 成功响应内容
     * @param data    数据
     * @return UserDto 状态数据
     */
    public static UserDto success(String message, Object data) {
        UserDto userDto = new UserDto();
        userDto.setStatus(SUCCESS_STATUS);
        userDto.setMessage(message);
        userDto.setData(data);
        return userDto;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public boolean isAutologin() {
        return autologin;
    }

    public void setAutologin(boolean autologin) {
        this.autologin = autologin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode;
    }

    public String getEmailcode() {
        return emailcode;
    }

    public void setEmailcode(String emailcode) {
        this.emailcode = emailcode;
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
