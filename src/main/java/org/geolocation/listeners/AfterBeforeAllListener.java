package org.geolocation.listeners;

import org.geolocation.data.collectors.QueryDataCollector;
import org.testng.IExecutionListener;

public class AfterBeforeAllListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        QueryDataCollector.getInstance();
    }
}
