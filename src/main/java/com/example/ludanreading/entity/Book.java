package com.example.ludanreading.entity;

import java.io.Serializable;
import java.util.Date;

public class Book extends BaseEntity {
    private Integer bid;
    private String bookname;
    private String author;
    private String path;
    private int isDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (getIsDelete() != book.getIsDelete()) return false;
        if (getBid() != null ? !getBid().equals(book.getBid()) : book.getBid() != null) return false;
        if (getBookname() != null ? !getBookname().equals(book.getBookname()) : book.getBookname() != null)
            return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        return getPath() != null ? getPath().equals(book.getPath()) : book.getPath() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getBid() != null ? getBid().hashCode() : 0);
        result = 31 * result + (getBookname() != null ? getBookname().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getPath() != null ? getPath().hashCode() : 0);
        result = 31 * result + getIsDelete();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", path='" + path + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}

