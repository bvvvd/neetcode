class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rTurn = r.poll();
            int dTurn = d.poll();

            if (rTurn < dTurn) {
                r.add(rTurn + senate.length());
            } else {
                d.add(dTurn + senate.length());
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}