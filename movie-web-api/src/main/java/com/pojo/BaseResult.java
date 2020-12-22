package com.pojo;

import lombok.Data;

/**
 * @author TanHaooo
 * @date 2020/12/21 15:06
 */
@Data
public class BaseResult {

    /**
     * 成功状态码
     */
    public static final int STATUS_SUCCESS = 200;

    /**
     * 成功状态码
     */
    public static final int STATUS_FALL = 500;

    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回对象
     */
    private Object result;

    /**
     * 返回时间
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 创建返回对象
     *
     * @param status  返回状态
     * @param message 返回消息
     * @param result  返回数据
     * @return
     */
    private static BaseResult createResult(int status, String message, Object result) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setResult(result);
        return baseResult;
    }

    /**
     * 默认返回成功方法
     *
     * @return
     */
    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", null);
    }

    /**
     * 返回成功带消息
     *
     * @param message 返回消息
     * @return
     */
    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message, null);
    }

    /**
     * 返回成功带对象
     *
     * @param result 返回对象
     * @return
     */
    public static BaseResult success(Object result) {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", result);
    }

    /**
     * 返回成功带消息和对象
     *
     * @param message 返回消息
     * @param result  返回对象
     * @return
     */
    public static BaseResult success(String message, Object result) {
        return BaseResult.createResult(STATUS_SUCCESS, message, result);
    }

    /**
     * 默认返回失败方法
     *
     * @return
     */
    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FALL, "失败", null);
    }

    /**
     * 返回失败带消息
     *
     * @param message 返回消息
     * @return
     */
    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FALL, message, null);
    }

    /**
     * 返回失败带对象
     *
     * @param result 返回对象
     * @return
     */
    public static BaseResult fail(Object result) {
        return BaseResult.createResult(STATUS_FALL, "失败", result);
    }

    /**
     * 返回失败带消息和数据
     *
     * @param message 返回消息
     * @param result  返回对象
     * @return
     */
    public static BaseResult fail(String message, Object result) {
        return BaseResult.createResult(STATUS_FALL, message, result);
    }

}
