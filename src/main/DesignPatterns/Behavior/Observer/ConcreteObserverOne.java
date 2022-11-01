package DesignPatterns.Behavior.Observer;

public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("1号观察者收到消息");
    }
}
