package org.innovibe.talkhub.model.vo;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostLike {
    private int id;
    private String userId;
    private int postId;
    private Date createAt;
}
