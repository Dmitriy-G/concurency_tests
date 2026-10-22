# Black hole 100

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 19413105.187 | 77223.637 | 0.40% | x 1.111 |
| Synchronized | 18536761.650 | 65868.696 | 0.36% | x 1.061 |
| ReentrantLock | 18531558.309 | 100736.808 | 0.54% | x 1.06 |
| ReadWriteLock | 17478262.810 | 44830.170 | 0.26% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 10251428.275 | 44060.202 | 0.43% | x 2.004 |
| Synchronized | 9915175.672 | 39603.147 | 0.40% | x 1.939 |
| ReadWriteLock | 9542470.864 | 31531.264 | 0.33% | x 1.866 |
| ReentrantLock | 5114249.153 | 963933.613 | 18.85% | x 1 |

# Black hole 5k

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| ReadWriteLock | 334513.030 | 1043.752 | 0.31% | x 1.896 |
| Synchronized | 177063.495 | 475.337 | 0.27% | x 1.004 |
| StampedLock | 176874.556 | 531.587 | 0.30% | x 1.003 |
| ReentrantLock | 176390.112 | 8704.941 | 4.94% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| Synchronized | 142566.206 | 8607.618 | 6.04% | x 1.592 |
| ReadWriteLock | 136039.637 | 29732.453 | 21.86% | x 1.519 |
| StampedLock | 126489.000 | 20024.509 | 15.83% | x 1.413 |
| ReentrantLock | 89535.538 | 407.614 | 0.46% | x 1 |

# Black hole 10k

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 119964.899 | 30067.193 | 25.06% | x 1.355 |
| ReentrantLock | 95544.011 | 16751.692 | 17.53% | x 1.079 |
| ReadWriteLock | 92997.682 | 13114.801 | 14.10% | x 1.05 |
| Synchronized | 88567.425 | 177.796 | 0.20% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| StampedLock | 71552.347 | 3212.670 | 4.49% | x 1.633 |
| ReadWriteLock | 60151.168 | 14905.206 | 24.78% | x 1.373 |
| ReentrantLock | 44474.254 | 279.931 | 0.63% | x 1.015 |
| Synchronized | 43818.922 | 1805.434 | 4.12% | x 1 |

# Black hole 50k

### Benchmark read/write 50/50

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| ReentrantLock | 31445.376 | 1492.909 | 4.75% | x 1.376 |
| Synchronized | 30111.805 | 1316.372 | 4.37% | x 1.317 |
| StampedLock | 28751.615 | 1166.758 | 4.06% | x 1.258 |
| ReadWriteLock | 22856.948 | 5547.597 | 24.27% | x 1 |

### Benchmark read/write 99/1

| Lock Type | Score | Error | Error (%) | Total |
| --- | ---: | ---: | ---: | ---: |
| Synchronized | 13283.177 | 2888.365 | 21.74% | x 1.469 |
| StampedLock | 11882.600 | 2806.462 | 23.62% | x 1.314 |
| ReadWriteLock | 10060.138 | 2024.140 | 20.12% | x 1.113 |
| ReentrantLock | 9041.086 | 408.921 | 4.52% | x 1 |
