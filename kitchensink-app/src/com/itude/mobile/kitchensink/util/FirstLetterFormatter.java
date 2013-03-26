package com.itude.mobile.kitchensink.util;

import com.itude.mobile.mobbl2.client.core.view.builders.datatypes.MBBaseDataTypeFormatter;

public class FirstLetterFormatter extends MBBaseDataTypeFormatter
{

  @Override
  protected String actuallyFormat(String value)
  {
    if (value.length() != 0) return value.substring(0, 1).toUpperCase(getLocale());
    else return value;
  }

}
