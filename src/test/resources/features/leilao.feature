# language: pt

  @leilao
  Funcionalidade: Cadastrando um leilao

    Contexto:
      Dado um usuario logado

    Cenario: Um usuario logado pode cadastrar um leilão
      Quando acessa a pagina de novo leilao
      E preenche o formulario com dados validos
      Entao volta para pagina de leiloes
      E o novo leilao aparece na tabela