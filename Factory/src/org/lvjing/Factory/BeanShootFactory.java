package org.lvjing.Factory;

import org.lvjing.Component.HP;
import org.lvjing.Component.Hair;
import org.lvjing.PlantImpl.BeanShooter;
import org.lvjing.Resource.HairConf;


public class BeanShootFactory implements RoleFactory{

    public BeanShooter createRole(int coordinate) {
        Hair hair = new Hair();
        hair.setHairColor(HairConf.HairColor.golden);
        hair.setHairstyle(HairConf.HairStyle.pony_tail);
        HP hp = new HP();
        hp.setHP(500);

        BeanShooter role = new BeanShooter();
        role.setHair(hair);
        role.setHp(hp);

        return role;
    }

}
