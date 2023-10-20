package com.br.marcelo.ms.cloudmensageria.consumer;

import com.br.marcelo.ms.cloudmensageria.dto.EmailRecordDto;
import com.br.marcelo.ms.cloudmensageria.models.EmailModel;
import com.br.marcelo.ms.cloudmensageria.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }


    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto,emailModel);
        emailService.sendEmail(emailModel);

    }

}
