# Black hole 100

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| Synchronized | 13473162.000 | 1730259.682 | 12.84% | x 2.975 |
| ReentrantLock | 12530898.400 | 170001.226 | 1.36% | x 2.767 |
| StampedLock | 12325085.790 | 134946.520 | 1.09% | x 2.722 |
| ReadWriteLock | 4528769.433 | 107328.685 | 2.37% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 18324725.680 | 481031.989 | 2.63% | x 3.075 |
| ReentrantLock | 7799574.052 | 306335.131 | 3.93% | x 1.309 |
| Synchronized | 7303484.036 | 198692.955 | 2.72% | x 1.226 |
| ReadWriteLock | 5958671.332 | 180999.255 | 3.04% | x 1 |

# Black hole 2k

### Benchmark read/write 50/50

ReadWriteLock            50  thrpt   25  310486.521 ? 15937.100  ops/s
ReentrantLock            50  thrpt   25  576844.263 ? 28484.457  ops/s
StampedLock              50  thrpt   25  522080.162 ? 38047.211  ops/s
Synchronized             50  thrpt   25  528178.172 ? 33892.224  ops/s

### Benchmark read/write 99/1

ReadWriteLock               1  thrpt   25  1196823.017 ? 251383.783  ops/s
ReentrantLock               1  thrpt   25   192759.977 ?   6767.636  ops/s
StampedLock                 1  thrpt   25  3449696.030 ?  76254.957  ops/s
Synchronized                1  thrpt   25   307800.583 ?   5652.629  ops/s

# Black hole 5k

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| ReentrantLock | 287717.107 | 9495.178 | 3.30% | x 1.302 |
| Synchronized | 265976.905 | 2044.467 | 0.77% | x 1.204 |
| StampedLock | 255333.419 | 42008.144 | 16.45% | x 1.156 |
| ReadWriteLock | 220959.805 | 4209.408 | 1.91% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 1330474.736 | 30623.121 | 2.30% | x 15.222 |
| ReadWriteLock | 976645.815 | 26295.781 | 2.69% | x 11.174 |
| Synchronized | 132693.220 | 293.088 | 0.22% | x 1.518 |
| ReentrantLock | 87402.660 | 1079.031 | 1.23% | x 1 |

# Black hole 10k

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| ReadWriteLock | 94871.591 | 2338.723 | 2.47% | x 1.086 |
| StampedLock | 93778.464 | 1030.368 | 1.10% | x 1.074 |
| ReentrantLock | 88102.528 | 131.302 | 0.15% | x 1.009 |
| Synchronized | 87320.300 | 1191.414 | 1.36% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 713082.943 | 12435.873 | 1.74% | x 9.588 |
| ReadWriteLock | 560347.301 | 9108.989 | 1.63% | x 7.534 |
| ReentrantLock | 78623.620 | 215.557 | 0.27% | x 1.057 |
| Synchronized | 74372.864 | 379.091 | 0.51% | x 1 |

# Black hole 25k

### Benchmark read/write 50/50

ReadWriteLock             50  thrpt   25   88601.598 ? 43095.104  ops/s
ReentrantLock             50  thrpt   25   57415.433 ?  8444.846  ops/s
StampedLock               50  thrpt   25  151143.071 ?  1955.055  ops/s
Synchronized              50  thrpt   25   63067.195 ?   287.301  ops/s

### Benchmark read/write 99/1

Benchmark                                                            (writePercent)   Mode  Cnt       Score       Error  Units
ReadWriteLock              1  thrpt   25  110504.221 ? 29399.822  ops/s
ReentrantLock              1  thrpt   25   17271.131 ?    24.050  ops/s
StampedLock                1  thrpt   25  114384.345 ?  3292.738  ops/s
Synchronized               1  thrpt   25   17273.744 ?    37.809  ops/s


# Black hole 50k

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| ReadWriteLock | 81210.571 | 6877.372 | 8.47% | x 2.712 |
| StampedLock | 70128.933 | 573.828 | 0.82% | x 2.342 |
| Synchronized | 31912.874 | 1109.638 | 3.48% | x 1.066 |
| ReentrantLock | 29942.230 | 835.876 | 2.79% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 147734.423 | 656.235 | 0.44% | x 9.041 |
| ReadWriteLock | 133250.915 | 2796.915 | 2.10% | x 8.155 |
| Synchronized | 16427.366 | 81.447 | 0.50% | x 1.005 |
| ReentrantLock | 16340.690 | 102.864 | 0.63% | x 1 |
