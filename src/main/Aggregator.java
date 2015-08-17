package main;

import model.HHStrategy;
import model.Model;
import model.Provider;
import view.HtmlView;

/**
 * Created by Администратор on 09.07.2015.
 */
public class Aggregator {

    public static void main(String[] args) {
        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView, new Provider[]{new Provider(new HHStrategy())});
        Controller controller = new Controller(model);

        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod("kiev");
    }

}
