import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    public static class FireBall {
        int row, col, mass, speed, direction;
        
        FireBall(int row, int col, int mass, int speed, int direction){
            this.row = row;
            this.col = col;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }
    
    public static int N, M, K;
    public static int[][] map;
    public static int[][] d = {
        {-1,0}, {-1,1}, {0,1}, {1,1},
        {1,0}, {1,-1}, {0,-1}, {-1,-1}
    };
    public static ArrayList<FireBall> balls;
    public static ArrayList<FireBall> tempBalls;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        balls = new ArrayList<>();
        tempBalls = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            
            balls.add(new FireBall(r, c, mass, speed, direction));
        }
        
        for(int step = 0; step < K; step++) {
            moveFireBalls();
            mergeAndSplitFireBalls();
        }
        
        System.out.println(calculateTotalMass());
    }
    
    public static void moveFireBalls() {
        map = new int[N+1][N+1];
        for(int i = 0; i < balls.size(); i++) {
            FireBall fb = balls.get(i);
            int newRow = calculatePosition(fb.row, d[fb.direction][0], fb.speed);
            int newCol = calculatePosition(fb.col, d[fb.direction][1], fb.speed);
            balls.set(i, new FireBall(newRow, newCol, fb.mass, fb.speed, fb.direction));
            map[newRow][newCol]++;
        }
    }
    
    public static int calculatePosition(int pos, int delta, int speed) {
        int newPos = (pos + delta * speed) % N;
        if (newPos <= 0) newPos += N;
        return newPos;
    }
    
    public static void mergeAndSplitFireBalls() {
        ArrayList<FireBall> mergedBalls = new ArrayList<>();
        
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(map[r][c] >= 2) {
                    int sumMass = 0;
                    int sumSpeed = 0;
                    int count = 0;
                    int oddCount = 0;
                    int evenCount = 0;
                    
                    for(int i = 0; i < balls.size(); i++) {
                        FireBall fb = balls.get(i);
                        if(fb.row == r && fb.col == c) {
                            sumMass += fb.mass;
                            sumSpeed += fb.speed;
                            count++;
                            if(fb.direction % 2 == 0) evenCount++;
                            else oddCount++;
                            balls.remove(i);
                            i--;
                        }
                    }
                    
                    int newMass = sumMass / 5;
                    if(newMass > 0) {
                        int newSpeed = sumSpeed / count;
                        boolean allEven = (count == evenCount);
                        boolean allOdd = (count == oddCount);
                        
                        if(allEven || allOdd) {
                            for(int dir = 0; dir < 8; dir += 2) {
                                mergedBalls.add(new FireBall(r, c, newMass, newSpeed, dir));
                            }
                        } else {
                            for(int dir = 1; dir < 8; dir += 2) {
                                mergedBalls.add(new FireBall(r, c, newMass, newSpeed, dir));
                            }
                        }
                    }
                }
            }
        }
        
        tempBalls = mergedBalls;
        for(FireBall fb : balls){
            tempBalls.add(fb);
        }
        balls = new ArrayList<>(tempBalls);
        tempBalls.clear();
    }
    
    public static int calculateTotalMass() {
        int total = 0;
        for(FireBall fb : balls){
            total += fb.mass;
        }
        return total;
    }
}
