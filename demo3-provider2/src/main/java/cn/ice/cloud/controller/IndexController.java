package cn.ice.cloud.controller;

import cn.ice.cloud.dto.UserDto;
import cn.ice.cloud.entity.User;
import cn.ice.cloud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Api(value = "UserEndpoint", tags = "Api refers to user management")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(
            value = "Get pageable data of user",
            notes = "Get pageable data of user",
            httpMethod = "GET",
            tags = "Api refers to user management"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "page",
                    value = "Which page, from 0, default 0",
                    dataType = "int",
                    paramType = "query"
            ),
            @ApiImplicitParam(
                    name = "size",
                    value = "Page size, default 20",
                    dataType = "int",
                    paramType = "query"
            ),
            @ApiImplicitParam(
                    name = "sort",
                    value = "Sort, format: property, property(, ASC|DESC)",
                    dataType = "String",
                    paramType = "query"
            )
    })
    public List<UserDto> getAllUsers(Pageable pageable){
        Page<User> page = userService.findAllUsers(pageable);
        if(null != page){
            return page.getContent().stream().map((user) -> {
                return new UserDto(user);
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(
            value = "Get detail of user",
            notes = "Get detail of user",
            httpMethod = "GET",
            tags = "Api refers to user management"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "id of user",
                    dataType = "int",
                    paramType = "path"
            )
    })
    @ResponseBody
    public UserDto detail(@PathVariable Long id) {
        User user = userService.load(id);
        return null != user ? new UserDto(user) : null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ApiOperation(
            value = "Update user information",
            notes = "Update user information",
            httpMethod = "POST",
            tags = "Api refers to user management"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "id of user",
                    dataType = "int",
                    paramType = "path"
            ),
            @ApiImplicitParam(
                    name = "userDto",
                    value = "user detail",
                    dataType = "UserDto",
                    paramType = "body"
            )
    })
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        User user = userService.save(userDto);
        return null != user ? new UserDto(user) : null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(
            value = "Delete user",
            notes = "Delete user",
            httpMethod = "DELETE",
            tags = "Api refers to user management"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "user id for deleting",
                    dataType = "int",
                    paramType = "path"
            )
    })
    public boolean delete(@PathVariable Long id){
        userService.delete(id);
        return true;
    }

    @RequestMapping(value = "/test")
    public String testApi(){
        return "TestApi";
    }
}
