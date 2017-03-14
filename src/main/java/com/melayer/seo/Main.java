package com.melayer.seo;

import com.melayer.domain.Article;
import us.monoid.json.JSONException;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import java.io.IOException;

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

        try {
            JSONResource res = new Resty().json("http://ipinfo.io");
            System.out.printf("\n Json is %s", res.toObject().toString());
            System.out.printf("\n Ip is - %s", res.object().getString("ip"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
