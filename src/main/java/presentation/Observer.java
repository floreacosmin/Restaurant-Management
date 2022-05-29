package presentation;

import business.Observable;
import business.Orders;

public interface Observer {
    void update(Observable o);
}
