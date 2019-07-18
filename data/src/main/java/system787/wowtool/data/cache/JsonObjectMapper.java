package system787.wowtool.data.cache;

import com.google.gson.Gson;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JsonObjectMapper {

    private final Gson gson = new Gson();

    @Inject
    JsonObjectMapper() {}

    public String serialize(Object obj, Class classOfObject) {
        return gson.toJson(obj, classOfObject);
    }

    public <T> T deserialize(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
