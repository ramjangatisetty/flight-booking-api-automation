package models;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
	private String name;
	private String email;
	private String password;
	private String phone;
	private String role;
}
