/*
 * (C) Copyright Itude Mobile B.V., The Netherlands
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itude.mobile.mobbl.core.controller.MBOutcome;
import com.itude.mobile.mobbl.core.controller.MBViewManager;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl.core.view.MBOutcomeListenerProtocol;
import com.itude.mobile.mobbl.core.view.MBValueChangeListenerProtocol;

public class CustomViewLogic extends MBBasicViewController implements MBValueChangeListenerProtocol, MBOutcomeListenerProtocol {

    private static final String GENDER_PATH = "/Form[0]/@gender";
    private static final String COMMENT_PATH = "/Form[0]/@comment";
    private static final String CHECKBOX_PATH = "/Form[0]/@checkbox";

    @Override
    protected ViewGroup buildInitialView(LayoutInflater inflater) {
        ViewGroup view = super.buildInitialView(inflater);

        getPage().registerValueChangeListener(this, GENDER_PATH);
        getPage().registerValueChangeListener(this, CHECKBOX_PATH);
        registerOutcomeListener(this);

        return view;
    }

    @Override
    public void outcomeProduced(MBOutcome outcome) {
        Toast.makeText(MBViewManager.getInstance(), "Intercepted outcome " + outcome.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean valueWillChange(String value, String originalValue, String path) {
        return true;
    }

    @Override
    public void valueChanged(String value, String originalValue, String path) {
        if (path.equals(GENDER_PATH)) {
            if (value.equals("male"))

                getPage().getDocument().setValue("Watch My Little Pony", COMMENT_PATH);
            else getPage().getDocument().setValue("Watch Justin Bieber", COMMENT_PATH);
        }

        rebuildView(true);

    }

    @Override
    public void afterOutcomeHandled(MBOutcome outcome) {
        Toast.makeText(MBViewManager.getInstance(), "Processed outcome " + outcome.getOutcomeName(), Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean shouldHandleOutcome(MBOutcome outcome) {
        return true;
    }

}
