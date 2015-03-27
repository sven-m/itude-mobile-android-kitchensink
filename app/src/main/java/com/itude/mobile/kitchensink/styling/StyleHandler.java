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
package com.itude.mobile.kitchensink.styling;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itude.mobile.mobbl.core.util.MBScreenConstants;
import com.itude.mobile.mobbl.core.view.MBField;
import com.itude.mobile.mobbl.core.view.builders.MBStyleHandler;

public class StyleHandler extends MBStyleHandler {
    @Override
    public void styleLabel(TextView view, MBField field) {
        super.styleLabel(view, field);

        if (field != null) {
            if ("style2".equals(field.getStyle())) {
                view.setBackgroundResource(android.R.color.holo_red_light);
            } else if ("style3".equals(field.getStyle())) {
                view.setBackgroundResource(android.R.color.holo_purple);
            } else {
                view.setTextColor(Color.DKGRAY);
            }
        }
    }

    @Override
    public void styleListPanel(LinearLayout view, String style, boolean notDirectChildOfSection) {
        super.styleListPanel(view, style, notDirectChildOfSection);

        if ("style1".equals(style)) view.setBackgroundResource(android.R.color.white);
    }

    @Override
    public void styleSectionHeaderText(TextView title) {
        super.styleSectionHeaderText(title);
        title.setTextColor(Color.BLUE);
        title.setMinimumHeight(MBScreenConstants.FIFTY);
    }

    @Override
    public void stylePageHeaderTitle(TextView view) {
        super.stylePageHeaderTitle(view);
        view.setTextColor(Color.BLACK);
    }

    @Override
    public void styleClickableRow(RelativeLayout view, String style) {
        super.styleClickableRow(view, style);
        view.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void styleSubLabel(TextView view) {
        super.styleSubLabel(view);
        view.setTextColor(Color.DKGRAY);
    }
}
