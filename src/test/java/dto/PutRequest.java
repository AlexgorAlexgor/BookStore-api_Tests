package dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PutRequest {

    private String userId ;
    private String isbn ;
  //  private String userName;
 //   private String password;
}
