package cn.ice.cloud.repo;

import cn.ice.cloud.entity.User;

import java.util.List;


/**
 * Extent Repository
 */
public interface UserRepositoryEx {

    List<User> findTopUser(int max);
}
