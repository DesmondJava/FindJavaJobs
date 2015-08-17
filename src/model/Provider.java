package model;

import vo.Vacancy;

import java.util.List;

/**
 * Created by Администратор on 09.07.2015.
 */
public class Provider {

    private Strategy strategy;

    public Provider()
    {

    }


    public List<Vacancy> getJavaVacancies(String searchString){
        return strategy.getVacancies(searchString);
    }

}
