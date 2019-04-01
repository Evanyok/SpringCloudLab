package cn.ice.cloud.service;

import cn.ice.cloud.dto.UserDto;
import cn.ice.cloud.service.impl.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "EUREKA-PROVIDER-SERVER", fallback = UserServiceFallback.class)
public interface UserRemoteService {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    List<UserDto> findAll();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    UserDto load(@PathVariable("id") Long id);
}
