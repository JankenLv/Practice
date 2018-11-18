package org.lvjing.Factory;

import org.lvjing.Base.Role;
import org.lvjing.PlantImpl.WallNut;
import org.lvjing.Resource.RoleName;

public class FactoryBuilder{

    public Role buildRole(String roleName, int coordinate) throws Exception {
        if (RoleName.BeanShooter.equals(roleName)) {
            BeanShootFactory beanShootFactory = new BeanShootFactory();
            return beanShootFactory.createRole(coordinate);
        } else if (RoleName.IceShooter.equals(roleName)) {
            IceShooterFactory iceShooterFactory = new IceShooterFactory();
            return iceShooterFactory.createRole(coordinate);
        } else if (RoleName.WallNut.equals(roleName)) {
            WallNut wallNut = new WallNut();
            return wallNut;
        } else if (RoleName.BucketZombie.equals(roleName)) {
            BucketZombieFactory bucketZombieFactory = new BucketZombieFactory();
            return bucketZombieFactory.createRole(coordinate);
        } else {
            throw new Exception("创建工厂类失败。");
        }
    }

}
