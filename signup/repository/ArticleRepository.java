package com.cts.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.signup.bean.FavouriteArticle;


public interface ArticleRepository  extends JpaRepository<FavouriteArticle,Integer>{
public FavouriteArticle findById(int id);
public FavouriteArticle findByTitle(String title);
}
