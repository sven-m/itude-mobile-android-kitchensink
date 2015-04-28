package com.itude.mobile.kitchensink.actions;

import com.itude.mobile.mobbl.core.MBException;
import com.itude.mobile.mobbl.core.controller.MBAction;
import com.itude.mobile.mobbl.core.controller.MBOutcome;
import com.itude.mobile.mobbl.core.model.MBDocument;

public class DelayAction implements MBAction {

    @Override
    public MBOutcome execute(MBDocument document, String path) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new MBException("Meh", e);
        }
        return null;
    }

}
