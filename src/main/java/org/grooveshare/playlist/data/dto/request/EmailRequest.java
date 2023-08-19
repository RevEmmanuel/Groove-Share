package org.grooveshare.playlist.data.dto.request;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    private MailInfo sender;
    private List<MailInfo> to = new ArrayList<>();
    private String subject;
    private String htmlContent;

}


