package co.paulfran.paulfranco.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {

    public static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    /**
     * Contructs a new (@link NewsAdapter}.
     * @param context of the app
     * @param news is the list of new, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check is there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }
        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Get the section name of the current News object,
        String sectionName = currentNews.getSectionName();
        // Get the news title of the current News object
        String newsTitle = currentNews.getTitle();
        // Get the date of the current News object
        String newsDate = currentNews.getPublicationDate();
        String newsTime = currentNews.getPublicationDate();


        // Find the TextView with view id news_section
        TextView newsSectionTextView = (TextView) listItemView.findViewById(R.id.news_section);
        // Display section name in that TextView
        newsSectionTextView.setText(sectionName);

        // Find the TextView with view id news_title
        TextView newsTitleTextView = (TextView) listItemView.findViewById(R.id.news_title);
        // Display news title in that TextView
        newsTitleTextView.setText(newsTitle);

        // Find the TextView with the id news_publication_date
        TextView newsPublicationDateTimeTextView = (TextView) listItemView.findViewById(R.id.news_publication_date);
        // Display news date in that TextView
        newsPublicationDateTimeTextView.setText(convertDateFormat(newsDate));

        // Find the TextView with the id news_publication_time
        TextView newsPublicationTimeTextView = (TextView) listItemView.findViewById(R.id.news_publication_time);
        // Display news time in that TextView
        newsPublicationTimeTextView.setText(convertTimeFormat(newsTime));


        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }
    // Convert json DateTime to Date and Time
    public String convertDateFormat(String input) {
        input = input.substring(0, input.length() - 1);
        String oldFormat = "yyyy-MM-dd'T'HH:mm:ss";
        String newFormat = "MM/dd/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(oldFormat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(newFormat);
        Date date = null;
        String output = "";
        try {
            date = inputFormat.parse(input);
            output = outputFormat.format(date);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "DateTime parse exception: " + e);
        }
        return output;
    }

    public String convertTimeFormat(String input) {
        input = input.substring(0, input.length() - 1);
        String oldFormat = "yyyy-MM-dd'T'HH:mm:ss";
        String newFormat = "HH:mm";
        SimpleDateFormat inputFormat = new SimpleDateFormat(oldFormat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(newFormat);
        Date date = null;
        String output = "";
        try {
            date = inputFormat.parse(input);
            output = outputFormat.format(date);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "DateTime parse exception: " + e);
        }
        return output;
    }

}
