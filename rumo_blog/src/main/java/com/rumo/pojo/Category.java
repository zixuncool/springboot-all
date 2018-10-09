package com.rumo.pojo;

import java.util.Date;

public class Category {
	
    private Integer id;
    private String name;
    private Date createTime;
    private Integer isDelete;
    private Integer sort;
    private String icon;
    private Integer parentId;
    private String img;
    private String description;
    private Integer ispush;
    private String background;
    private Integer collegeId;
    private Integer type;
    
    public Category() {
        super();
    }
    
    public Category(Integer id,String name,Date createTime,Integer isDelete,Integer sort,String icon,Integer parentId,String img,String description,Integer ispush,String background,Integer collegeId,Integer type) {
        super();
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.isDelete = isDelete;
        this.sort = sort;
        this.icon = icon;
        this.parentId = parentId;
        this.img = img;
        this.description = description;
        this.ispush = ispush;
        this.background = background;
        this.collegeId = collegeId;
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getIspush() {
        return ispush;
    }

    public void setIspush(Integer ispush) {
        this.ispush = ispush;
    }
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
 	
 	public String toString(Integer id,String name,Date createTime,Integer isDelete,Integer sort,String icon,Integer parentId,String img,String description,Integer ispush,String background,Integer collegeId,Integer type) {
        return "Category:【this.id:"+id+",this.name:"+name+",this.createTime:"+createTime+",this.isDelete:"+isDelete+",this.sort:"+sort+",this.icon:"+icon+",this.parentId:"+parentId+",this.img:"+img+",this.description:"+description+",this.ispush:"+ispush+",this.background:"+background+",this.collegeId:"+collegeId+",this.type:"+type+"】";
    }
    
    public static class CategoryBuilder{
 	   
	    private Integer id;
	    private String name;
	    private Date createTime;
	    private Integer isDelete;
	    private Integer sort;
	    private String icon;
	    private Integer parentId;
	    private String img;
	    private String description;
	    private Integer ispush;
	    private String background;
	    private Integer collegeId;
	    private Integer type;

 	    public String toString(){
 	    	 return "Category.CategoryBuilder:【this.id:"+id+",this.name:"+name+",this.createTime:"+createTime+",this.isDelete:"+isDelete+",this.sort:"+sort+",this.icon:"+icon+",this.parentId:"+parentId+",this.img:"+img+",this.description:"+description+",this.ispush:"+ispush+",this.background:"+background+",this.collegeId:"+collegeId+",this.type:"+type+"】";
 	    }

 	    public Category build(){
 	      return new Category(id,name,createTime,isDelete,sort,icon,parentId,img,description,ispush,background,collegeId,type);
 	    }

 	    public CategoryBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder name(String name){
 	      this.name = name;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder isDelete(Integer isDelete){
 	      this.isDelete = isDelete;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder sort(Integer sort){
 	      this.sort = sort;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder icon(String icon){
 	      this.icon = icon;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder parentId(Integer parentId){
 	      this.parentId = parentId;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder img(String img){
 	      this.img = img;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder description(String description){
 	      this.description = description;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder ispush(Integer ispush){
 	      this.ispush = ispush;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder background(String background){
 	      this.background = background;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder collegeId(Integer collegeId){
 	      this.collegeId = collegeId;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder type(Integer type){
 	      this.type = type;
 	      return this;
 	    }
 	    
 	  }

 	  public static Category.CategoryBuilder builder(){
 	    return new Category.CategoryBuilder();
 	  }
}