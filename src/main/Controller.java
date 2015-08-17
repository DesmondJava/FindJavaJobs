package main;

import model.Model;

/**
 * Created by Администратор on 09.07.2015.
 */
public class Controller {

    private Model model;

    public Controller(Model model)
    {
        if(model == null){
            throw new IllegalArgumentException();
        }
        this.model = model;
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }

}
