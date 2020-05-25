package hooks;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public interface DefaultProperties {

    Faker faker = new Faker(new Locale("pt-BR"));
    LocalDate AGORA = LocalDate.now();
    DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    int TIME_OUT = 15;
    String URL_BASE = "http://seubarriga.wcaquino.me/login";
    String NOME = faker.name().fullName();
    String EMAIL = faker.internet().emailAddress();
    String EMAIL_FORMATO_INVALIDO = faker.name().firstName();
    String SENHA = faker.internet().password();
    String SENHA_ERRADA = faker.internet().password();
    String CONTA = faker.team().name();
    String CONTA_VAZIA = "";
    String VALOR = faker.number().randomNumber() + "." + faker.number().digits(2);
    String DESCRICAO = faker.dragonBall().character();
    String INTERESSADO = faker.harryPotter().character();
    String MSG_CADASTRO_SUCESSO = "Usuário inserido com sucesso";
    String MSG_CONTA_SUCESSO = "Conta adicionada com sucesso!";
    String MSG_BEM_VINDO = "Bem vindo, " + NOME + "!";
    String MSG_MOVIMENTACAO_SUCESSO = "Movimentação adicionada com sucesso!";
    String MSG_MOVIMENTACAO_DATA_MENOR = "Data da Movimentação deve ser menor ou igual à data atual";
    String DESPESA = "Despesa";
    String PAGO = "pago";
    String HOJE = AGORA.format(FORMATO);
    String ONTEM = AGORA.minus(1,DAYS).format(FORMATO);
    String AMANHA = AGORA.plus(1,DAYS).format(FORMATO);

}
