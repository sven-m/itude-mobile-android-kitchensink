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

import android.view.View;

import com.itude.mobile.mobbl.core.view.MBField;
import com.itude.mobile.mobbl.core.view.builders.MBFieldViewBuilder;
import com.itude.mobile.mobbl.core.view.builders.MBViewBuilder;

// fields of this type aren't added to the view; they only function as markers to be picked up by the ListViewBuilder
public class SectionMarkerFieldViewBuilder extends MBViewBuilder implements MBFieldViewBuilder.Builder {
    public static final String TYPE = "SECTION-MARKER";

    @Override
    public View buildField(MBField field) {
        return null;
    }

}
