package com.rumo.vo;

/**
 * Created by mofeng
 */
public enum ResponseCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"SERVER ERROR!!!"),
    NEED_LOGIN(201,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(401,"ILLEGAL_ARGUMENT"),
	VALIDATOR_ERROR(400,"PARMATER_ARGUMENT_ERROR");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
    
    @Override
	public String toString() {
		return "ResponseCode [code=" + code + ", desc=" + desc + "]";
	}

}