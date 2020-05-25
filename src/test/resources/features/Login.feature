# language: pt
# charset: UTF-8

Funcionalidade: Login

  Cenario: CT001 - Login - Efetuar login com sucesso

    Dado eu tenha acessado a aplicação e esteja na página de login
    Quando eu logar no sistema com dados válidos
    Entao eu devo acessar a home e ver uma mensagem com o nome de usuário

  Cenario: CT002 - Login - Efetuar login com senha inválida

    Dado eu tenha acessado a aplicação e esteja na página de login
    Quando eu logar no sistema com senha inválida
    Entao eu devo ver uma mensagem indicando que houve problema no login











