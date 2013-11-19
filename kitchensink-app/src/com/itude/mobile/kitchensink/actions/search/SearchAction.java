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
package com.itude.mobile.kitchensink.actions.search;

import java.util.List;

import com.itude.mobile.mobbl2.client.core.actions.MBSearchAction;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;
import com.itude.mobile.mobbl2.client.core.model.MBElement;
import com.itude.mobile.mobbl2.client.core.services.MBDataManagerService;

public class SearchAction extends MBSearchAction
{
  private static final String[] CHILDREN_OF_PLANT_ELEMENT = new String[]{"COMMON", "BOTANICAL", "ZONE", "LIGHT", "PRICE", "AVAILABILITY"};

  @Override
  protected MBDocument executeSearch()
  {
    String query = getQuery();

    MBDocument dataSource = MBDataManagerService.getInstance().loadDocument("CATALOG");

    MBDocument searchResults = dataSource.clone();
    searchResults.deleteAllChildElements();

    List<MBElement> plantElements = dataSource.getValueForPath("/PLANT");

    for (MBElement plantElement : plantElements)
    {
      for (String childOfPlantElement : CHILDREN_OF_PLANT_ELEMENT)
      {
        String value = plantElement.getValueForPath("/" + childOfPlantElement + "[0]/@text()");
        if (value.contains(query))
        {
          searchResults.addElement(plantElement.clone());

          // process next plant element
          break; // inner for-loop
        }
      }
    }

    return searchResults;
  }

}
