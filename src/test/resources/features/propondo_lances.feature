# language: pt

Funcionalidade: Propondo Lance

  Cenario: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe um lance
    Entao o lance é aceito

  Cenario: Propondo varios lances validos
    Dado um lance de 10.0 reais do usuario "fulano"
    E um lance de 15.0 reais do usuario "beltrano"
    Quando propoe varios lances
    Entao os lances são aceitos