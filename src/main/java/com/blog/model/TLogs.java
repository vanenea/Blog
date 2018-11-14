package com.blog.model;

import com.blog.utls.JsonDateValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TLogs {
    private Integer id;

    private String action;

    private String data;

    private Integer authorId;

    private String ip;
    @JsonSerialize(using=JsonDateValue.class)
    private long created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}