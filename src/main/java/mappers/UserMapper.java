package mappers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import domain.User;
import dtos.UserDTO;

public class UserMapper {

    public static UserDTO userToUserDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setUserType(user.getClass().getSimpleName());

        return userDTO;
    }

    public static String userDtoToJson(UserDTO userDTO){
        String json;
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            json = ow.writeValueAsString(userDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            json = e.getMessage();
        }
        return json;
    }
}
