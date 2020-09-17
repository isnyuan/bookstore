package com.bookstore.utils;

public class Response<T> {
    /**
     * @author：lidantao
     * @time：2020.03.26晚上19：26
     * @SUCCESS_CODE：成功状态码
     * @SUCCESS_MSG：操作成功
     */
    private static final String SUCCESS_CODE = "200";
    private static final String SUCCESS_MSG = "操作成功！";

    /**
     * @author：lidantao
     * @time：2020.03.26晚上19：26
     * @SERVERS_CODE：系统繁忙状态码
     * @SERVERS_MSG：系统繁忙信息
     */
    private static final String SERVERS_CODE = "400";
    private static final String SERVERS_MSG = "系统繁忙！";

    /**
     * @author：lidantao
     * @time：2020.03.26晚上19：26
     * @ERROR_CODE：操作错误状态码
     * @ERROR_MSG：操作异常
     */
    private static final String ERROR_CODE = "500";
    private static final String ERROR_MSG = "操作异常！";

    /**
     * @author:lidantao
     * @time:2020.03.26晚上19：26
     * @code：返回状态码
     */
    private String code;

    /**
     * @author：lidantao
     * @time：2020.03.26晚上19：26
     * @msg:返回信息
     */
    private String msg;

    /**
     * @author：lidantao
     * @time:2020.03.26晚上19：26
     * @data：返回数据
     */
    private T data;

    /**
     * @author：lidantao
     * @time：2020.03.06晚上19：42
     * @funtion：方法重载
     */
    public Response(){}
    public Response(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public Response(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *
     * @return
     */
    public static Response success(){
        return new Response(SUCCESS_CODE,SUCCESS_MSG);
    }
    public static Response success(String msg, Object data){ return new Response(SUCCESS_CODE, msg, data); }
    public static Response success(String msg){
        return new Response(SUCCESS_CODE,SUCCESS_MSG,msg);
    }

    public static Response servers(){
        return new Response(SERVERS_CODE,SERVERS_MSG);
    }
    public static Response servers(String msg){
        return new Response(SERVERS_CODE,SERVERS_MSG,msg);
    }

    public static Response error(){
        return new Response(ERROR_CODE,ERROR_MSG);
    }
    public static Response error(String msg){
        return new Response(ERROR_CODE,ERROR_MSG,msg);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
