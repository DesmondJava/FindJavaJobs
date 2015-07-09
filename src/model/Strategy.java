package model;

import vo.Vacancy;

import java.util.List;

/**
 * Created by Администратор on 09.07.2015.
 */
public interface Strategy {

    List<Vacancy> getVacancies(String searchString);
}
