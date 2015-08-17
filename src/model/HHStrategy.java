package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 09.07.2015.
 */
public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> listVacasies = new ArrayList<>();
        int page = 0;
        while(true)
        {
            try
            {
                Document doc = getDocument(searchString, page);
                Elements vacansy = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if(vacansy.size() == 0) break;
                for (Element element : vacansy)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    vacancy.setSiteName(doc.title());
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    listVacasies.add(vacancy);
                }
                page++;
            }
            catch (IOException e) {
                /*NOP*/
            }

        }
        return listVacasies;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        String site = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(site).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36").referrer("http://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2").get();
    }

}
