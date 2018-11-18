package org.lvjing.Function;

import org.lvjing.Base.Role;
import org.lvjing.Factory.FactoryBuilder;

public class GeneralFunction {

    public static Role put(String roleName, int coordinate) throws Exception {

        FactoryBuilder factoryBuilder = new FactoryBuilder();
        return factoryBuilder.buildRole(roleName,coordinate);

        /*Role role = null;

        if (RoleName.BeanShooter.equals(roleName)) {
            *//*role = new BeanShooter();
            ((BeanShooter) role).place(coordinate);
            Hair hair = new Hair();
            hair.setHairColor(HairConf.HairColor.black);
            hair.setHairstyle(HairConf.HairStyle.wave);*//*

            role = BeanShootFactory.createBeanShoot(coordinate);
        } else if (RoleName.IceShooter.equals(roleName)) {
            role = new IceShooter();
            ((IceShooter) role).place(coordinate);
        } else if (RoleName.WallNut.equals(roleName)) {
            role = new WallNut();
            ((WallNut) role).place(coordinate);
        } else if (RoleName.BucketZombie.equals(roleName)) {
            *//*Hair hair = new Hair();
            hair.setHairColor(HairConf.HairColor.black);
            hair.setHairstyle(HairConf.HairStyle.wave);
            HP hp = new HP();
            hp.setHP(200);
            role = new BucketZombie();
            ((BucketZombie) role).place(coordinate);
            ((BucketZombie) role).setHair(hair);
            ((BucketZombie) role).setHp(hp);*//*

            role = BucketZombieFactory.createBucketZombie(coordinate);
        }*/

//        return role;
    }

}
