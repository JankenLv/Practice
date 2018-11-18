package org.lvjing.Factory;

import org.lvjing.Component.HP;
import org.lvjing.Component.Hair;
import org.lvjing.PlantImpl.IceShooter;
import org.lvjing.Resource.HairConf;

public class IceShooterFactory implements RoleFactory{

    public IceShooter createRole(int coordinate) {
        Hair hair = new Hair();
        hair.setHairColor(HairConf.HairColor.golden);
        hair.setHairstyle(HairConf.HairStyle.straight);
        HP hp = new HP();
        hp.setHP(300);

        IceShooter role = new IceShooter();
        role.setHair(hair);
        role.setHp(hp);

        return role;
    }

}
