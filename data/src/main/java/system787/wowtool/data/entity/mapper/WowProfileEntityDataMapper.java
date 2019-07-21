package system787.wowtool.data.entity.mapper;

import system787.wowtool.data.entity.WowProfileEntity;
import system787.wowtool.domain.WowProfile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WowProfileEntityDataMapper {

    WowProfileEntityDataMapper() {}

    public WowProfile map(WowProfileEntity entity) {

        if (entity != null) {
            List<WowProfileEntity.Character> entityCharacter = entity.getCharacterList();
            List<WowProfile.Character> domainCharacterList = new ArrayList<>();

            for (WowProfileEntity.Character c : entityCharacter) {
                WowProfile.Character domainCharacter
                        = new WowProfile.Character(
                        c.getName(), c.getRealm(),
                        c.getBattlegroup(), c.getCharClass(),
                        c.getRace(), c.getGender(),
                        c.getLevel(), c.getAchievementPoints(),
                        c.getThumbnail(), c.getLastModified());

                domainCharacterList.add(domainCharacter);
            }

            return new WowProfile(domainCharacterList);
        }

        return null;
    }

    public List<WowProfile> mapAll(Collection<WowProfileEntity> entityCollection) {
        List<WowProfile> profileList = new ArrayList<>();

        for (WowProfileEntity e : entityCollection) {
            WowProfile profile = map(e);

            if (profile != null) {
                profileList.add(profile);
            }
        }

        return profileList;
    }
}
