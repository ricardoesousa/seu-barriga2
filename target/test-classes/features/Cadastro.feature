# language: pt
# charset: UTF-8

Funcionalidade: Cadastro

  Cenario: CT001 - Cadastro - Criar novo usuário com sucesso

    Dado eu tenha acessado a aplicação e esteja na página de cadastro de novo usuário
    Quando eu criar um novo usuário com dados válidos
    Entao eu devo ver uma mensagem indicando que o usuário foi criado com sucesso

  Cenario: CT002 - Cadastro - Criar novo usuário com email em formato inválido

    Dado eu tenha acessado a aplicação e esteja na página de cadastro de novo usuário
    Quando eu criar um novo usuário com email inválido
    Entao eu devo ver uma mensagem indicando que o o email está no formato inválido











