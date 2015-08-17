package main;

import model.Provider;

import java.util.Arrays;

/**
 * Created by Администратор on 09.07.2015.
 */
public class Controller {

    private Provider[] providers;

    public Controller(Provider... provider) {
        if(provider.length == 0){
            throw new IllegalArgumentException();
        }
        this.providers = provider;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
