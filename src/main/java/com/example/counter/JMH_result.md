# JMH counter benchmark results

| Benchmark | Mode | Cnt | Score | Error | Units |
|---|---|---:|---:|---:|---|
| `CounterJmhBenchmark.atomic` | thrpt | 25 | 71,868,703.485 | ? 8,168,781.757 | ops/s |
| `CounterJmhBenchmark.casCounter` | thrpt | 25 | 35,583,162.239 | ? 9,105,670.332 | ops/s |
| `CounterJmhBenchmark.synchronizedCounter` | thrpt | 25 | 10,445,494.380 | ? 1,122,768.556 | ops/s |