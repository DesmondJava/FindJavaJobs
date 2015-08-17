package view;

import main.Controller;
import vo.Vacancy;

import java.util.List;

/**
 * Created by Администратор on 17.08.2015.
 */
public class HtmlView implements View {

    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
