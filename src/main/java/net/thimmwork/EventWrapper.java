package net.thimmwork;

public class EventWrapper {
    private Object event;

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }

    public void clear() {
        this.event = null;
    }
}
