package dw.gameshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("http://localhost:5173")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // /topic, /user 를 브로커의 목적지로 설정합니다. (채널 주제 설정)
        registry.enableSimpleBroker("/topic", "/user");
        // 클라이언트에서 /user 로 시작하는 목적지를 구독하면, 이를 내부적으로 처리할 수 있도록 함. (개인에게 보내는 채팅에 사용)
        registry.setUserDestinationPrefix("/user");
        // 클라이언트가 보내는 메시지는 /app 으로 시작해야 함.
        registry.setApplicationDestinationPrefixes("/app");
    }
}
