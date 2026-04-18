# Java Spring Intro — Lab2Java

A hands-on introductory Spring Boot project that demonstrates core Spring concepts through a simple **camera brand & model catalogue** application.

---

## Project Overview

The application manages a catalogue of camera **Brands** (e.g. Sony, Nikon) and their **Models** (e.g. Alpha A7 III, D850).  
It runs entirely in the terminal as an interactive command-line application — there is no REST API or web UI.

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Language |
| Spring Boot | 3.1.5 | Application framework |
| Spring Data JPA | (managed by Boot) | ORM / database access |
| Hibernate | (managed by Boot) | JPA implementation |
| H2 Database | (managed by Boot) | In-memory relational database |
| Lombok | (managed by Boot) | Boilerplate code reduction |
| Spring DevTools | (managed by Boot) | Developer live-reload |
| Maven | 3.x | Build & dependency management |

---

## Architecture

The project follows a classic **layered architecture**:

```
┌─────────────────────────────────┐
│  CLI (CommandLineRunner)        │  ApplicationCommand — interactive console loop
├─────────────────────────────────┤
│  Service Layer (Interface/Impl) │  BrandService / ModelService interfaces
│                                 │  BrandDefaultService / ModelDefaultService impls
├─────────────────────────────────┤
│  Repository Layer               │  BrandRepository / ModelRepository (Spring Data JPA)
├─────────────────────────────────┤
│  Entity / Domain Layer          │  Brand, Model (JPA entities), ModelDto
├─────────────────────────────────┤
│  H2 In-Memory Database          │  Auto-configured, wiped on each restart
└─────────────────────────────────┘
```

### Key Spring concepts demonstrated

- **`@SpringBootApplication`** — bootstrap and auto-configuration
- **`@Component` / `@Service` / `@Repository`** — stereotype annotations
- **`@Autowired`** (constructor injection) — dependency injection / IoC
- **`CommandLineRunner`** — run logic after context startup (interactive CLI)
- **`InitializingBean`** (`afterPropertiesSet`) — seed data on startup
- **Spring Data JPA** repositories with custom derived query methods
- **Lombok** annotations (`@Data`, `@Builder`, `@NoArgsConstructor`, etc.) to reduce boilerplate

### Domain model

```
Brand  1 ──< Model
  - uuid (UUID, PK)          - uuid (UUID, PK)
  - name                     - name
  - country                  - price (Double)
  - yearOfEst                - announceYear
  - brandValueDollars        - brand (FK → Brand)
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

### Run the application

```bash
mvn spring-boot:run
```

Maven will download all dependencies, compile the project, spin up the H2 in-memory database, seed initial data, and start the interactive CLI.

### H2 Console (optional)

While the app is running you can inspect the database at:

```
http://localhost:8080/h2-console
```

Use these credentials (from `application.properties`):

| Field | Value |
|---|---|
| JDBC URL | `jdbc:h2:mem:Lab2Java` |
| Username | `admin` |
| Password | `password` |

---

## Using the CLI

After startup the following commands are available at the prompt:

| Command | Description |
|---|---|
| `get_brands` | List all brands |
| `get_models` | List all models across all brands |
| `add_model` | Add a new model to an existing brand (interactive prompts) |
| `delete_model` | Delete a model by brand name + model name |
| `quit` | Exit the application |

### Example session

```
Available commands:
get_brands - lists all brands
get_models - lists all models from all brands
delete_model
add_model - lets create new model under the existing brand
quit - to quit the app

> get_brands
Brand(uuid=..., name=Nikon, yearOfEst=1917, country=Japan, brandValueDollars=3.45E9)
Brand(uuid=..., name=Sony,  yearOfEst=1946, country=Japan, brandValueDollars=1.08E10)

> add_model
please provide brand name
Sony
please provide name:
Alpha A1
please provide price [9999,99]:
6499.99
please provide year:
2021
```

### Pre-seeded data

On every start the application automatically loads:

**Sony** — Alpha A7 III · Cyber-shot RX100 VII · Alpha A6600  
**Nikon** — D800 · D850 · Z6

---

## Project Structure

```
src/main/java/com/example/Lab2Java/
├── Lab2JavaApplication.java      # Entry point
├── InitializeData.java           # Seed data (InitializingBean)
├── Cmd/
│   └── ApplicationCommand.java  # Interactive CLI (CommandLineRunner)
├── Entity/
│   ├── Brand.java                # JPA entity
│   ├── Model.java                # JPA entity
│   └── ModelDto.java             # Data transfer object
├── Repository/
│   ├── BrandRepository.java      # Spring Data JPA repository
│   └── ModelRepository.java      # Spring Data JPA repository
└── Service/
    ├── Api/
    │   ├── BrandService.java     # Service interface
    │   └── ModelService.java     # Service interface
    └── Impl/
        ├── BrandDefaultService.java  # Service implementation
        └── ModelDefaultService.java  # Service implementation
```
