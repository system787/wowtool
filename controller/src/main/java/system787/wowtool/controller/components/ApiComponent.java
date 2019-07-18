package system787.wowtool.controller.components;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface ApiComponent {

    // Default use if no header requirement specified
    <T> T apiGetData(final String path,
                     final Map<String, String> params,
                     Class<T> classOfT) throws IOException, URISyntaxException;

    // Use if header requirement specified
    <T> T apiGetData(final String path,
                     final Map<String, String> params,
                     Class<T> classOfT,
                     final Boolean headerRequired) throws IOException, URISyntaxException;
}
