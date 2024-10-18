package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class L84 {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] NSR = new int[n];
        int[] NSL = new int[n];

        Stack<Integer> stack = new Stack<>();

        //NSR
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = n;
            } else {
                System.out.print(stack.peek());
                NSR[i] = stack.peek();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(NSR));

        stack.clear();

        //NSL
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                System.out.print(stack.peek());
                NSL[i] = stack.peek();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(NSL));


        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
