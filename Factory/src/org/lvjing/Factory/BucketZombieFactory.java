package org.lvjing.Factory;

import org.lvjing.Base.Role;
import org.lvjing.Component.HP;
import org.lvjing.Component.Hair;
import org.lvjing.Resource.HairConf;
import org.lvjing.ZombieImpl.BucketZombie;

public class BucketZombieFactory implements RoleFactory{

    public BucketZombie createRole(int coordinate) {
        Hair hair = new Hair();
        hair.setHairColor(HairConf.HairColor.black);
        hair.setHairstyle(HairConf.HairStyle.wave);
        HP hp = new HP();
        hp.setHP(200);

        BucketZombie role = new BucketZombie();
        role.setHair(hair);
        role.setHp(hp);

        return role;
    }

}
