class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collisions = new Stack<>();
        for (int asteroid: asteroids) {
            if (collisions.isEmpty() || asteroid > 0) {
                collisions.push(asteroid);
            } else {
                boolean intact = true;
                while (!collisions.isEmpty()) {
                    int collision = collisions.peek();
                    
                    if (collision < 0) {
                        break;
                    } else if (collision == -asteroid) {
                        collisions.pop();
                        intact = false;
                        break;
                    } else if (collision < -asteroid) {
                        collisions.pop();
                    } else {
                        intact = false;
                        break;
                    }
                }

                if (intact) {
                    collisions.push(asteroid);
                }
            }
        }

        int[] remainingAsteroids = new int[collisions.size()];
        for (int i = 0; i < remainingAsteroids.length; i++) {
            remainingAsteroids[remainingAsteroids.length - i - 1] = collisions.pop();
        }

        return remainingAsteroids;
    }
}