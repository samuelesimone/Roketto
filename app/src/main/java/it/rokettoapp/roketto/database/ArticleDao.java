package it.rokettoapp.roketto.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.rokettoapp.roketto.model.Article;
import it.rokettoapp.roketto.model.ArticleType;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM favorite_article")
    List<Article> getAll();

    @Query("SELECT * FROM favorite_article WHERE mArticleType = 'ARTICLE'")
    List<Article> getArticles();

    @Query("SELECT * FROM favorite_article WHERE mArticleType = 'REPORT'")
    List<Article> getReports();

    @Query("SELECT * FROM favorite_article WHERE mArticleType = 'BLOG'")
    List<Article> getBlogPosts();

    @Insert
    void insertArticleList(List<Article> articleList);

    @Insert
    void insertArticle(Article article);

    @Delete
    void delete(Article article);

    @Query("DELETE FROM favorite_article")
    void deleteAll();
}
