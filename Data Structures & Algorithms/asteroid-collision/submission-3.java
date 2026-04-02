class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collisions = new Stack<>();
        for (int asteroid: asteroids) {
            if (asteroid > 0) {
                collisions.push(asteroid);
            } else {
                boolean intact = true;
                while (!collisions.isEmpty() && collisions.peek() > 0) {
                    int opponent = collisions.pop();

                    if (opponent == -asteroid) {
                        intact = false;
                        break;
                    } else if (opponent > -asteroid) {
                        intact = false;
                        collisions.push(opponent);
                        break;
                    }
                }
                if (intact) {
                    collisions.push(asteroid);
                }
            }
        }

        int[] remainingAsteroids = new int[collisions.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = collisions.pop();
        }
        return remainingAsteroids;
    }
}