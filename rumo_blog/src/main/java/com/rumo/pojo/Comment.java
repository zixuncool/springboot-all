package com.rumo.pojo;

import java.util.Date;

public class Comment {
	
    private Integer id;
    private String content;
    private Date createTime;
    private Integer userId;
    private String ip;
    private Integer isDelete;
    private Integer status;
    private Integer contentId;
    private Integer isTop;
    private Date updateTime;
    private Integer parentId;
    private Integer replyUserid;
    private Float score;
    
    public Comment() {
        super();
    }
    
    public Comment(Integer id,String content,Date createTime,Integer userId,String ip,Integer isDelete,Integer status,Integer contentId,Integer isTop,Date updateTime,Integer parentId,Integer replyUserid,Float score) {
        super();
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.userId = userId;
        this.ip = ip;
        this.isDelete = isDelete;
        this.status = status;
        this.contentId = contentId;
        this.isTop = isTop;
        this.updateTime = updateTime;
        this.parentId = parentId;
        this.replyUserid = replyUserid;
        this.score = score;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getReplyUserid() {
        return replyUserid;
    }

    public void setReplyUserid(Integer replyUserid) {
        this.replyUserid = replyUserid;
    }
    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
 	
 	public String toString(Integer id,String content,Date createTime,Integer userId,String ip,Integer isDelete,Integer status,Integer contentId,Integer isTop,Date updateTime,Integer parentId,Integer replyUserid,Float score) {
        return "Comment:【this.id:"+id+",this.content:"+content+",this.createTime:"+createTime+",this.userId:"+userId+",this.ip:"+ip+",this.isDelete:"+isDelete+",this.status:"+status+",this.contentId:"+contentId+",this.isTop:"+isTop+",this.updateTime:"+updateTime+",this.parentId:"+parentId+",this.replyUserid:"+replyUserid+",this.score:"+score+"】";
    }
    
    public static class CommentBuilder{
 	   
	    private Integer id;
	    private String content;
	    private Date createTime;
	    private Integer userId;
	    private String ip;
	    private Integer isDelete;
	    private Integer status;
	    private Integer contentId;
	    private Integer isTop;
	    private Date updateTime;
	    private Integer parentId;
	    private Integer replyUserid;
	    private Float score;

 	    public String toString(){
 	    	 return "Comment.CommentBuilder:【this.id:"+id+",this.content:"+content+",this.createTime:"+createTime+",this.userId:"+userId+",this.ip:"+ip+",this.isDelete:"+isDelete+",this.status:"+status+",this.contentId:"+contentId+",this.isTop:"+isTop+",this.updateTime:"+updateTime+",this.parentId:"+parentId+",this.replyUserid:"+replyUserid+",this.score:"+score+"】";
 	    }

 	    public Comment build(){
 	      return new Comment(id,content,createTime,userId,ip,isDelete,status,contentId,isTop,updateTime,parentId,replyUserid,score);
 	    }

 	    public CommentBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public CommentBuilder content(String content){
 	      this.content = content;
 	      return this;
 	    }
 	    
 	    public CommentBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	    public CommentBuilder userId(Integer userId){
 	      this.userId = userId;
 	      return this;
 	    }
 	    
 	    public CommentBuilder ip(String ip){
 	      this.ip = ip;
 	      return this;
 	    }
 	    
 	    public CommentBuilder isDelete(Integer isDelete){
 	      this.isDelete = isDelete;
 	      return this;
 	    }
 	    
 	    public CommentBuilder status(Integer status){
 	      this.status = status;
 	      return this;
 	    }
 	    
 	    public CommentBuilder contentId(Integer contentId){
 	      this.contentId = contentId;
 	      return this;
 	    }
 	    
 	    public CommentBuilder isTop(Integer isTop){
 	      this.isTop = isTop;
 	      return this;
 	    }
 	    
 	    public CommentBuilder updateTime(Date updateTime){
 	      this.updateTime = updateTime;
 	      return this;
 	    }
 	    
 	    public CommentBuilder parentId(Integer parentId){
 	      this.parentId = parentId;
 	      return this;
 	    }
 	    
 	    public CommentBuilder replyUserid(Integer replyUserid){
 	      this.replyUserid = replyUserid;
 	      return this;
 	    }
 	    
 	    public CommentBuilder score(Float score){
 	      this.score = score;
 	      return this;
 	    }
 	    
 	  }

 	  public static Comment.CommentBuilder builder(){
 	    return new Comment.CommentBuilder();
 	  }
}