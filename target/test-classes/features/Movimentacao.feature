# language: pt
# charset: UTF-8

Funcionalidade: Movimentação

  Cenario: CT001 - Movimentação - Criar movimentação com sucesso

    Dado eu esteja logado e tenha acessado a página de movimentação
    Quando eu criar a movimentação com dados válidos
    Entao eu devo ver uma mensagem indicando que a movimentação foi criada com sucesso

  Cenario: CT001 - Movimentação - Criar movimentação com data posterior à atual

    Dado eu esteja logado e tenha acessado a página de movimentação
    Quando eu criar a movimentação com data posterior à atual
    Entao eu devo ver uma mensagem indicando que a data está fora dos parâmetros











