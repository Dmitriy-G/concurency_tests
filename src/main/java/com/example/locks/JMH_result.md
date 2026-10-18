# JMH locks benchmark results reads/writes 50/50

Benchmark                                                                     (writePercent)   Mode  Cnt         Score         Error  Units
c.e.l.read_write_reentrant.ReentrantReadWriteLockJmhBenchmark.mixedReadWrite              50  thrpt   25  21125471.869 ?  523924.250  ops/s
c.e.l.simple_reentrant.ReentrantLockJmhBenchmark.mixedReadWrite                           50  thrpt   25  54961076.472 ? 1412297.305  ops/s
c.e.l.stamped.StampedLockJmhBenchmark.mixedReadWrite                                      50  thrpt   25  98934910.056 ? 1948854.150  ops/s
c.e.l.sync.SyncPessimisticLockJmhBenchmark.mixedReadWrite                                 50  thrpt   25  12332474.170 ? 1391365.755  ops/s


# JMH locks benchmark results reads/writes 10/90

Benchmark                                                                     (writePercent)   Mode  Cnt         Score         Error  Units
c.e.l.read_write_reentrant.ReentrantReadWriteLockJmhBenchmark.mixedReadWrite              90  thrpt   25  22962327.512 ?  774354.901  ops/s
c.e.l.simple_reentrant.ReentrantLockJmhBenchmark.mixedReadWrite                           90  thrpt   25  61124998.184 ? 3204888.054  ops/s
c.e.l.stamped.StampedLockJmhBenchmark.mixedReadWrite                                      90  thrpt   25  66314944.804 ? 4988762.968  ops/s
c.e.l.sync.SyncPessimisticLockJmhBenchmark.mixedReadWrite                                 90  thrpt   25  10545885.326 ?  314696.425  ops/s

# JMH locks benchmark results reads/writes 90/10

Benchmark                                                                     (writePercent)   Mode  Cnt          Score         Error  Units
c.e.l.read_write_reentrant.ReentrantReadWriteLockJmhBenchmark.mixedReadWrite              10  thrpt   25   21406149.224 ?  761434.328  ops/s
c.e.l.simple_reentrant.ReentrantLockJmhBenchmark.mixedReadWrite                           10  thrpt   25   55959473.430 ? 1394948.106  ops/s
c.e.l.stamped.StampedLockJmhBenchmark.mixedReadWrite                                      10  thrpt   25  273051496.050 ? 4966045.845  ops/s
c.e.l.sync.SyncPessimisticLockJmhBenchmark.mixedReadWrite                                 10  thrpt   25   11958723.127 ? 1092921.909  ops/s
