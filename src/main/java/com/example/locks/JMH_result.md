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

Benchmark  (writePercent)   Mode   Cnt          Score          Error  Units

ReadWriteLock      50       thrpt   25       94871.591 ? 2338.723  ops/s
ReentrantLock      50       thrpt   25       88102.528 ?  131.302  ops/s
StampedLock        50       thrpt   25       93778.464 ? 1030.368  ops/s
Synchronized       50       thrpt   25       87320.300 ? 1191.414  ops/s

### Benchmark read/write 99/1

ReadWriteLock     1         thrpt   25      560347.301 ?  9108.989  ops/s
ReentrantLock     1         thrpt   25       78623.620 ?   215.557  ops/s
StampedLock       1         thrpt   25      713082.943 ? 12435.873  ops/s
Synchronized      1         thrpt   25       74372.864 ?   379.091  ops/s

# Black hole 50k

## 1 thread

### Benchmark read/write 50/50

ReadWriteLock      50       thrpt   25      22856.948 ? 5547.597  ops/s
ReentrantLock      50       thrpt   25      31445.376 ? 1492.909  ops/s
StampedLock        50       thrpt   25      28751.615 ? 1166.758  ops/s
Synchronized       50       thrpt   25      30111.805 ? 1316.372  ops/s

### Benchmark read/write 99/1

ReadWriteLock      1        thrpt   25      10060.138 ? 2024.140  ops/s
ReentrantLock      1        thrpt   25       9041.086 ?  408.921  ops/s
StampedLock        1        thrpt   25      11882.600 ? 2806.462  ops/s
Synchronized       1        thrpt   25      13283.177 ? 2888.365  ops/s

## 10 threads

### Benchmark read/write 50/50

ReadWriteLock      50       thrpt   25      81210.571 ? 6877.372  ops/s
ReentrantLock      50       thrpt   25      29942.230 ?  835.876  ops/s
StampedLock        50       thrpt   25      70128.933 ?  573.828  ops/s
Synchronized       50       thrpt   25      31912.874 ? 1109.638  ops/s

### Benchmark read/write 99/1

ReadWriteLock      1        thrpt   25     133250.915 ? 2796.915  ops/s
ReentrantLock      1        thrpt   25      16340.690 ?  102.864  ops/s
StampedLock        1        thrpt   25     147734.423 ?  656.235  ops/s
Synchronized       1        thrpt   25      16427.366 ?   81.447  ops/s