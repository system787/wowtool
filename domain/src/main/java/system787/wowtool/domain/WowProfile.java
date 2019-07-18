package system787.wowtool.domain;

import java.util.List;

public class WowProfile {

    private List<Character> mCharacterList;

    public WowProfile() {
    }

    public WowProfile(List<Character> characterList) {
        mCharacterList = characterList;
    }

    public List<Character> getCharacterList() {
        return mCharacterList;
    }

    public void setCharacterList(List<Character> characterList) {
        mCharacterList = characterList;
    }

    public static class Character {
        public Character() {
        }

        public Character(String name, String realm,
                         String battlegroup, short charClass,
                         short race, byte gender,
                         short level, int achievements,
                         String thumbnail, long lastModified) {
            this.name = name;
            this.realm = realm;
            this.battlegroup = battlegroup;
            this.charClass = charClass;
            this.race = race;
            this.gender = gender;
            this.level = level;
            this.achievementPoints = achievements;
            this.thumbnail = thumbnail;
            this.lastModified = lastModified;
        }

        private String name;
        private String realm;
        private String battlegroup;
        private short charClass;
        private short race;
        private byte gender;
        private short level;
        private int achievementPoints;
        private String thumbnail;
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

        public short getCharClass() {
            return charClass;
        }

        public void setCharClass(short charClass) {
            this.charClass = charClass;
        }

        public short getRace() {
            return race;
        }

        public void setRace(short race) {
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

        public int getAchievementPoints() {
            return achievementPoints;
        }

        public void setAchievementPoints(int achievements) {
            this.achievementPoints = achievements;
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
