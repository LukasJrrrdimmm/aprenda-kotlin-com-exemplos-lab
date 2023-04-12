# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**

# Resposta:
Arquivo de resposta: Resposta/resposta.kt

**Atualizações em relação ao arquivo desafio.kt:**
 - Desenvolvimento das classes Usuario, Conteudo_Educadional e Formação
 - Criação e Desenvolvimento da interface FormatNível, implementada pelas classes Usuario e Conteudo_Educacional para tratar a manipulação de dados (inteiros e Strings) utilizando a enumeração
 - Modificação na enumeração, substiruição do atributo DIFICIL por ADVANCED e inserção do atributo EXTREME
 - Desenvolvimento da classe Formação para a realização e o cancelamento de matrículas através de operações envolvendo a lista de usuários.
 - Criação de uma função teste() para melhor aproveitamento da função main, onde tal função será responsável para testar a lógica do programa.