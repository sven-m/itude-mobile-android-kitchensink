package com.itude.mobile.kitchensink.view.binding;

import android.view.View;
import android.widget.TextView;

import com.itude.mobile.mobbl.core.view.MBField;

public class EditTextBinder extends BaseViewBinder
{
  private final int id;

  protected EditTextBinder(int id)
  {
    this.id = id;
  }

  public static EditTextBinder getInstance(int id)
  {
    return new EditTextBinder(id);
  }

  @Override
  protected View bindSpecificView(BuildState state)
  {

    // this will go horribly wrong in a listview.. :')
    TextView text = (TextView) state.parent.findViewById(id);

    text.setText((CharSequence) state.document.getValueForPath(state.component.getAbsoluteDataPath()));
    text.addTextChangedListener((MBField) state.component);

    return text;

  }

}