class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b.pos, a.pos));
        Stack<Double> stack = new Stack<>();
        for (Car c : cars) {
            stack.push((double) (target - c.pos) / c.speed);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}

class Car {
    int pos;
    int speed;

    public Car(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}
