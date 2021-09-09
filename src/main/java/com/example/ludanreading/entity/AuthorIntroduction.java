package com.example.ludanreading.entity;

public class AuthorIntroduction {
    private String name;
    private String introduction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "AuthorIntroduction{" +
                "name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorIntroduction)) return false;

        AuthorIntroduction that = (AuthorIntroduction) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getIntroduction() != null ? getIntroduction().equals(that.getIntroduction()) : that.getIntroduction() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getIntroduction() != null ? getIntroduction().hashCode() : 0);
        return result;
    }
}
