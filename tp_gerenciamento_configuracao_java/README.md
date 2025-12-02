# Java TaskManager (Spring Boot)

Exemplo adaptado para o trabalho de Gerência de Configuração.

## Como usar

- Rodar testes:

```powershell
mvn test
```

- Empacotar artefato (JAR):

```powershell
mvn package
```

- Rodar a aplicação localmente:

```powershell
mvn spring-boot:run
# ou
java -jar target/*.jar
```

- Rodar em Docker (com docker-compose):

```powershell
docker-compose up --build
```

## CI

O workflow de CI está em `.github/workflows/ci.yml` e dispara automaticamente em `push` para as branches `main` e `master`.
Atualmente ele executa os testes e empacota o artefato (`mvn package`) e também constrói a imagem Docker no runner.

Se desejar que o CI publique a imagem em um registry (Docker Hub ou GitHub Container Registry), é preciso adicionar secrets no repositório e ajustar o workflow para efetuar o `push`.

## Observações

- O repositório contém testes unitários, de integração e de aceitação. Os testes foram verificados localmente.
- Foi removido um stub de teste que conflitou com a anotação `@LocalServerPort` do Spring Boot.

---

CI trigger: forced run on 2025-12-02 to validate workflow changes.
