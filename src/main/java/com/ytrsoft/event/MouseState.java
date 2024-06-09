package com.ytrsoft.event;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseState implements MouseListener {

    private Event mEvent;

    public enum MouseEventType {
        ACTIVE,
        HOVER,
        NORMAL,
        CLICK
    }

    public interface Event {
        void onEvent(MouseEventType type);
    }

    public void setOnEvent(Event event) {
        this.mEvent = event;
    }

    private void doEvent(MouseEventType type) {
        if (mEvent != null) {
            mEvent.onEvent(type);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        doEvent(MouseEventType.CLICK);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        doEvent(MouseEventType.ACTIVE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        doEvent(MouseEventType.NORMAL);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        doEvent(MouseEventType.HOVER);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        doEvent(MouseEventType.NORMAL);
    }

}

