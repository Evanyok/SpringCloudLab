package cn.ice.cloud.service;

import cn.ice.cloud.dto.UserDto;
import cn.ice.cloud.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> findAllUsers(Pageable pageable);

    User load(Long id);

    User save(UserDto userDto);

    void delete(Long id);
}
