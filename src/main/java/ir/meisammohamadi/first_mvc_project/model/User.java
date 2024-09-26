package ir.meisammohamadi.first_mvc_project.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
}
