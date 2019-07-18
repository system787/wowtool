package system787.wowtool.data.net.config;

import com.google.gson.Gson;
import java.io.*;

public class AppConfigMapper {

    public static AppConfig mapAppConfig() {
        Gson gson = new Gson();

        try {
            InputStream is = AppConfigMapper.class.getResourceAsStream("/appconfig.json");
            Reader reader = new InputStreamReader(is);

            AppConfig appConfig = gson.fromJson(reader, AppConfig.class);

            reader.close();

            return appConfig;

        } catch (IOException e) {
            // TODO: exception handling
            e.printStackTrace();
        }

        return null;
    }
}
