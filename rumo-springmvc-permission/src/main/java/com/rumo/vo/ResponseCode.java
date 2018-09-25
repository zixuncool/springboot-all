package com.rumo.vo;

/**
 * Created by mofeng
 */
public enum ResponseCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    NEED_LOGIN(201,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(401,"ILLEGAL_ARGUMENT"),
	VALIDATOR_ERROR(402,"PARMATER_ARGUMENT_VALIDATOR_ERROR");

    private final int code;
    private final String desc;
    private final String field;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
        this.field = "";
    }

    ResponseCode(int code,String desc,String field){
        this.code = code;
        this.desc = desc;
        this.field = field;
    }
    
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
    
    public String getField() {
		return field;
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", desc=" + desc + "]";
	}

}