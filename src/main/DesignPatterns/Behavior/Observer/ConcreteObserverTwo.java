package DesignPatterns.Behavior.Observer;

public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("2号观察者收到消息");
    }
}
