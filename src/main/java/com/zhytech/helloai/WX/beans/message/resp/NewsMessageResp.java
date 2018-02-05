package com.zhytech.helloai.WX.beans.message.resp;

import java.util.List;

/**
 * Created by zhy on 2017/4/30.
 */
public class NewsMessageResp extends BaseMessageResp {
    private int ArticleCount;
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
