package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String review;
    private int numOfStars;
    private boolean recommend;
    @ManyToOne
    private Person person;

    protected Rating() {

    }
    public Rating(String review, int numOfStars, boolean recommend, Person person) {
        this.review = review;
        this.numOfStars = numOfStars;
        this.recommend = recommend;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getNumOfStars() {
        return numOfStars;
    }

    public void setNumOfStars(int numOfStars) {
        this.numOfStars = numOfStars;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
