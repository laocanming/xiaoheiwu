package com.example.demo.po;

import java.util.List;

public class Administration {
    Long id;
    String title;
    String content;
    String created;
    String modified;
    String categories;
    String  tags;
    String allow_comment;
    String thumbnail;
    String c_content;
    String author;
    String c_created;

    @Override
    public String toString() {
        return "Administration{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", allow_comment='" + allow_comment + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", c_content='" + c_content + '\'' +
                ", author='" + author + '\'' +
                ", c_created='" + c_created + '\'' +
                '}';
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getC_created() {
        return c_created;
    }

    public void setC_created(String c_created) {
        this.c_created = c_created;
    }

    public Administration() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAllow_comment() {
        return allow_comment;
    }

    public void setAllow_comment(String allow_comment) {
        this.allow_comment = allow_comment;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
