package com.itude.mobile.kitchensink.services;

import org.apache.http.client.methods.HttpUriRequest;

import com.itude.mobile.mobbl2.client.core.model.MBDocumentFactory;
import com.itude.mobile.mobbl2.client.core.services.datamanager.handlers.MBRESTServiceDataHandler;

public class OAuthRestServiceDataHandler extends MBRESTServiceDataHandler
{

  public OAuthRestServiceDataHandler()
  {
    setDocumentFactoryType(MBDocumentFactory.PARSER_XML);
  }

  @Override
  protected void setupHttpUriRequestHeader(HttpUriRequest httpUriRequest)
  {
    super.setupHttpUriRequestHeader(httpUriRequest);

    httpUriRequest.addHeader("Authorization", "Bearer 7d0a194c-3773-48be-8761-e7e353d37d4f");
  }

}
