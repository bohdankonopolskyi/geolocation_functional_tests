package org.geolocation.data.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryDataCollector {

    private static final List<String> queryList = Collections.synchronizedList(new ArrayList());
    private static final List<String> invalidQueryList = Collections.synchronizedList(new ArrayList());

    private QueryDataCollector() {
        addQueries();
        addInvalidQueries();
    }

    public static QueryDataCollector getInstance() {
        return DataHolder.INSTANCE;
    }

    public List<String> getQueryList() {
        return queryList;
    }

    public List<String> getInvalidQueryList() {
        return invalidQueryList;
    }

    private void addQueries() {
        queryList.add("0.ua.pool.ntp.org");
        queryList.add("1.ua.pool.ntp.org");
        queryList.add("2.ua.pool.ntp.org");
        queryList.add("3.ua.pool.ntp.org");
    }

    private void addInvalidQueries() {
        invalidQueryList.add("4.ua.pool.ntp.org");
    }

    private static class DataHolder {
        static final QueryDataCollector INSTANCE = new QueryDataCollector();
    }
}
