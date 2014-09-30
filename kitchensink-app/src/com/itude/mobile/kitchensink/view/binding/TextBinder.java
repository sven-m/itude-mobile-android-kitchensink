package com.itude.mobile.kitchensink.view.binding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.itude.mobile.mobbl.core.view.MBField;

public class TextBinder extends BaseViewBinder
{
  private final int id;

  protected TextBinder(int id)
  {
    this.id = id;
  }

  public static TextBinder getInstance(int id)
  {
    return new TextBinder(id);
  }

  @Override
  protected View bindSpecificView(BuildState state)
  {
    TextView text = (TextView) state.parent.findViewById(id);

    if (text != null)
    {
      text.setText((CharSequence) state.document.getValueForPath(state.component.getAbsoluteDataPath()));
      if (text instanceof EditText) text.addTextChangedListener((MBField) state.component);
    }

    return text;

  }

}