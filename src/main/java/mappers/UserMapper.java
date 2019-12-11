package mappers;

import domain.User;
import dtos.UserDTO;

public class UserMapper {
    public static UserDTO userToUserDto(final User user) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setHello(user.getId().toString());

        return userDTO;
    }
}
