package geolocation;

import java.util.List;
import java.util.stream.IntStream;

public class BaseDataProvider {

    protected static <T> Object[][] getCollectionForDataProvider(List<T> items) {
        Object[][] objItems = new Object[items.size()][1];
        IntStream.range(0, items.size()).forEach(i -> objItems[i][0] = items.get(i));

        return objItems;
    }
}
