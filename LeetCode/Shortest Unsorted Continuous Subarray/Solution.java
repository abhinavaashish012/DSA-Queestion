/*
Link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.


Use example  : [2,6,4,1,14,10,5,7,15] for better understanding using Monotonic Queue
*/

import java.util.*;
import java.io.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int left = n-1;

        for(int i=0;i<n;)
        {
            if(st.size()==0)
            {
                st.push(i);
                i++;
            }
            else
            {
                if(nums[st.peek()] > nums[i])
                {
                    left = Math.min(st.peek(),left);
                    st.pop();
                }
                else
                {
                    st.push(i);
                    i++;
                }
            }
        }

        st.clear();
        int right=0;

        for(int i=n-1;i>=0;)
        {
            if(st.size()==0)
            {
                st.push(i);
                i--;
            }
            else
            {
                if(nums[st.peek()] < nums[i])
                {
                    right = Math.max(st.peek(),right);
                    st.pop();
                }
                else
                {
                    st.push(i);
                    i--;
                }
            }
        }
        if(left>=right)
            return 0;
        return right-left+1;


    }



    public static void main(String[] args) {

    }
}
