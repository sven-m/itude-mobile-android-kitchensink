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
          searchResults.addElement(plantElement);

          // process next plant element
          break; // inner for-loop
        }
      }
    }

    return searchResults;
  }

}
