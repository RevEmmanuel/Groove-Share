package org.grooveshare.playlist.service.email;

public interface EmailService {

    void sendEmail(String to, String subject, String htmlContent);

}
