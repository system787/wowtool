package system787.wowtool.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import system787.wowtool.data.entity.TokenResponseEntity;

import java.lang.reflect.Type;
import java.util.List;

public class TokenResponseEntityJsonMapper {
    private final Gson mGson;

    public TokenResponseEntityJsonMapper() {
        this.mGson = new Gson();
    }

    public TokenResponseEntity map(String json) throws JsonSyntaxException {
        return this.mGson.fromJson(json, TokenResponseEntity.class);
    }

    public List<TokenResponseEntity> mapAll(String json) throws JsonSyntaxException {
        final Type listType =
                new TypeToken<List<TokenResponseEntity>>() {
                }.getType();

        return this.mGson.fromJson(json, listType);
    }
}
