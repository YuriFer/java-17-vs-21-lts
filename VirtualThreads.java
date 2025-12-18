import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreads {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Comparação: Platform Threads vs Virtual Threads ===\n");
        
        // Demonstração 1: Criando threads
        demonstrateThreadCreation();
        
        // Demonstração 2: Performance com muitas threads
        System.out.println("\n=== Teste de Performance ===");
        comparePerformance();
    }

    static void demonstrateThreadCreation() {
        System.out.println("1. Criando Virtual Thread:");
        
        // Antes - Java 17: Platform Thread (Thread tradicional)
        Thread platformThread = new Thread(() -> {
            System.out.println("Platform Thread executando: " + Thread.currentThread());
        });
        platformThread.start();

        // Depois - Java 21: Virtual Thread (leve e eficiente)
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual Thread executando: " + Thread.currentThread());
        });

        try {
            platformThread.join();
            virtualThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void comparePerformance() {
        int numberOfTasks = 10_000;

        // Java 17 - Platform Threads (limitadas pelo OS)
        long startPlatform = System.currentTimeMillis();
        try (var executor = Executors.newFixedThreadPool(100)) {
            IntStream.range(0, numberOfTasks).forEach(i -> {
                executor.submit(() -> {
                    try {
                        Thread.sleep(Duration.ofMillis(100));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        }
        long endPlatform = System.currentTimeMillis();
        System.out.println("Platform Threads (" + numberOfTasks + " tasks): " + 
            (endPlatform - startPlatform) + "ms");

        // Java 21 - Virtual Threads (milhões possíveis)
        long startVirtual = System.currentTimeMillis();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, numberOfTasks).forEach(i -> {
                executor.submit(() -> {
                    try {
                        Thread.sleep(Duration.ofMillis(100));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        }
        long endVirtual = System.currentTimeMillis();
        System.out.println("Virtual Threads (" + numberOfTasks + " tasks): " + 
            (endVirtual - startVirtual) + "ms");

        System.out.println("\nMelhoria: " + 
            String.format("%.2f", (double)(endPlatform - startPlatform) / (endVirtual - startVirtual)) + "x mais rápido");
    }

    // Exemplo adicional: Thread.Builder API
    static void demonstrateThreadBuilder() {
        Thread thread = Thread.ofVirtual()
            .name("worker-thread")
            .unstarted(() -> System.out.println("Virtual thread com nome customizado"));
        
        thread.start();
    }
}
