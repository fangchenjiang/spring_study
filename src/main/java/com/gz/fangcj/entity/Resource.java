package com.gz.fangcj.entity;

import java.io.Serializable;

public class Resource implements Serializable {
    private Long id;

    private String resourcename;

    private Integer resourcestatus;

    private String resourceurl;

    private String resourcedescription;

    private Long resourcepid;

    private Integer resourcelevel;

    private String resourcetype;

    private Integer isorg;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public Integer getResourcestatus() {
        return resourcestatus;
    }

    public void setResourcestatus(Integer resourcestatus) {
        this.resourcestatus = resourcestatus;
    }

    public String getResourceurl() {
        return resourceurl;
    }

    public void setResourceurl(String resourceurl) {
        this.resourceurl = resourceurl;
    }

    public String getResourcedescription() {
        return resourcedescription;
    }

    public void setResourcedescription(String resourcedescription) {
        this.resourcedescription = resourcedescription;
    }

    public Long getResourcepid() {
        return resourcepid;
    }

    public void setResourcepid(Long resourcepid) {
        this.resourcepid = resourcepid;
    }

    public Integer getResourcelevel() {
        return resourcelevel;
    }

    public void setResourcelevel(Integer resourcelevel) {
        this.resourcelevel = resourcelevel;
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Integer getIsorg() {
        return isorg;
    }

    public void setIsorg(Integer isorg) {
        this.isorg = isorg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resourcename=").append(resourcename);
        sb.append(", resourcestatus=").append(resourcestatus);
        sb.append(", resourceurl=").append(resourceurl);
        sb.append(", resourcedescription=").append(resourcedescription);
        sb.append(", resourcepid=").append(resourcepid);
        sb.append(", resourcelevel=").append(resourcelevel);
        sb.append(", resourcetype=").append(resourcetype);
        sb.append(", isorg=").append(isorg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}