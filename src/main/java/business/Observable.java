package business;

import presentation.Observer;

public interface Observable {
    void notifyObservers(Observable o);
    void addObserver(Observer o);
}
