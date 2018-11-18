package org.lvjing.Start;

import org.lvjing.Base.Role;
import org.lvjing.Function.GeneralFunction;
import org.lvjing.PlantImpl.BeanShooter;
import org.lvjing.Resource.RoleName;
import org.lvjing.Zombie.Zombie;
import org.lvjing.ZombieImpl.BucketZombie;

public class StartGame {

    public static void main(String[] args) throws Exception {
        /*BucketZombie bucketZombie = new BucketZombie();
        bucketZombie.place(5);
        bucketZombie.fight();

        BeanShooter beanShooter = new BeanShooter();
        beanShooter.place(5);
        beanShooter.fight();*/

        /*BeanShooter beanShoot = (BeanShooter) GeneralFunction.put(RoleName.BeanShooter, 2);
        BucketZombie bucketZombie = (BucketZombie) GeneralFunction.put(RoleName.BucketZombie, 1);
        bucketZombie.fight();

        beanShoot.fight();
        bucketZombie.die();*/

        /*Role role = GeneralFunction.put(RoleName.BucketZombie, 1);
        System.out.println(role);*/

        Zombie zombie = new BucketZombie();
//        zombie.place();
        Role role = new BucketZombie();
//        role.die();

    }

}
