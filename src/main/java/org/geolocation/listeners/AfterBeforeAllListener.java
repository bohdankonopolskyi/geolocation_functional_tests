package org.geolocation.listeners;

import org.geolocation.config.Config;
import org.geolocation.config.ConfigContainer;
import org.geolocation.data.collectors.QueryDataCollector;
import org.testng.IExecutionListener;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.geolocation.config.EnvVariables.*;
import static org.geolocation.helpers.AllureHelper.createAllureEnv;

public class AfterBeforeAllListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        Config c = ConfigContainer.getConfig();

        Map<String, String> allureEnvMap = new LinkedHashMap<>(Map.of(
                "App url", c.getIpApiUrl(),
                "included groups", ENV_INCLUDE_GROUPS.getVal(),
                "thread count", ENV_TREAD_COUNT.getVal(),
                "parallel by", ENV_PARALLEL.getVal()
        ));
        createAllureEnv(allureEnvMap);

        QueryDataCollector.getInstance();
    }
}
