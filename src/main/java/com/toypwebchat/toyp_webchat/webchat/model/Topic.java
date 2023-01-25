package com.toypwebchat.toyp_webchat.webchat.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private String topicName;

    private String topicId;

    private boolean topicInternal = false;
}
