pctUs = 6/10                                     # 60% US
pctUsTotal = 2/3                                 #     66% Total US
pctUsSmallValue = 1/3                            #     33% Small Cap Value
pctInt = 3/10                                    # 30% Int
pctIntDeveloped = 1/2                            #     66% Developed
pctIntEmerging = 1/2                             #     33% Emerging
pctReit = 1/10                                   # 10% REIT

console.log('      US Total:  ' + (100 * pctUs * pctUsTotal).toFixed(1) + '%')
console.log('US Small Value:  ' + (100 * pctUs * pctUsSmallValue).toFixed(1) + '%')
console.log('     Int Total:  ' + (100 * pctInt * pctIntDeveloped).toFixed(1) + '%')
console.log('  Int Emerging:  ' + (100 * pctInt * pctIntEmerging).toFixed(1) + '%')
console.log('          REIT:  ' + (100 * pctReit).toFixed(1) + '%')
