package dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRequestBooks {
    private String  isbn;// "9781449325862",
    private String  title; //: "Git Pocket Guide",
    private String  subTitle; //: "A Working Introduction",
    private String  author;//: "Richard E. Silverman";
    private String  publish_date;//: "2020-06-04T08:48:39.000Z",
    private String  publisher;//: "O'Reilly Media",
    private String  pages; //: 234,
    private String  description ;//: "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp",
    private String  website;//: private String full_name;
    //  private String email;
    //  private String userName;
    //private String password;
    //  private boolean generate_magic_link;
}
