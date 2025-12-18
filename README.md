# java-17-vs-21-lts
Este repositório demonstra, de forma prática, as principais diferenças entre Java 17 e Java 21.

## Principais temas

### 1. Sequenced Collections
- **Arquivo**: [SequencedCollections.java](SequencedCollections.java)
- **Novidade**: Interfaces `SequencedCollection`, `SequencedSet` e `SequencedMap`
- **Métodos**: `getFirst()`, `getLast()`, `reversed()`, `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`

### 2. Record Patterns
- **Arquivo**: [RecordPatterns.java](RecordPatterns.java)
- **Novidade**: Desestruturação de records diretamente no `instanceof`
- **Benefício**: Código mais conciso e legível

### 3. Pattern Matching for Switch
- **Arquivo**: [PatternMatchingSwitch.java](PatternMatchingSwitch.java)
- **Novidade**: Type patterns e guarded patterns no switch
- **Benefício**: Substitui múltiplos if-else por switch expressivo

### 4. Virtual Threads
- **Arquivo**: [VirtualThreads.java](VirtualThreads.java)
- **Novidade**: Threads leves gerenciadas pela JVM
- **Benefício**: Milhões de threads concorrentes com baixo overhead

## Como executar

```bash
# Compilar
javac *.java

# Executar cada exemplo
java SequencedCollections
java RecordPatterns
java PatternMatchingSwitch
java VirtualThreads
```

## Requisitos
- Java 21 ou superior