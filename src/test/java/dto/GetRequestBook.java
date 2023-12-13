package dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRequestBook {
   // private String UserId ;
    private String isbn ;
    private String userId ;

    // private String full_name;
    //  private String email;
   private String userName;
    private String password;
    //  private boolean generate_magic_link;
}
