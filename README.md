# Java Memory Model stress tests

JCStress, JMH and concurrency experiments

## Build

```powershell
mvn clean install
```

## JCStress

Separate test in quick mode

```powershell
java -jar target/concurency-tests-1.0-SNAPSHOT-jcstress.jar -t com.example.counter.CounterJcstressTest -m quick
```
All tests 

```powershell
java -jar target/concurency-tests-1.0-SNAPSHOT-jcstress.jar
```

## JMH

List available benchmarks:

```powershell
java -cp target/concurency-tests-1.0-SNAPSHOT-jmh.jar org.openjdk.jmh.Main -l
```

Run the benchmarks with one or four threads:

```powershell
java -cp target/concurency-tests-1.0-SNAPSHOT-jmh.jar org.openjdk.jmh.Main com.example.counter.CounterJmhBenchmark.atomic -t 1
java -cp target/concurency-tests-1.0-SNAPSHOT-jmh.jar org.openjdk.jmh.Main com.example.counter.CounterJmhBenchmark.atomic -t 4
```
