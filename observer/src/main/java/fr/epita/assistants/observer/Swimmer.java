package fr.epita.assistants.observer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<Swimmer>{

    private Set<Observer<Swimmer>> observers;
    private String name;
    private SwimmerStatus status = SwimmerStatus.OK;

    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return null;
    }

    public Swimmer(String name)
    {
        this.name = name;
        observers = new HashSet<>();
        System.out.println(this.name + " goes into the sea.");
    }

    @Override
    public void register(Observer<Swimmer>... observers) {

        this.observers.addAll(Arrays.asList(observers));
        System.out.println("Lifeguard begins to keep an eye on the swimmers.");
    }

    @Override
    public void unregister(Observer<Swimmer> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void fire(Swimmer event) {
        for (var o: observers
             ) {
            o.onEvent(event);
        }
    }

    public void setStatus(SwimmerStatus status) {
        switch (status)
        {
            case WAVING ->System.out.println(this.name +": Waves towards the shore.");
            case DROWNING -> System.out.println(this.name +": I'm drowning, help!!");
        }
        this.status = status;
        fire(this);
    }

    public String getName() {
        return name;
    }

    public SwimmerStatus getStatus() {
        return status;
    }
}
