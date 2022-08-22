class Solution {
    public int[] avoidFlood(int[] rains) {
        // Keep track of full lakes and the last rain date for them.
        Map<Integer, Integer> fullLakes = new HashMap<>();
        // Keep track of days with no rain that we didn't use yet.
        TreeSet<Integer> noRain = new TreeSet<>();
        int n = rains.length;
        // Hold result to return
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int rain = rains[i];
            if (rain == 0) {
                noRain.add(i);
            } else {
                if (fullLakes.containsKey(rain)) {
                    // lake is full
                    Integer dry = 
                        noRain.ceiling(fullLakes.get(rain));
                    if (dry == null) {
                        // There is no way we can dry the lake
                        return new int[0];
                    }
                    noRain.remove(dry);
                    res[dry] = rain;
                }
                fullLakes.put(rain, i);
                res[i] = -1;
            }
        }
        for (int noRainDay: noRain) {
            res[noRainDay] = 1;
        }
        return res;
    }
}