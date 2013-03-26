package com.itude.mobile.kitchensink.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.os.Bundle;

import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;
import com.itude.mobile.mobbl2.client.core.model.MBElement;

public class OrderedListViewController extends MBBasicViewController
{

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    MBDocument doc = getPage().getDocument();
    List<MBElement> plants = doc.getElementsWithName("PLANT");
    Collections.sort(plants, new Comparator<MBElement>()
    {

      @Override
      public int compare(MBElement lhs, MBElement rhs)
      {
        String val1 = lhs.getValueForPath("COMMON[0]/@text()");
        String val2 = rhs.getValueForPath("COMMON[0]/@text()");
        return val1.compareTo(val2);
      }
    });
  }

}
