package model;

/**
 * Created by Администратор on 09.07.2015.
 */
public class Provider {

    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

}
