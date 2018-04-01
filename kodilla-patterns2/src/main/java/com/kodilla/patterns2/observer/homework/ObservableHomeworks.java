package com.kodilla.patterns2.observer.homework;

public interface ObservableHomeworks {
    void registerObserver(ObseverMentor obseverMentor);
    void notifytObserver();
    void removeObserver(ObseverMentor obseverMentor);

}
