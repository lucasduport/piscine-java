package fr.epita.assistants.observer;

public class Lifeguard implements Observable.Observer<Swimmer> {
    private String name;

    @Override
    public void onEvent(Swimmer event) {
        switch (event.getStatus()) {
            case DROWNING -> System.out.println(this.name + ": I will save you " + event.getName() + "!");
            case TOO_FAR -> System.out.println(this.name + ": " + event.getName() + "! You are too far, come back!");
        }
    }

    public Lifeguard(String name) {
        this.name = name;
        System.out.println(this.name + " begins to keep an eye on the swimmers.");
    }
}
