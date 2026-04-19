# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository Overview

This is a Spring Boot / JPA educational course project for DHBW Ravensburg. It contains 3 progressive exercises (Aufgaben) building a "MyMovieDatabase" application, each with a problem version and a solution version:

- `Aufgabe_1` / `Aufgabe_1_Lösung` — Spring DI & component architecture (covered in `1-Spring-Grundlagen.pdf`)
- `Aufgabe_2` / `Aufgabe_2_Lösung` — JPA entity mapping & Spring Data repositories (covered in `2-JPA-Grundlagen.pdf`)
- `Aufgabe_3` / `Aufgabe_3_Lösung` — Advanced JPA: relationships, cascades, transactional services, complex JPQL

## Build & Run Commands

Each exercise is an independent Gradle project. Run from within the exercise directory:

```bash
cd Aufgabe_X          # or Aufgabe_X_Lösung
./gradlew build       # Compile and run tests
./gradlew bootRun     # Run the app (executes ManualTestBean on startup)
./gradlew test        # Run JUnit tests only
```

**Stack:** Java 21 (toolchain), Spring Boot 3.2.1, Gradle 8 (Kotlin DSL). No JDK installation is required — the toolchain will download JDK 21 automatically if needed.

## Architecture

All exercises share the same base package: `de.dhbw.ravensburg.wp.mymoviedatabase`

**Testing approach:** There are no traditional unit tests. Integration is verified via `ManualTestBean`, a `@Component` annotated with `@EventListener(ApplicationReadyEvent.class)` that runs queries and logs results on application startup. Observe results in the console output when running `bootRun`.

**Database (Aufgabe 2 & 3):** H2 in-memory database with `hibernate.ddl-auto=create-drop`. Schema is recreated fresh on every run. H2 console available at `/h2`.

## Exercise-Specific Notes

### Aufgabe 1 — Spring DI
Introduces `@Service`, `@Controller`, `@Component` annotations and constructor injection. The solution adds interfaces (`MovieService`, `MovieController`, `ArtistService`) and their `Impl` classes.

### Aufgabe 2 — Basic JPA
Introduces the `Movie` entity (Lombok-based) and `MovieRepository extends JpaRepository<Movie, Long>`. Demonstrates:
- Derived query methods (`findByTitleContaining`, `findByImdbRatingGreaterThan`)
- Custom JPQL with `@Query` and `@Param`

### Aufgabe 3 — Advanced JPA
Extends the `Movie` entity with four relationships:

| Relationship | Type | Owning Side | Cascade |
|---|---|---|---|
| Movie ↔ Director | ManyToOne / OneToMany | Movie | ALL |
| Movie ↔ MovieCast | ManyToMany (join table `movie_moviecast`) | Movie | ALL |
| Movie ↔ Soundtrack | OneToOne | Soundtrack | ALL |
| Movie ↔ Award | ManyToOne / OneToMany | Award | ALL (solution only) |

Key pitfalls demonstrated in the exercises:
- **Bidirectional relationships:** Both sides must be set before persisting (especially `Soundtrack ↔ Movie`).
- **Lazy loading:** `MovieServiceImpl` must be `@Transactional` to resolve lazy-loaded collections like `involvedMovieCast` outside the original persistence context.
- **JPQL JOINs:** Use `JOIN m.involvedMovieCast c` (collection join) and `m.soundtrack.author` (nested attribute path).

## Conventions

- Implementation classes use the `Impl` suffix; interfaces have no suffix.
- Package layout: `model/`, `repository/`, `service/`, `controller/`
- Lombok is used on all entities (`@Getter`, `@Setter`, `@NoArgsConstructor`, `@Slf4j`).
- Jakarta Persistence API (not `javax.persistence`) — this is Spring Boot 3 / Jakarta EE 10.
- Compiler flag `-parameters` is set in all `build.gradle.kts` files to support named JPQL parameters.
