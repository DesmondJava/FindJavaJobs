package model;

import view.View;
import vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 17.08.2015.
 */
public class Model {

    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers)
    {
        if(view == null || providers == null || providers.length == 0){
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<Vacancy> result = new ArrayList<>();

        for(Provider provider : providers){
            List<Vacancy> vacancies = provider.getJavaVacancies(city);
            for(Vacancy vacancy : vacancies){
                result.add(vacancy);
            }
        }
        this.view.update(result);
    }

}
