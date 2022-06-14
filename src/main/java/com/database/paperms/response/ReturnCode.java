package com.database.paperms.response;

/**
 * ClassName: com.database.paperms.result.ReturnCode
 * Created by zjj
 * Date: 2022-05-06 14:58
 */
public enum ReturnCode {
    /**
     * 操作成功
     **/
    RC100(100, "操作成功"),
    /**
     * 操作失败
     **/
    RC999(999, "操作失败"),
    /**
     * 服务限流
     **/
    RC200(200, "服务开启限流保护,请稍后再试!"),
    /**
     * 服务降级
     **/
    RC201(201, "服务开启降级保护,请稍后再试!"),
    /**
     * 热点参数限流
     **/
    RC202(202, "热点参数限流,请稍后再试!"),
    /**
     * 系统规则不满足
     **/
    RC203(203, "系统规则不满足要求,请稍后再试!"),
    /**
     * 授权规则不通过
     **/
    RC204(204, "授权规则不通过,请稍后再试!"),
    /**
     * access_denied
     **/
    RC403(403, "无访问权限,请联系管理员授予权限"),
    /**
     * access_denied
     **/
    RC401(401, "匿名用户访问无权限资源时的异常"),
    /**
     * 服务异常
     **/
    RC500(500, "系统异常，请稍后重试"),

    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(403, "Access denied"),
    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),
    INVALID_EMAIL(1004, "不合法的邮箱"),
    CLASS_CAST_ERROR(1005, "出错了！"),
    USED_EMAIL(1006, "邮箱已被注册！"),
    NOT_EXISTENT_PAPER_ID(1007, "此论文的ID不存在！"),
    USED_PAPER_ID(1008, "此论文ID号已经被使用！"),
    NOT_EXISTENT_COMMENT(1009, "此评论不存在！"),
    USED_PAPER_LINK(1010, "该论文链接已经存在！"),
    NOT_EXISTENT_REPLY(1011, "此回复不存在！"),
    NOT_EXISTENT_USER_NOTE(1012, "笔记不存在！"),
    USED_USER_NOTE(1013, "笔记已经存在。"),
    RESEARCH_DIRECTION_IS_EMPTY(1014, "研究方向为空"),
    TIME_FORMAT_ERROR(1015, "时间格式错误，yyyy-MM-dd"),
    PAPER_TYPE_RANGE_ERROR(1016, "论文类型错误"),
    PAGE_PARAMETER_ERROR(1017, "分页参数错误"),
    RESEARCH_DIRECTION_ERROR(1018, "研究方向数据出现问题，请维护"),
    GET_DATA_ERROR(1019, "获取数据失败"),
    ILLEGAL_SEARCH_TYPE(1020, "无效的搜索类型"),
    SEARCH_CONDITION_ERROR(1021, "您的搜索条件有误，请检查！"),
    UPDATE_ERROR(1022, "更新失败");
    /**
     * 自定义状态码
     **/
    private final int code;
    /**
     * 自定义描述
     **/
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
