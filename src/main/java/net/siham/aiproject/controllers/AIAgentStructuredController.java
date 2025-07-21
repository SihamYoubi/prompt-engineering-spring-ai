package net.siham.aiproject.controllers;

import net.siham.aiproject.outputs.MovieList;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIAgentStructuredController {
    private ChatClient chatClient;


    public AIAgentStructuredController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @GetMapping("/askAgent")
    public MovieList askLLM(String query) {
        String systemMessage = """
                Vous êtes un spécialiste dans le domaine du cinéma
                Réponds à la question de l'utilisateur à ce propos
                """;
        return chatClient.prompt()
                .system(systemMessage)
                .user(query)
                .call()
                .entity(MovieList.class);
    }
}
