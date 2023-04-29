package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class MessageBean {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private static String value;
    /**
     * This function adds a PropertyChangeListener to the support object.
     * 
     * @param listener The listener parameter is an object that implements the PropertyChangeListener
     * interface. This listener will be notified when a property value changes in the object that this
     * method belongs to.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * This function removes a PropertyChangeListener from the support object.
     * 
     * @param listener The listener parameter is an object that implements the PropertyChangeListener
     * interface and is registered to receive property change events. This method removes the specified
     * listener from the list of listeners that are notified when a property value changes.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    /**
     * The function returns the value of a string.
     * 
     * @return The method `getValue()` is returning a `String` value.
     */
    public String getValue() {
        return value;
    }
    /**
     * This function sets a new value for a property and notifies any registered listeners of the
     * change.
     * 
     * @param newValue The new value that is being set for the "value" property.
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        support.firePropertyChange("value", oldValue, newValue);
    }

    /**
     * The function clears the value of a listener.
     */
    public void clearListener()
    {
        value = null;
    }
}
