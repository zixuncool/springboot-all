package com.rumo.pojo;

import java.util.Date;

public class Log {
    private Integer id;

    private Integer type;

    private Integer targetId;

    private String oldvalue;

    private String newvalue;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private Integer status;

    public Log(Integer id, Integer type, Integer targetId, String oldvalue, String newvalue, String operator, Date operateTime, String operateIp, Integer status) {
        this.id = id;
        this.type = type;
        this.targetId = targetId;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
        this.operator = operator;
        this.operateTime = operateTime;
        this.operateIp = operateIp;
        this.status = status;
    }

    public Log() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue == null ? null : oldvalue.trim();
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue == null ? null : newvalue.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
}