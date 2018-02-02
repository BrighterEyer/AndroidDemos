package com.ormlitedemo;

import android.test.AndroidTestCase;
import android.util.Log;

import com.bean.Article;
import com.bean.User;
import com.dao.ArticleDao;
import com.dao.UserDao;

import org.junit.Test;

import java.util.List;

/**
 * Created by bluedragon on 18-1-31.
 */

public class OrmLiteDbTest extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAddArticle() {
        User u = new User();
        u.setName("张鸿洋");
        new UserDao(getContext()).add(u);
        Article article = new Article();
        article.setTitle("ORMLite的使用");
        article.setUser(u);
        new ArticleDao(getContext()).add(article);
    }

    public void testGetArticleById() {
        Article article = new ArticleDao(getContext()).get(1);
        Log.e("", article.getUser() + " , " + article.getTitle());
    }

    public void testGetArticleWithUser() {
        Article article = new ArticleDao(getContext()).getArticleWithUser(1);
        Log.e("", article.getUser() + " , " + article.getTitle());
    }

    public void testListArticlesByUserId() {
        List<Article> articles = new ArticleDao(getContext()).listByUserId(1);
        Log.e("", articles.toString());
    }

    public void testGetUserById() {
        User user = new UserDao(getContext()).get(1);
        Log.e("testGetUserById", user.getName());
        if (user.getArticles() != null)
            for (Article article : user.getArticles()) {
                Log.e("testGetUserById", article.toString());
            }
    }
}