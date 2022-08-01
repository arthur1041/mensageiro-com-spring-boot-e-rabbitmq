package br.com.artcruz.mensageiro;

import br.com.artcruz.mensageiro.mensageiro.UsuarioMensagemConfig;
import br.com.artcruz.mensageiro.mensageiro.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MensageiroApplicationTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void produzirMensagem() {
        var usuario = new Usuario("Vitor da Silva", "2242-33441", "vitor@email.com.br");
        rabbitTemplate.convertAndSend(UsuarioMensagemConfig.NOME_EXCHANGE, UsuarioMensagemConfig.ROUTING_KEY,
                usuario);
    }

}
