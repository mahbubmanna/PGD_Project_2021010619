package com.example.pgd_project_2021010619;

public class Post {

    String userName;
    String story;

    public Post() {
    }

    public Post(String userName, String story) {
        this.userName = userName;
        this.story = story;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
