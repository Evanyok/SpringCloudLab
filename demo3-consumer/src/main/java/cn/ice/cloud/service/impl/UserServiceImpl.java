package cn.ice.cloud.service.impl;

import cn.ice.cloud.dto.UserDto;
import cn.ice.cloud.repo.UserRedisRepository;
import cn.ice.cloud.service.UserRemoteService;
import cn.ice.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRedisRepository userRedisRepository;

    @Autowired
    protected UserRemoteService userRemoteService;

    @Override
    public List<UserDto> findAll() {
        return userRemoteService.findAll();
    }

    @Override
    public UserDto load(Long id) {
        UserDto userDto = userRedisRepository.findOne(id);
        if (null != userDto) {
            return userDto;
        }

        userDto = userRemoteService.load(id);
        if (null != userDto) {
            userRedisRepository.saveUser(userDto);
        }
        return userDto;
    }
}
