package org.grooveshare.playlist.data.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MailInfo {

    private String name;
    private String email;

}

