package system787.wowtool.data.entity;

import com.google.gson.annotations.SerializedName;

public class UserEntity {

    @SerializedName("accountId")
    private String mAccountId;

    @SerializedName("battleTag")
    private String mBattleTag;

    private WowProfileEntity mWowProfileEntity;

    public UserEntity() {
    }

    public UserEntity(String battleTag) {
        mBattleTag = battleTag;
    }

    public UserEntity(String accountId, String battleTag) {
        mAccountId = accountId;
        mBattleTag = battleTag;
    }

    public UserEntity(String accountId, String battleTag, WowProfileEntity wowProfileEntity) {
        mAccountId = accountId;
        mBattleTag = battleTag;
        mWowProfileEntity = wowProfileEntity;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public void setAccountId(String accountId) {
        mAccountId = accountId;
    }

    public String getBattleTag() {
        return mBattleTag;
    }

    public void setBattleTag(String battleTag) {
        mBattleTag = battleTag;
    }

    public WowProfileEntity getWowProfileEntity() {
        return mWowProfileEntity;
    }

    public void setWowProfileEntity(WowProfileEntity wowProfileEntity) {
        mWowProfileEntity = wowProfileEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "mAccountId='" + mAccountId + '\'' +
                ", mBattleTag='" + mBattleTag + '\'' +
                ", mWowProfileEntity=" + mWowProfileEntity +
                '}';
    }
}
