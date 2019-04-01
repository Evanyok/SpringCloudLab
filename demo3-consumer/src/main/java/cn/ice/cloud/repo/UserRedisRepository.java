package cn.ice.cloud.repo;

import cn.ice.cloud.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class UserRedisRepository {

    public static final String USER_KEY_PRE = "user:";

    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, UserDto> userDtoRedisTemplate;

    private ValueOperations<String, UserDto> operations;

    @PostConstruct
    private void init() {
        operations = userDtoRedisTemplate.opsForValue();
    }

    public void saveUser(UserDto userDto) {
        operations.set(buildKey(userDto.getId()), userDto);
    }

    public UserDto findOne(Long id) {
        String key = buildKey(id);
        if (! userDtoRedisTemplate.hasKey(key)) {
            return null;
        }
        return operations.get(key);
    }

    public void delete(Long id) {
        userDtoRedisTemplate.delete(buildKey(id));
    }

    protected String buildKey(Long id) {
        return USER_KEY_PRE + String.valueOf(id);
    }
}
