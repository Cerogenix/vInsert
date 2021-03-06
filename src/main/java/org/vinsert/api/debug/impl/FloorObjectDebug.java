package org.vinsert.api.debug.impl;

import org.vinsert.api.debug.AbstractDebug;
import org.vinsert.api.event.EventHandler;
import org.vinsert.api.event.PaintEvent;
import org.vinsert.api.wrappers.GameObject;
import org.vinsert.core.Session;

import java.awt.*;

/**
 *
 */
public final class FloorObjectDebug extends AbstractDebug {

    public FloorObjectDebug(Session session) {
        super(session);
    }

    @EventHandler
    public void onPaint(PaintEvent event) {
        Graphics g = event.getGraphics();
        g.setColor(Color.YELLOW);
        if (isLoggedIn()) {
            for (GameObject object : objects.find().distance(10).type(GameObject.GameObjectType.FLOOR).asList()) {
                Point pos = object.getBasePoint();
                g.drawString(String.valueOf(object.getId()), pos.x, pos.y);
            }
        }
    }

    @Override
    public String getName() {
        return "Objects/Floor Objects";
    }

    @Override
    public String getShortcode() {
        return "floor";
    }
}
