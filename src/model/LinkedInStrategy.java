package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LinkedInStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://www.linkedin.com/vsearch/j?keywords=java+%s";


    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> listVacasies = new ArrayList<>();
        int page = 0;
        Document doc = null;
        try
        {
            doc = getDocument(searchString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return listVacasies;
    }

    protected Document getDocument(String searchString) throws IOException
    {
        String site = String.format(URL_FORMAT, searchString);
        return Jsoup.connect(site)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36")
                .get();
    }
}