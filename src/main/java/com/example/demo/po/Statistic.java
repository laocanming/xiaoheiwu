package com.example.demo.po;

public class Statistic {
    private Long id;
    private String title;
    private String created;
    private Long hits;
    private String categories;

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created='" + created + '\'' +
                ", hits=" + hits +
                ", categories='" + categories + '\'' +
                '}';
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
