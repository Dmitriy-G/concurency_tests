# Black hole 100

## 1 thread

### Benchmark read/write 50/50

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock     50        thrpt   25  17478262.810 ?  44830.170  ops/s
ReentrantLock     50        thrpt   25  18531558.309 ? 100736.808  ops/s
StampedLock       50        thrpt   25  19413105.187 ?  77223.637  ops/s
Synchronized      50        thrpt   25  18536761.650 ?  65868.696  ops/s

### Benchmark read/write 99/1

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock     1         thrpt   25   9542470.864 ?  31531.264  ops/s
ReentrantLock     1         thrpt   25   5114249.153 ? 963933.613  ops/s
StampedLock       1         thrpt   25  10251428.275 ?  44060.202  ops/s
Synchronized      1         thrpt   25   9915175.672 ?  39603.147  ops/s

## 10 threads

### Benchmark read/write 50/50

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock    50         thrpt   25   4528769.433 ?  107328.685  ops/s
ReentrantLock    50         thrpt   25  12530898.400 ?  170001.226  ops/s
StampedLock      50         thrpt   25  12325085.790 ?  134946.520  ops/s
Synchronized     50         thrpt   25  13473162.000 ? 1730259.682  ops/s

### Benchmark read/write 99/1

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock      1        thrpt   25   5958671.332 ? 180999.255  ops/s
ReentrantLock      1        thrpt   25   7799574.052 ? 306335.131  ops/s
StampedLock        1        thrpt   25  18324725.680 ? 481031.989  ops/s
Synchronized       1        thrpt   25   7303484.036 ? 198692.955  ops/s

# Black hole 5k

## 1 thread

### Benchmark read/write 50/50

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock    50         thrpt   25   334513.030 ? 1043.752  ops/s
ReentrantLock    50         thrpt   25   176390.112 ? 8704.941  ops/s
StampedLock      50         thrpt   25   176874.556 ?  531.587  ops/s
Synchronized     50         thrpt   25   177063.495 ?  475.337  ops/s

### Benchmark read/write 99/1

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock     1          thrpt   25  136039.637 ? 29732.453  ops/s
ReentrantLock     1          thrpt   25   89535.538 ?   407.614  ops/s
StampedLock       1          thrpt   25  126489.000 ? 20024.509  ops/s
Synchronized      1          thrpt   25  142566.206 ?  8607.618  ops/s

## 10 threads

### Benchmark read/write 50/50

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock    50          thrpt   25  220959.805 ?  4209.408  ops/s
ReentrantLock    50          thrpt   25  287717.107 ?  9495.178  ops/s
StampedLock      50          thrpt   25  255333.419 ? 42008.144  ops/s
Synchronized     50          thrpt   25  265976.905 ?  2044.467  ops/s

### Benchmark read/write 99/1

Benchmark   (writePercent)   Mode  Cnt      Score          Error  Units

ReadWriteLock     1          thrpt   25   976645.815 ? 26295.781  ops/s
ReentrantLock     1          thrpt   25    87402.660 ?  1079.031  ops/s
StampedLock       1          thrpt   25  1330474.736 ? 30623.121  ops/s
Synchronized      1          thrpt   25   132693.220 ?   293.088  ops/s

# Black hole 10k

## 1 thread

### Benchmark read/write 50/50

Benchmark   (writePercent)   Mode  Cnt          Score          Error  Units

ReadWriteLock     50         thrpt   25      92997.682 ?     13114.801  ops/s
ReentrantLock     50         thrpt   25      95544.011 ?     16751.692  ops/s
StampedLock       50         thrpt   25     119964.899 ?     30067.193  ops/s
Synchronized      50         thrpt   25      88567.425 ?       177.796  ops/s

### Benchmark read/write 99/1

Benchmark  (writePercent)   Mode   Cnt          Score          Error  Units

ReadWriteLock     1         thrpt    25      60151.168 ?    14905.206  ops/s
ReentrantLock     1         thrpt    25      44474.254 ?      279.931  ops/s
StampedLock       1         thrpt    25      71552.347 ?     3212.670  ops/s
Synchronized      1         thrpt    25      43818.922 ?     1805.434  ops/s

## 10 threads

### Benchmark read/write 50/50

### Benchmark read/write 99/1