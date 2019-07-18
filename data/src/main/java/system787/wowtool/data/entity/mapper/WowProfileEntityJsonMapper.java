package system787.wowtool.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import system787.wowtool.data.entity.WowProfileEntity;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

public class WowProfileEntityJsonMapper {
    private final Gson mGson;

    @Inject
    public WowProfileEntityJsonMapper() {
        this.mGson = new Gson();
    }

    public WowProfileEntity map(String json) throws JsonSyntaxException {
        return this.mGson.fromJson(json, WowProfileEntity.class);
    }

    public List<WowProfileEntity> mapAll(String json) throws JsonSyntaxException {
        final Type listType =
                new TypeToken<List<WowProfileEntity>>() {
        }.getType();

        return this.mGson.fromJson(json, listType);
    }
}
