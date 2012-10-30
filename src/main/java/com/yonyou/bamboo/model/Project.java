package com.yonyou.bamboo.model;

import java.util.Date;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Project {

    private Integer id;
    @NotNull(message = "项目名称不能为空！")
    @Size(max = 100, message = "项目名称最大长度为100")
    // @Pattern(regexp = "[\u4e00-\u9fa5]+", message = "项目名称必须为中文")
    private String name;
    @NotNull(message = "英文缩写不能为空！")
    @Size(max = 100, message = "英文缩写最大长度为100")
    private String abbr;
    private Integer createBy;
    private Date createDate;
    private Integer modifyBy;
    private Date modifyDate;

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

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

}
