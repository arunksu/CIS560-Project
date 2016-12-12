package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // primary key
	
	@Column(unique = true)
	private String name;
	
	@Column(name = "release_date")
	private String release;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	/*** relations ***/
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Genre> genres = new ArrayList<>();
	
	@ManyToMany
	private List<ScoreWebsite> scoreWebsites = new ArrayList<>();
	
	@OneToMany
	private List<PurchaseWebsite> purchaseWebsites = new ArrayList<>();
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Score> scores = new ArrayList<>();
	
	@ManyToMany(mappedBy = "games")
	private List<System> systems = new ArrayList<>();
	
	@ManyToOne(targetEntity = Developer.class, cascade = CascadeType.ALL)
	private Developer developer;
	
	@ManyToOne(targetEntity = Publisher.class,cascade = CascadeType.ALL)
	private Publisher publisher;
	
	public Game() {
	}
	
	public Game(String name, String release) {
		this.name = name;
		this.release = release;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}
	
	public String getRelease() {
		return this.release;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public void addScoreWebsite(ScoreWebsite scoreWebsite){
		scoreWebsites.add(scoreWebsite);
	}
	
	public void setScoreWebsites(List<ScoreWebsite> scoreWebsites) {
		this.scoreWebsites = scoreWebsites;
	}
	
	public List<ScoreWebsite> getScoreWebsites() {
		return scoreWebsites;
	}
	
	public void addScore(Score score) {
		scores.add(score);
	}
	
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	public void setSystems(List<System> systems) {
		this.systems = systems;
	}
	
	public List<System> getSystems() {
		return systems;
	}
	
	@Override
	public String toString() {
		return String.format("Game[id: %d name: %s release: %s]",
		                     id, name, release);
	}
}
