import model.Provider;

/**
 * Created by Администратор on 09.07.2015.
 */
public class Aggregator {

    public static void main(String[] args) {
        Provider provider = new Provider();
        Controller controller = new Controller(provider);
        System.out.println(controller);
    }

}
