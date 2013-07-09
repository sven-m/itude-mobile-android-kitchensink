package com.itude.mobile.kitchensink.actions;

import android.util.Log;

import com.itude.mobile.mobbl2.client.core.controller.MBAction;
import com.itude.mobile.mobbl2.client.core.controller.MBOutcome;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;
import com.itude.mobile.mobbl2.client.core.model.MBElement;
import com.itude.mobile.mobbl2.client.core.services.MBDataManagerService;
import com.itude.mobile.mobbl2.client.core.util.Constants;

public class RestServiceAction implements MBAction
{

  @Override
  public MBOutcome execute(MBDocument document, String path)
  {
    //Retrieve checklists
    MBDocument doc = MBDataManagerService.getInstance().loadDocument("MBGenericRestRequest");
    doc.setValue("list", "Operation[0]/@name");
    doc.setValue(Constants.C_HTTP_REQUEST_METHOD_GET, "Operation[0]/@httpMethod");
    MBDocument checklists = MBDataManagerService.getInstance().loadDocument("tasks", doc);
    Log.d(Constants.APPLICATION_NAME, "checklists: " + checklists);

    //Now test the cache
    checklists = MBDataManagerService.getInstance().loadDocument("tasks", doc);

    // Retrieve one of the checklists with its tasks
    MBDocument doc2 = MBDataManagerService.getInstance().loadDocument("MBGenericRestRequest");
    doc2.setValue("51dbafb8e4b06384450bb310", "Operation[0]/@name");
    doc2.setValue(Constants.C_HTTP_REQUEST_METHOD_GET, "Operation[0]/@httpMethod");
    MBDocument tasks = MBDataManagerService.getInstance().loadDocument("task", doc2);
    Log.d(Constants.APPLICATION_NAME, "tasks: " + tasks);

    // Insert a task into a checklist
    MBDocument doc3 = MBDataManagerService.getInstance().loadDocument("MBGenericRestRequest");
    doc3.setValue("add", "Operation[0]/@name");
    doc3.setValue(Constants.C_HTTP_REQUEST_METHOD_POST, "Operation[0]/@httpMethod");
    MBElement taskName = doc3.getElementsWithName("Operation").get(0).createElement("Parameter");
    taskName.setAttributeValue("inserted from an App!!", "value");
    taskName.setAttributeValue("name", "key");

    MBElement destination = doc3.getElementsWithName("Operation").get(0).createElement("Parameter");
    destination.setAttributeValue("51dbafb8e4b06384450bb310", "value");
    destination.setAttributeValue("destination", "key");
    MBElement position = doc3.getElementsWithName("Operation").get(0).createElement("Parameter");
    position.setAttributeValue("0", "value");
    position.setAttributeValue("position", "key");
    tasks = MBDataManagerService.getInstance().loadDocument("task", doc3);
    Log.d(Constants.APPLICATION_NAME, "tasks: " + tasks);
    return null;
  }

}
