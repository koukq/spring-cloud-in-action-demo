package com.kou.common.util.enums;

/**
 * 1XXX 客户端错误
 * 2XXX 服务器端内部错误
 * 3XXX 警告提示
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS_CODE("0000","成功"),
    /**
     * 错误
     */
    ERROR_CODE("0001","错误");

    private String code;
    private String defaultMsg;

    ResponseCode(String code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    public String getCode() {
        return code;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }
}
