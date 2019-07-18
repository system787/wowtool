package system787.wowtool.data.cache;

import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;


@Singleton
public class JsonObjectMapper {

    private Gson gson = new Gson();

    public JsonObjectMapper() {}


    public String serialize(Object obj, Class classOfObject) {
        return gson.toJson(obj, classOfObject);
    }

    public <T> T deserialize(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
