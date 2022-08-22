class Solution:
    def getProbability(self, balls: List[int]) -> float:
        N = len(balls)
        sumBalls = sum(balls)
 
        @lru_cache(None)
        def count(index, delta, ca):
            if index == N:
                if delta == 0 and ca * 2 == sumBalls:
                    return 1
                return 0
 
            total = 0
            for x in range(1, balls[index]):
                total += count(index+1, delta, ca+x) * math.comb(balls[index], x)
            total += count(index+1, delta+1, ca)
            total += count(index+1, delta-1, ca+balls[index])
            return total
 
        return count(0, 0, 0) / math.comb(sumBalls, sumBalls // 2)