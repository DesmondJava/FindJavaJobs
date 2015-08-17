package view;

import main.Controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import vo.Vacancy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;



public class HtmlView implements View {

    private Controller controller;

    private final String FILEPATH = String.format(
            "./src/%s/vacancies.html",
            this.getClass().getPackage().toString().replaceAll("\\.", "/").substring(8));

    private String getUpdatedFileContent(List<Vacancy> list){

        Document htmlFile = null;
        try {
            // parsing vacancies.html
            htmlFile = getDocument();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }

        // Create template html for vacancies
        assert htmlFile != null;
        Element elementTemlate = htmlFile.select("tr.template").first().clone();
        elementTemlate.removeAttr("style");
        elementTemlate.removeClass("template");

        // Delete old vacancies
        for( Element element : htmlFile.select("tr[class=vacancy]") )
        {
            element.remove();
        }

        // Generating new vacancies for vacancies.html from List<Vacancy>
        for(Vacancy vacancy : list){
            Element newVacancy = elementTemlate.clone();
            newVacancy.getElementsByClass("city").append(vacancy.getCity());
            newVacancy.getElementsByClass("companyName").append(vacancy.getCompanyName());
            newVacancy.getElementsByClass("salary").append(vacancy.getSalary());
            newVacancy.getElementsByTag("a").append(vacancy.getTitle());
            newVacancy.select("a[href]").first().attr("href", vacancy.getUrl());
            Element tr = htmlFile.select("tr.template").first();
            tr.before(newVacancy);
        }

        return htmlFile.toString();
    }

    protected Document getDocument() throws IOException{
        // parsing vacancies.html
        return Jsoup.parse(new File(FILEPATH), "UTF-8");
    }

    private void updateFile(String file){
        try(OutputStream writeFile = new FileOutputStream(FILEPATH))
        {
            byte[] stringBytes = file.getBytes();
            writeFile.write(stringBytes);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void update(List<Vacancy> vacancies)
    {
        String newVacanciesHTML = getUpdatedFileContent(vacancies);
        updateFile(newVacanciesHTML);
    }

    // Вернуть когда пофиксят задачу
    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Kiev");
    }


    public void userCitySelectEmulationMethod(String request){
        controller.onCitySelect(request);
    }


    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
}
