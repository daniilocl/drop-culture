# drop-culture
Sistema de Catálogo com Venda Assistida | Java Web MVC | Projeto Acadêmico UMC

## Sobre o projeto

Drop Culture é um projeto acadêmico da UMC para um catálogo de sneakers colecionáveis com venda assistida, mantido em repositório público para portfólio.

**Entrega:** 05/12/2026 às 23h59, horário de São Paulo (America/Sao_Paulo).

**Status:** organização e implementação planejadas. Na inspeção inicial de 22/11/2026, o repositório continha apenas este README; funcionalidades abaixo representam escopo a implementar, não recursos já concluídos.

## Documentação e acompanhamento

- [Central do projeto no Notion](https://app.notion.com/p/4204b1e9b2b781c18a74f1ff0170a7de)
- [Equipe e responsabilidades](https://app.notion.com/p/4204b1e9b2b781709cade3dfe6460254)
- [Banco de dados, UML e dicionários propostos](https://app.notion.com/p/4204b1e9b2b78132968aed538a6f6e2a)
- [GitHub Issues — tarefas técnicas](https://github.com/daniilocl/drop-culture/issues)

O Notion concentra a documentação; as Issues concentram critérios de aceite, dependências e evidências. Os links não constituem sincronização automática. O acesso ao Notion segue as permissões do workspace.

## Tecnologias e arquitetura planejadas

Java Web, JSP, Servlets, MVC, DAO, JDBC, Bootstrap e banco MySQL em ambiente XAMPP; desenvolvimento no NetBeans e execução no Apache Tomcat.

Fluxo: navegador → Servlet Controller → Model/DAO → JDBC → banco; o Controller encaminha dados para as JSPs. Regras de negócio ficam no servidor e SQL fica nos DAOs.

As versões de JDK, Tomcat, driver JDBC e a compatibilidade javax/jakarta serão registradas na tarefa de ambiente. Confirmar se a instalação XAMPP utiliza MySQL ou MariaDB.

## Escopo e dados

- CRUD de Categoria, Produto, Cliente e Vendedor.
- Registro e consulta de Pedido e ItemPedido.
- Catálogo responsivo com Bootstrap e seleção de produtos e quantidades.
- Cálculo de valores no servidor, integridade referencial e gravação transacional de pedido e itens.
- Seis entidades: **Categoria, Produto, Cliente, Vendedor, Pedido e ItemPedido**.
- Cada tabela deve conter **pelo menos 10 campos coerentes**, descritos no dicionário de dados com tipos, chaves e restrições. Os modelos do Notion são propostas a validar antes da implementação.

## Equipe

| Integrante | Responsabilidade |
| --- | --- |
| Danilo | Pedido, liderança técnica e ambiente |
| Gustavo | Categoria, UML e esquema do banco |
| Davi | Produto, catálogo e frontend |
| Nathanael | Cliente e ItemPedido, em integração com Danilo |
| Gabriel | Vendedor, documentação e evidências |

## Plano de trabalho

| Issue | Responsável | Entrega | Depende de |
| --- | --- | --- | --- |
| [#1](https://github.com/daniilocl/drop-culture/issues/1) | Gustavo | Validar UML e esquema das seis entidades | — |
| [#2](https://github.com/daniilocl/drop-culture/issues/2) | Danilo | Preparar ambiente Java Web e conexão JDBC | — |
| [#3](https://github.com/daniilocl/drop-culture/issues/3) | Gustavo | Implementar CRUD de Categoria | #1, #2 |
| [#4](https://github.com/daniilocl/drop-culture/issues/4) | Nathanael | Implementar CRUD de Cliente | #1, #2 |
| [#5](https://github.com/daniilocl/drop-culture/issues/5) | Gabriel | Implementar CRUD de Vendedor | #1, #2 |
| [#6](https://github.com/daniilocl/drop-culture/issues/6) | Davi | Implementar CRUD de Produto | #1, #2, #3 |
| [#7](https://github.com/daniilocl/drop-culture/issues/7) | Nathanael | Implementar ItemPedido e contrato de integração | #1, #2, #6 |
| [#8](https://github.com/daniilocl/drop-culture/issues/8) | Danilo | Implementar Pedido e venda assistida transacional | #4, #5, #6, #7 |
| [#9](https://github.com/daniilocl/drop-culture/issues/9) | Davi | Integrar catálogo e telas responsivas com Bootstrap | #3, #6, #4, #5, #8 |
| [#10](https://github.com/daniilocl/drop-culture/issues/10) | Gabriel | Consolidar documentação e evidências da entrega | #1, #2, #3, #4, #5, #6, #7, #8, #9 |

As labels `enhancement` e `documentation` distinguem implementação e documentação. Os responsáveis estão nos títulos e corpos; Danilo está atribuído a `daniilocl`. As contas dos demais integrantes ainda precisam ser identificadas para atribuição nativa.

As dependências estão vinculadas por número nas Issues. Ambiente e modelagem iniciam o trabalho; cadastros e itens permitem integrar Pedido; frontend e evidências concluem a entrega. A documentação pode avançar em paralelo.

### Kanban

GitHub Project Kanban ainda não criado: a integração desta sessão não oferece criação de Projects e o navegador não tem sessão autenticada. Fluxo proposto para quando disponível: **A fazer → Em andamento → Em revisão → Concluído**. Até lá, acompanhar pelas Issues abertas/fechadas e seus checklists.

## Como executar

Ainda não há código de aplicação, script de banco ou configuração de build publicados nesta etapa. O guia executável será preenchido após a tarefa de ambiente e a implementação inicial.

Sequência prevista: instalar as versões acordadas, iniciar o banco no XAMPP, importar o SQL versionado, configurar credenciais somente no ambiente local, abrir o projeto no NetBeans e executar no Tomcat. Registrar o contexto/URL real da aplicação após validação.

## Critérios gerais de conclusão

- [ ] Seis tabelas com 10+ campos cada, relacionamentos e dicionário consistentes.
- [ ] Model, DAO, Controller e JSPs integrados, respeitando MVC.
- [ ] Queries parametrizadas, validações no servidor e recursos JDBC fechados.
- [ ] CRUDs, catálogo e venda assistida validados com dados fictícios.
- [ ] Pedido e itens com commit/rollback conjunto e totais calculados no servidor.
- [ ] Evidências de sucesso e falha, UML e instruções reproduzíveis.
- [ ] PRs revisados e vinculados às Issues correspondentes.

## Colaboração e portfólio

Trabalhar em branches por tarefa e abrir Pull Requests referenciando a Issue. Revisar antes de integrar à `main`; fechar a tarefa somente quando os critérios estiverem cumpridos. Atualizar o README com funcionalidades e evidências reais conforme forem entregues.

Não versionar senhas, tokens, arquivos locais de credenciais, dumps com dados pessoais nem prints que revelem informações sensíveis. Exemplos devem usar valores fictícios e configurações sem segredos.
