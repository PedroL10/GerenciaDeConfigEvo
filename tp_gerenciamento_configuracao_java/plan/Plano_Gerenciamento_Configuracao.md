# Plano de Gerenciamento de Configuração - Projeto TaskManager (Java, exemplo)

## 1. Identificação do Projeto
Projeto: TaskManager (exemplo) - Java / Spring Boot
Equipe: [Nomes dos alunos]
Data: [inserir data]

## 2. Objetivos
Aplicar gerenciamento de configuração, CI/CD, testes automatizados e containerização.

## 3. Itens de Configuração (IC)
- Código-fonte (src/main/java)
- Testes (src/test/java)
- POM (pom.xml)
- Scripts e Dockerfile
- Pipeline CI (.github/workflows/ci.yml)
- Documentação (plan/, slides/)

## 4. Ferramentas
- Git / GitHub
- CI: GitHub Actions (Maven)
- Build: Maven
- Container: Docker
- Testes: JUnit + Spring Test

## 5. Política de Branches
- main/master: branch estável, deploy automático a partir de CI
- develop: integração de features
- feature/*: branches de desenvolvimento

## 6. Processo de Releases
- Merges para main disparam o pipeline (mvn test)
- Se pipeline passar, gerar artefato e build da imagem Docker
- Tags de release: vX.Y.Z

## 7. Estratégia de Build e Versionamento
- SemVer para releases
- Artefatos via Maven; imagens taggeadas com SHA curto

## 8. Testes
- Unitários: JUnit (TaskServiceUnitTest)
- Integração: MockMvc
- Aceitação: SpringBootTest com TestRestTemplate

## 9. Implantação
- Docker image executando jar (porta 8080)
- docker-compose para orquestração local

## 10. Papéis
- Líder: coordena merges e entrega
- Integrador: mantém pipeline e deploy
- Testador: garante cobertura de testes

