package tn.esprit.infinity_server.persistence;

import java.util.List;

public class NewsCollection {

    private String status;
    private String source;
    private String sortBy;
    private List<NewsArticle> articles;

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<NewsArticle> getArticles() {
        return articles;
    }
}
