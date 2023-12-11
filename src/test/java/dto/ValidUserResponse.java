package dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidUserResponse {
    // private String full_name;
    //  private String email;
    private String userName;
  //  private String password;
    private String UserId ;

    //  private boolean generate_magic_link;
}
