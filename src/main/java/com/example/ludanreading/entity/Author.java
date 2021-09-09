package com.example.ludanreading.entity;

public class Author extends BaseEntity{
    private Integer aid;
    private String authorname;
    private String avatar;
    private String introduction;
    private int isDelete;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aid=" + aid +
                ", authorname='" + authorname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        if (!super.equals(o)) return false;

        Author author = (Author) o;

        if (getIsDelete() != author.getIsDelete()) return false;
        if (getAid() != null ? !getAid().equals(author.getAid()) : author.getAid() != null) return false;
        if (getAuthorname() != null ? !getAuthorname().equals(author.getAuthorname()) : author.getAuthorname() != null)
            return false;
        if (getAvatar() != null ? !getAvatar().equals(author.getAvatar()) : author.getAvatar() != null) return false;
        return getIntroduction() != null ? getIntroduction().equals(author.getIntroduction()) : author.getIntroduction() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAid() != null ? getAid().hashCode() : 0);
        result = 31 * result + (getAuthorname() != null ? getAuthorname().hashCode() : 0);
        result = 31 * result + (getAvatar() != null ? getAvatar().hashCode() : 0);
        result = 31 * result + (getIntroduction() != null ? getIntroduction().hashCode() : 0);
        result = 31 * result + getIsDelete();
        return result;
    }
}
