package com.myntra.service;


import com.myntra.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userdto);

    List<UserDto> getAll();

    UserDto update(UserDto userDto);

    Boolean delete(Long id);

    UserDto getById(Long id);

    UserDto assignCartToPerson(Long cartid, Long userid);

    UserDto assignAddressToUser(Long addressId, Long UserId);

}
