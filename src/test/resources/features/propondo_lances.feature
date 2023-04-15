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

  Esquema do Cenario: Propondo um lance invalido
    Dado um lance invalido de <valor> reais do usuario '<nomeUsuario>'
    Quando propoe um lance
    Entao o lance não eh aceito

    Exemplos:
      | valor| nomeUsuario |
      | 0.0  | Anderson    |
      | -1.0 | Luciana     |

  Cenario: Propondo uma sequencia de lances
    Dado dois lances
      | valor| nomeUsuario |
      | 10.0 | Anderson    |
      | 15.0 | Anderson    |
    Quando propoe varios lances
    Entao o segundo lance nao eh aceito