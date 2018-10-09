package com.rumo.pojo;

import java.util.Date;

public class Blog {
	
    private Integer id;
    private String title;
    private Date createTime;
    private Date updateTime;
    private Integer isDelete;
    private Long userId;
    private Integer status;
    private String description;
    private String img;
    private String tag;
    private Integer kcolumn;
    private String musicLink;
    private String staticLink;
    private String videolink;
    private String appLink;
    private Integer hits;
    private Integer categoryId;
    private Integer width;
    private Integer height;
    private Integer isComment;
    private String isOpen;
    private Integer blogId;
    private Integer courseId;
    private String thumnimg;
    private Integer loves;
    private Float price;//文章价格
    
    //多对一关联
    private Category category;
    //多对一用户关联
    private User user ;
   

	public Blog() {
        super();
    }

	public Blog(Integer id, String title, Date createTime, Date updateTime, Integer isDelete, Long userId,
			Integer status, String description, String img, String tag, Integer kcolumn, String musicLink,
			String staticLink, String videolink, String appLink, Integer hits, Integer categoryId, Integer width,
			Integer height, Integer isComment, String isOpen, Integer blogId, Integer courseId, String thumnimg,
			Integer loves, Float price) {
		super();
		this.id = id;
		this.title = title;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.userId = userId;
		this.status = status;
		this.description = description;
		this.img = img;
		this.tag = tag;
		this.kcolumn = kcolumn;
		this.musicLink = musicLink;
		this.staticLink = staticLink;
		this.videolink = videolink;
		this.appLink = appLink;
		this.hits = hits;
		this.categoryId = categoryId;
		this.width = width;
		this.height = height;
		this.isComment = isComment;
		this.isOpen = isOpen;
		this.blogId = blogId;
		this.courseId = courseId;
		this.thumnimg = thumnimg;
		this.loves = loves;
		this.price = price;
	}





	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public Integer getKcolumn() {
        return kcolumn;
    }

    public void setKcolumn(Integer kcolumn) {
        this.kcolumn = kcolumn;
    }
    public String getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(String musicLink) {
        this.musicLink = musicLink;
    }
    public String getStaticLink() {
        return staticLink;
    }

    public void setStaticLink(String staticLink) {
        this.staticLink = staticLink;
    }
    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }
    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }
    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }
    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getThumnimg() {
        return thumnimg;
    }

    public void setThumnimg(String thumnimg) {
        this.thumnimg = thumnimg;
    }
    
 	public Integer getLoves() {
		return loves;
	}

	public void setLoves(Integer loves) {
		this.loves = loves;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
    
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", isDelete=" + isDelete + ", userId=" + userId + ", status=" + status + ", description="
				+ description + ", img=" + img + ", tag=" + tag + ", kcolumn=" + kcolumn + ", musicLink=" + musicLink
				+ ", staticLink=" + staticLink + ", videolink=" + videolink + ", appLink=" + appLink + ", hits=" + hits
				+ ", categoryId=" + categoryId + ", width=" + width + ", height=" + height + ", isComment=" + isComment
				+ ", isOpen=" + isOpen + ", blogId=" + blogId + ", courseId=" + courseId + ", thumnimg=" + thumnimg
				+ ", loves=" + loves + ", price=" + price + ", category=" + category + ", user=" + user + "]";
	}



	public static class BlogBuilder{
 	   
	    private Integer id;
	    private String title;
	    private Date createTime;
	    private Date updateTime;
	    private Integer isDelete;
	    private Long userId;
	    private Integer status;
	    private String description;
	    private String img;
	    private String tag;
	    private Integer kcolumn;
	    private String musicLink;
	    private String staticLink;
	    private String videolink;
	    private String appLink;
	    private Integer hits;
	    private Integer categoryId;
	    private Integer width;
	    private Integer height;
	    private Integer isComment;
	    private String isOpen;
	    private Integer blogId;
	    private Integer courseId;
	    private String thumnimg;
	    private Integer loves;
	    private Float price;
	    
	   

 	    public String toString(){
 	    	 return "Blog.BlogBuilder:【this.id:"+id+",this.title:"+title+",this.createTime:"+createTime+",this.updateTime:"+updateTime+",this.isDelete:"+isDelete+",this.userId:"+userId+",this.status:"+status+",this.description:"+description+",this.img:"+img+",this.tag:"+tag+",this.kcolumn:"+kcolumn+",this.musicLink:"+musicLink+",this.staticLink:"+staticLink+",this.videolink:"+videolink+",this.appLink:"+appLink+",this.hits:"+hits+",this.categoryId:"+categoryId+",this.width:"+width+",this.height:"+height+",this.isComment:"+isComment+",this.isOpen:"+isOpen+",this.blogId:"+blogId+",this.courseId:"+courseId+",this.thumnimg:"+thumnimg+"】";
 	    }

 	    public Blog build(){
 	      return new Blog(id,title,createTime,updateTime,isDelete,userId,status,description,img,tag,kcolumn,musicLink,staticLink,videolink,appLink,hits,categoryId,width,height,isComment,isOpen,blogId,courseId,thumnimg,loves,price);
 	    }

 	    public BlogBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public BlogBuilder title(String title){
 	      this.title = title;
 	      return this;
 	    }
 	    
 	    public BlogBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	    public BlogBuilder updateTime(Date updateTime){
 	      this.updateTime = updateTime;
 	      return this;
 	    }
 	    
 	    public BlogBuilder isDelete(Integer isDelete){
 	      this.isDelete = isDelete;
 	      return this;
 	    }
 	    
 	    public BlogBuilder userId(Long userId){
 	      this.userId = userId;
 	      return this;
 	    }
 	    
 	    public BlogBuilder status(Integer status){
 	      this.status = status;
 	      return this;
 	    }
 	    
 	    public BlogBuilder description(String description){
 	      this.description = description;
 	      return this;
 	    }
 	    
 	    public BlogBuilder img(String img){
 	      this.img = img;
 	      return this;
 	    }
 	    
 	    public BlogBuilder tag(String tag){
 	      this.tag = tag;
 	      return this;
 	    }
 	    
 	    public BlogBuilder kcolumn(Integer kcolumn){
 	      this.kcolumn = kcolumn;
 	      return this;
 	    }
 	    
 	    public BlogBuilder musicLink(String musicLink){
 	      this.musicLink = musicLink;
 	      return this;
 	    }
 	    
 	    public BlogBuilder staticLink(String staticLink){
 	      this.staticLink = staticLink;
 	      return this;
 	    }
 	    
 	    public BlogBuilder videolink(String videolink){
 	      this.videolink = videolink;
 	      return this;
 	    }
 	    
 	    public BlogBuilder appLink(String appLink){
 	      this.appLink = appLink;
 	      return this;
 	    }
 	    
 	    public BlogBuilder hits(Integer hits){
 	      this.hits = hits;
 	      return this;
 	    }
 	    
 	    public BlogBuilder categoryId(Integer categoryId){
 	      this.categoryId = categoryId;
 	      return this;
 	    }
 	    
 	    public BlogBuilder width(Integer width){
 	      this.width = width;
 	      return this;
 	    }
 	    
 	    public BlogBuilder height(Integer height){
 	      this.height = height;
 	      return this;
 	    }
 	    
 	    public BlogBuilder isComment(Integer isComment){
 	      this.isComment = isComment;
 	      return this;
 	    }
 	    
 	    public BlogBuilder isOpen(String isOpen){
 	      this.isOpen = isOpen;
 	      return this;
 	    }
 	    
 	    public BlogBuilder blogId(Integer blogId){
 	      this.blogId = blogId;
 	      return this;
 	    }
 	    
 	    public BlogBuilder courseId(Integer courseId){
 	      this.courseId = courseId;
 	      return this;
 	    }
 	    
 	    public BlogBuilder thumnimg(String thumnimg){
 	      this.thumnimg = thumnimg;
 	      return this;
 	    }
 	    
 	    public BlogBuilder loves(Integer loves){
  	      this.loves = loves;
  	      return this;
  	    }
 	    
 	   public BlogBuilder price(Float price){
   	      this.price = price;
   	      return this;
   	    }
 	  }

 	  public static Blog.BlogBuilder builder(){
 	    return new Blog.BlogBuilder();
 	  }
}