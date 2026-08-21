class TopVotedCandidate {

    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[times.length];

        int[] count = new int[persons.length];
        int leader = -1;

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];

            count[person]++;

        
            if (leader == -1 || count[person] >= count[leader]) {
                leader = person;
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {

        int left = 0;
        int right = times.length - 1;

   
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leaders[right];
    }
}