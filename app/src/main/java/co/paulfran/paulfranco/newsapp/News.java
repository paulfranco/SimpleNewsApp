package co.paulfran.paulfranco.newsapp;

public class News {

    // News article title
    private String mTitle;

    // News article section
    private String mSectionName;

    // News article Url
    private String mWebURL;

    // Publication date and time
    private String mPublicationDate;

    // Constructor for the news article
    public News(String title, String sectionName, String webURL, String publicationDate) {
        mTitle = title;
        mSectionName = sectionName;
        mWebURL = webURL;
        mPublicationDate = publicationDate;
    }

    // Getters
    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getWebURL() {
        return mWebURL;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }
}
