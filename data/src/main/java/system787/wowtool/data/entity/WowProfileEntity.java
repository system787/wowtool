package system787.wowtool.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WowProfileEntity {

    @SerializedName("characters")
    private List<Character> mCharacterList;

    static class Character {

        @SerializedName("name")
        private String name;

        @SerializedName("realm")
        private String realm;

        @SerializedName("battlegroup")
        private String battlegroup;

        @SerializedName("class")
        private String charClass;

        @SerializedName("race")
        private String race;

        @SerializedName("gender")
        private byte gender;

        @SerializedName("level")
        private short level;

        @SerializedName("achievementPoints")
        private int achievements;

        @SerializedName("thumbnail")
        private String thumbnail;

        @SerializedName("lastModified")
        private long lastModified;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRealm() {
            return realm;
        }

        public void setRealm(String realm) {
            this.realm = realm;
        }

        public String getBattlegroup() {
            return battlegroup;
        }

        public void setBattlegroup(String battlegroup) {
            this.battlegroup = battlegroup;
        }

        public String getCharClass() {
            return charClass;
        }

        public void setCharClass(String charClass) {
            this.charClass = charClass;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public byte getGender() {
            return gender;
        }

        public void setGender(byte gender) {
            this.gender = gender;
        }

        public short getLevel() {
            return level;
        }

        public void setLevel(short level) {
            this.level = level;
        }

        public int getAchievements() {
            return achievements;
        }

        public void setAchievements(int achievements) {
            this.achievements = achievements;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public long getLastModified() {
            return lastModified;
        }

        public void setLastModified(long lastModified) {
            this.lastModified = lastModified;
        }
    }
}
