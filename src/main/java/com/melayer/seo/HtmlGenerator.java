package com.melayer.seo;

import com.melayer.domain.Article;
import htmlflow.HtmlView;
import htmlflow.HtmlWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by aniruddha on 14/3/17.
 */
public class HtmlGenerator {

    private <T> void makeHtml(HtmlWriter<T> html, T model, String path){
        try(PrintStream out = new PrintStream(new FileOutputStream(path+".html"))){
            html.setPrintStream(out).write(model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HtmlView<Article> articleView(Article article){
        HtmlView<Article> taskView = new HtmlView<>();
        taskView
                .head()
                .title("Task Details")
                .linkCss("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css");
        taskView
                .body().classAttr("container")
                .heading(1, article.getName())
                .hr()
                .div()
                .text("Title: ").text(article.getName())
                .br()
                .text("Description: ").text(article.getDescription())
                .br();

        return taskView;
    }

    public void saveArticle(Article article) {
        makeHtml(articleView(article), article, article.getName());
    }

    public void saveMultimedia() {

    }
 }
