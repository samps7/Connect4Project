package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class MessageBean {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private static String value;
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    public String getValue() {
        return value;
    }
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        support.firePropertyChange("value", oldValue, newValue);
    }

    public void clearListener()
    {
        value = null;
    }
}
