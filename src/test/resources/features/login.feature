# language: pt

  Funcionalidade:  Apenas usuarios cadastrados podem se logar

    Cenario: Um usuario valido consegue se logar
      Dado um usuário valido
      Quando realiza login
      Entao é redirecionado para a pagina de leilões

    Cenario: Um usuario invalido não consegue se logar
      Dado um usuário invalido
      Quando tenta se logar
      Entao continua na página de login