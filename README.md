Program cracks numerical series trying to find number that should occur next.

1. Main
Accept a serie of numbers separated by commas

2. Cracker
Find pattern between numbers for diffrent number of 'jumps'
e.g. (1) => 0 : 1 (2) => 0 : 2

3. PatternAnalyse
Analyses every pattern possible and calculates probability of it being the right one, if percentage is low it trie to find pattern from that pattern 
e.g if first pattern is diff(5,10,15,20) then next difference would be 25

4. ApplySolution
If probability is high enough, it applies the solution and prints series with next number that occurs next 
