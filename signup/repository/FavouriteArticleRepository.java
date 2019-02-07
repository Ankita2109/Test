package com.cts.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.cts.signup.bean.FavouriteArticle;


@RestController
public interface FavouriteArticleRepository  extends JpaRepository<FavouriteArticle,Integer>{

	FavouriteArticle findById(int id);
}
