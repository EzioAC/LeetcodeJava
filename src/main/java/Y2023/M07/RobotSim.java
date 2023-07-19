package Y2023.M07;

import java.util.HashSet;
import java.util.Set;

public class RobotSim {
	public int robotSim(int[] commands, int[][] obstacles) {
		Set<Long> obstacleSet = new HashSet<>();
		for (int[] obstacle : obstacles) {
			obstacleSet.add(obstacle[0] * 100000L + obstacle[1]);
		}
		int res = 0;
		int[] Y = new int[]{1,0,-1,0};
		int[] X = new int[]{0,-1,0,1};
		int[] currPosition = new int[] {0,0};
		int currentDirection = 0;
		for (int command : commands) {
			if(command == -1) {
				currentDirection = (currentDirection + 3) %4;
			} else if(command == -2) {
				currentDirection = (currentDirection + 1) %4;
			} else {
				for (int i = 1; i <= command; i++) {
					int x = currPosition[0] + X[currentDirection];
					int y = currPosition[1] + Y[currentDirection];
					if(obstacleSet.contains(x*100000L+y)) {
						break;
					}
					currPosition[0] = x;
					currPosition[1] = y;
				}
				res = Math.max(res, currPosition[0]*currPosition[0] + currPosition[1]*currPosition[1]);
			}
		}
		return res;
	}
}
