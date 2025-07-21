package net.siham.aiproject.controllers;

import net.siham.aiproject.outputs.CinModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class MultiModalController {
    private ChatClient chatClient;

    @Value("classpath:/images/cin.jpg")
    private Resource image;

    @Value("classpath:/images/cin.jpg")
    private Resource image2;
    public MultiModalController(ChatClient.Builder chatClient){
        this.chatClient = chatClient.build();
    }

    @GetMapping("/describe")
    public CinModel describeImage(){
        return chatClient.prompt()
                .system("Donne une description de l'image fournie")
                .user(u->
                        u.text("Décrire cette image")
                                .media(MediaType.IMAGE_JPEG, image)
                ).call()
                .entity(CinModel.class);
    }

    @PostMapping(value="/askImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String askImage(@RequestParam(name = "file")MultipartFile file, String question) throws IOException {
        byte[] bytes= file.getBytes();
        return chatClient.prompt()
                .system("Reponds a la question de l'utilisateur a propos de l'image fournie")
                .user(u->
                        u.text(question)
                                .media(MediaType.IMAGE_JPEG, new ByteArrayResource(bytes))
                ).call()
                .content();
    }
}
