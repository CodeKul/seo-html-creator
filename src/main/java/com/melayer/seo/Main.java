package com.melayer.seo;

import com.melayer.domain.Article;

/**
 * Created by aniruddha on 14/3/17.
 */
public class Main {

    public static void main(String[] args) {

        Article article = new Article();
        article.setDescription("This is android course");
        article.setName("Android development in pune");
        HtmlGenerator generator = new HtmlGenerator();
        generator.saveArticle(article);
    }
}
