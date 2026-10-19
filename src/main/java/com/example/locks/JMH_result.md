# JMH locks benchmark results reads/writes 50/50 (simple read section with 4 threads)

Benchmark    (writePercent)   Mode  Cnt         Score         Error  Units
ReentrantReadWriteLock   50  thrpt   25   21125471.869  ?   523924.250  ops/s
ReentrantLock            50  thrpt   25   54961076.472  ?  1412297.305  ops/s
StampedLock              50  thrpt   25   98934910.056  ?  1948854.150  ops/s
Synchronized             50  thrpt   25   12332474.170  ?  1391365.755  ops/s


# JMH locks benchmark results reads/writes 10/90 (simple read section with 4 threads)

Benchmark    (writePercent)   Mode  Cnt         Score         Error     Units
ReentrantReadWriteLock   90  thrpt   25   22962327.512  ?   774354.901  ops/s
ReentrantLock            90  thrpt   25   61124998.184  ?  3204888.054  ops/s
StampedLock              90  thrpt   25   66314944.804  ?  4988762.968  ops/s
Synchronized             90  thrpt   25   10545885.326  ?   314696.425  ops/s

# JMH locks benchmark results reads/writes 90/10 (simple read section with 4 threads)

Benchmark    (writePercent)   Mode  Cnt          Score         Error    Units
ReentrantReadWriteLock   10  thrpt   25   21406149.224  ?  761434.328   ops/s
ReentrantLock            10  thrpt   25   55959473.430  ? 1394948.106   ops/s
StampedLock              10  thrpt   25  273051496.050  ? 4966045.845   ops/s
Synchronized             10  thrpt   25   11958723.127  ? 1092921.909   ops/s

# JMH locks benchmark results reads/writes 90/10 (medium read section with 4 threads)

Benchmark    (writePercent)   Mode  Cnt         Score        Error      Units
ReentrantReadWriteLock   10  thrpt   25    5898474.395  ?  315526.767   ops/s
ReentrantLock            10  thrpt   25   12878297.589  ?  874186.036   ops/s
StampedLock              10  thrpt   25   12419902.101  ?  325117.977   ops/s
Synchronized             10  thrpt   25   16927184.016  ?  522275.656   ops/s

# JMH locks benchmark results reads/writes 99/1 (medium read section with 1 thread)

Benchmark    (writePercent)   Mode  Cnt         Score        Error      Units

ReentrantReadWriteLock    1  thrpt   25   19334555.993  ?    45758.693  ops/s
ReentrantLock             1  thrpt   25   18733767.125  ?   874786.821  ops/s
StampedLock               1  thrpt   25   20689091.704  ?    46291.772  ops/s
Synchronized              1  thrpt   25   19837532.502  ?    54870.694  ops/s

# JMH locks benchmark results reads/writes 99/1 (medium read section with 10 threads)

Benchmark    (writePercent)   Mode  Cnt         Score        Error      Units

ReentrantReadWriteLock    1  thrpt   25    6862880.058  ?   322740.106  ops/s
ReentrantLock             1  thrpt   25   12396244.769  ?  1026737.341  ops/s
StampedLock               1  thrpt   25   22359742.237  ?   941776.493  ops/s
Synchronized              1  thrpt   25   13587181.160  ?   982114.051  ops/s