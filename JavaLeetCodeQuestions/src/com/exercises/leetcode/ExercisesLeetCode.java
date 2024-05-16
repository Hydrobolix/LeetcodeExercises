package com.exercises.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ExercisesLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int toBits = 43261596;
		
		System.out.println(longestConsecutive(arr));

	}
	
	/**************************************************
	 * 1. Two Sum
	 * ************************************************
	 * Return indices of two numbers such that they
	 * add up to target
	 * 
	 * @param (int[]) arr: the array to be searched
	 * 
	 * @param (int) target: the sum of the two numbers
	 * 
	 * @return (int[]) indices: the indices of the 
	 * 				   numbers summed
	 **************************************************/
	private static int[] twoSum(int[] arr, int target) {
		int[] indices = new int[] {0, 0};
		for (int indexOne = 0; indexOne < arr.length - 1; indexOne++) {
			for (int indexTwo = indexOne + 1; indexTwo < arr.length; indexTwo++) {
				//System.out.println(indexTwo);
				if (arr[indexOne] + arr[indexTwo] == target) {
					indices[0] = arr[indexOne];
					indices[1] = arr[indexTwo];
				}
			}
		}
		
		return indices;
		
	}
	
	/**************************************************
	 * 2. Best Time to Buy and Sell Stock
	 * ************************************************
	 * Given an array, choose a single day to buy one
	 * stock and choosing a different day in the future
	 * to sell that stock
	 * 
	 * @param (int[]) prices: the prices over given
	 * 				  days
	 * 
	 * @return (int) maximumProfit: the maximum profit
	 * 				 you can receive from this
	 * 				 transaction
	 **************************************************/
	private static int maxProfit(int[] prices) {
		int highestValue = 0;
		
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = 0; j < prices.length; j++) {
				if (j - i > highestValue)
					highestValue = j - i;
			}
		}
		
		return highestValue;
	}
	
	/**************************************************
	 * 3. Contains Duplicate
	 * ************************************************
	 * Check if a value appears twice in the array
	 * 
	 * @param (int[]) nums: the array to be searched
	 * 
	 * @return (boolean) isDuplicate: whether or
	 * 					 not the array contains a 
	 * 					 duplicate
	 **************************************************/
	private static boolean containsDuplicate(int[] nums) {
		boolean isDuplicate = false;
		
		if (nums.length < 2) {
			return isDuplicate;
		}
		
		for (int i = 0; i <= nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j])
					isDuplicate = true;
			}
				
		}
		
		return isDuplicate;
		
	}
	
	/**************************************************
	 * 4. Product of Array Except Self
	 * ************************************************
	 * Return an answer array such that an element is 
	 * equal to the product of all the elements of the
	 * given array, except the current indice
	 * 
	 * @param (int[]) nums: the array to search for
	 * 				  the products
	 * 
	 * @return (int[]) answer: the array of the products
	 **************************************************/
	private static int[] productOfArrayExceptSelf(int[] nums) {
		int[] answer;
		
		if (nums.length < 1) {
			return new int[] {0};
		}
		
		if (nums.length < 2) {
			answer = new int[nums.length];
			answer[0] = nums[0];
		}
		
		answer = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			answer[i] = 1;
			
			for (int j = 0; j < nums.length; j++) {
				if (i != j)
					answer[i] *= nums[j];
			}
		}
		
		return answer;
		
	}
	
	/**************************************************
	 * 5. Maximum Subarray
	 * ************************************************
	 * Find the subarray with the largest sum, and 
	 * return its sum
	 * 
	 * @param (int[]) nums: the array to search for
	 * 				  the largest subarray
	 * 
	 * @return (int) sum: the sum of the largest 
	 * 				   subarray
	 **************************************************/
	private static int maxSubArray(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int highestSum = Integer.MIN_VALUE;
		
		if (nums.length < 1) {
			return 0;
		}
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		for (int i = 0; i < nums.length; i++) {
			sum = nums[i];
			for (int j = i; j < nums.length; j++) {
				if (j - i == 1) {
					sum += nums[j];
					if (sum > highestSum)
						highestSum = sum;
				}
				
				if (j - i >= 2) {
					sum += nums[j];
					if (sum > highestSum)
						highestSum = sum;
				}
			}
		}
		
		return highestSum;
		
	}
	
	/**************************************************
	 * 6. Maximum Product Subarray
	 * ************************************************
	 * Find the subarray with the largest product, and 
	 * return its product
	 * 
	 * @param (int[]) nums: the array to search for
	 * 				  the largest subarray
	 * 
	 * @return (int) product: the product of the largest 
	 * 				   subarray
	 **************************************************/
	private static int maxProduct(int[] nums) {
		int product = Integer.MIN_VALUE;
		int highestProduct = Integer.MIN_VALUE;
		
		if (nums.length < 1) {
			return 0;
		}
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		for (int i = 0; i < nums.length; i++) {
			product = nums[i];
			for (int j = i; j < nums.length; j++) {
				if (j - i == 1) {
					product *= nums[j];
					if (product > highestProduct)
						highestProduct = product;
				}
				
				if (j - i >= 2) {
					product *= nums[j];
					if (product > highestProduct)
						highestProduct = product;
				}
			}
		}
		
		return highestProduct;
		
	}
	
	/**************************************************
	 * 7. Maximum Product Subarray
	 * ************************************************
	 * Return the minimum element of a sorted rotated
	 * array that runs in O(log n) time
	 * 
	 * @param (int[]) nums: the sorted rotated array to 
	 * 				  be searched
	 * 
	 * @return (int) minElement: the minimum element of 
	 * 			     this array
	 **************************************************/
	private static int findMin(int[] nums) {
		int minElement = Integer.MIN_VALUE;
		
		if (nums.length == 0)
			minElement = 0;
		
		if (nums.length == 1)
			minElement = nums[0];
		
		minElement = nums[0];
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (i > 0) {
				if (nums[i] < nums[i - 1]) {
					minElement = nums[i];
					return minElement;
				}	
			}
		}
		
		return minElement;
		
	}
	
	/**************************************************
	 * 8. Search in Rotated Sorted Array
	 * ************************************************
	 * Return the index of the target if it is in a 
	 * rotated sorted array that runs in O(log n) time
	 * 
	 * @param (int[]) nums: the sorted rotated array to 
	 * 				  be searched
	 * 
	 * @return (int) minElement: the target element of 
	 * 			     this array, or -1
	 **************************************************/
	private static int search(int[] nums, int target) {
		
		if (nums.length == 0)
			return -1;
		
		if (nums.length == 1)
			if (nums[0] == target)
				return nums[0];
			else
				return -1;
		
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] < nums[i - 1]) {
				if (nums[i] == target)
					return i;
			} else {			
				if (nums[i] == target)
					return i;
			}
		}
		
		return -1;
		
	}
	
	
	/**************************************************
	 * 9. 3-Sum
	 * ************************************************
	 * Return all triplets with unique indices whose
	 * sum equals 0
	 * 
	 * @param (int[]) nums: the array to be searched
	 * 
	 * @return (List<List<Integer>>) triplets: the list 
	 * 		   of triplets that sum to 0
	 **************************************************/
	private static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		
		if (nums.length < 3) {
			List<Integer> noTriplet = new ArrayList<Integer>();
			noTriplet.add(0);
			noTriplet.add(0);
			noTriplet.add(0);
			triplets.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++)
			if (nums[i] + nums[j] + nums[j+1] == 0) {
				List<Integer> triplet = new ArrayList<Integer>();
				triplet.add(nums[i]);
				triplet.add(nums[i+1]);
				triplet.add(nums[i+2]);
				triplets.add(triplet);
			}
		}
		
		if (triplets.size() == 0) {
			List<Integer> noTriplet = new ArrayList<Integer>();
			noTriplet.add(0);
			noTriplet.add(0);
			noTriplet.add(0);
			triplets.add(new ArrayList<Integer>());
		}
		
		return triplets;
		
	}
	
	/**************************************************
	 * 10. Container With Most Water
	 * ************************************************
	 * Given an integer array height if length n, 
	 * find the two lines that together with the x-axis 
	 * form a container, such that the container 
	 * contains the most water
	 * 
	 * @param (int[]) height: the array height
	 * 
	 * @return (int) mostWaterContainer: the container
	 * 				 with the most water
	 * 				 * two lines together with the 
	 * 				   x-axis forma a container
	 **************************************************/
	private static int maxArea(int[] nums) {
		int containerMostWater = Integer.MIN_VALUE;
		
		if (nums.length == 0)
			return containerMostWater;
		
		if (nums.length == 1)
			return nums[0];
		
		for (int i = 0; i <= nums.length - 2; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[j] <= nums[i]) {
					if (nums[j] * (j - i) > containerMostWater)
						containerMostWater = nums[j] * (j - i);
				}
			}
		}
		
		return containerMostWater;
		
	}
	
	/**************************************************
	 * 11. Sum of Two Integers
	 * ************************************************
	 * Return the sum without using the oeprators + and
	 * -
	 * 
	 * @param (int) numOne: a number to be added
	 * 
	 * @param (int) numTwo: a number to be added
	 * 
	 * @return (int) mostWaterContainer: the container
	 * 				 with the most water
	 * 				 * two lines together with the 
	 * 				   x-axis forma a container
	 **************************************************/
	private static int getSum(int numOne, int numTwo) {
		if (numOne == 0 && numTwo == 0)
			return 0;
		else if (numOne != 0 && numTwo ==0)
			return numOne;
		else if (numOne == 0 && numTwo !=0)
			return numTwo;
		else
			return Math.addExact(numOne, numTwo);
		
	}
	
	/**************************************************
	 * 12. Number of 1 Bits
	 * ************************************************
	 * Return the number of set bits (Hamming weight) 
	 * of a binary representation of a positive integer
	 * -
	 * 
	 * @param (int) n: the positive integer to be 
	 * 				presented in binary
	 * 
	 * @return (int) numberOfSetBits: the hammering 
	 * 				 weight
	 **************************************************/
	private static int hammingWeight(int n) {
		int copyN = n;
		String binary = "";
		int numberOfSetBits = 0;
		int highestExponent = 0;
		
		for (int i = 0; Math.pow(2, i) < n; i++)
			highestExponent = i;
		
		//System.out.println(highestExponent);
		
		for (int i = 0; i <= highestExponent; i++) {
			if (copyN - Math.pow(2, highestExponent - i) >= 1.0) {
				copyN -= Math.pow(2, highestExponent - i);
				binary += "1";
				numberOfSetBits += 1;
			} else if (copyN - Math.pow(2, highestExponent - i) == 0) {
				copyN = 0;
				binary += "1";
				numberOfSetBits += 1;
			} else {
				binary += "0";
			}
				
		}
		
		System.out.println("n: " + n + ", binary: " + binary);
		
		return numberOfSetBits;
		
	}
	
	/**************************************************
	 * 13. Counting Bits
	 * ************************************************
	 * Return an array ans of length n+1 representing 
	 * the number of 1s in binary representation of i
	 * 
	 * @param (int) n: the integer for the array
	 * 
	 * @return (int[]) ans: the array containing the
	 * 				   the number of 1s in binary
	 **************************************************/
	private static int[] countBits(int n) {
		int[] ans;
		String binary = "";
		
		if (n < 0) {
			return new int[] {0};
		}
		
		ans = new int[n + 1];
		
		for (int i = 0; i < ans.length; i++) {
			binary = BigInteger.valueOf(i).toString(2);
			
			for (int j = 0; j < binary.length(); j++)
				if (binary.charAt(j) == '1')
					ans[i]++;
		}
		
		return ans;
		
	}
	
	/**************************************************
	 * 14. Missing Number
	 * ************************************************
	 * Return the only number in the range [0, n] that
	 * is missing from given array
	 * 
	 * @param (int) nums: the array to be searched
	 * 
	 * @return (int) missingNumber: the number missing 
	 * from the range
	 **************************************************/
	private static int missingNumber(int[] nums) {
		int result = 0;
		String binary = "";
		
		if (nums.length == 0)
			return result;
		
		if (nums[0] == result) 
			result++;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (j != i && nums[j] == result)
					result++;
			}
		}
		
		return result;
		
	}

	/**************************************************
	 * 15. Reverse Bits
	 * ************************************************
	 * Reverse bits of a given 32 bits signed integer
	 * 
	 * @param (int) n: the given 32 bits signed integer
	 * 
	 * @return (int) reversedN: the reversed bits of
	 * 				 signed integer
	 **************************************************/
	private static String reverseBits(int n) {
		int copyInput = n, highestExponent = 0;
		String binary = "", reversedBinary = "";
		
		for (int i = 0; Math.pow(2, i) < n; i++)
			highestExponent = i;
		
		//System.out.println(highestExponent);
		
		for (int i = 0; i <= highestExponent; i++) {
			if (copyInput - Math.pow(2, highestExponent - i) >= 1.0) {
				copyInput -= Math.pow(2, highestExponent - i);
				binary += "1";
			} else if (copyInput - Math.pow(2, highestExponent - i) == 0) {
				copyInput = 0;
				binary += "1";
			} else {
				binary += "0";
			}
				
		}
		
		for (int i = 0; i < binary.length(); i++)
			reversedBinary += binary.charAt(binary.length() - 1 - i);
		
		
		return reversedBinary;
		
	}
	
	/**************************************************
	 * 16. Climbing Stairs
	 * ************************************************
	 * You can either climb 1 or 2 steps, how many 
	 * distinct ways can you climb to the top
	 * 
	 * @param (int) n: the last step to the top
	 * 
	 * @return (int) numClimbs: the distinct ways you
	 * 				 can climb to the top
	 **************************************************/
	private static int climbStairs(int n) {
		int numClimbs = 0;
		int steps = 0;
		
		if (n < 0) {
			return numClimbs;
		}
		
		if (n <= 2) {
			numClimbs = n;
			return numClimbs;
		}
		
		if (n != 2 && n % 2 == 0) {
			numClimbs = n + 1;
		} else {
			numClimbs = n / 2 + 2;
		}
				
		return numClimbs;
		
	}
	
	/**************************************************
	 * 17. Coin Change
	 * ************************************************
	 * Given an array of coins, return the fewest 
	 * number of coins you need to make up an amount
	 * coins: [1, 2, 5], amount: 8
	 * 
	 * @param (int[]) coins: the array of coins
	 * 
	 * @param (int) amount: the amount you to make
	 * 
	 * @return (int) fewestCoins: the fewest number of 
	 * 				 coins, or -1 if no combination
	 **************************************************/
	private static int coinChange(int[] coins, int amount) {
		int copyAmount = amount;
		int numCoins = 0;
		int minNumCoins = Integer.MAX_VALUE;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (copyAmount - coins[j] > 0) {
					copyAmount -= coins[j];
					numCoins++;
				}
				
				if (copyAmount - coins[j] == 0) {
					copyAmount = 0;
					numCoins++;
					break;
				}
			}
			
			if (copyAmount == 0) {
				if (numCoins < minNumCoins) {
					minNumCoins = numCoins;
					break;
				}
					
			}
			
		}
				
		return minNumCoins == 0 ? -1 : minNumCoins;
		
	}
	
	/**************************************************
	 * 18. Longest Increasing Subsequence
	 * ************************************************
	 * Return the longest strictly increasing 
	 * subsequence of an array
	 * 
	 * @param (int[]) nums: the array to be searched
	 *  
	 * @return (int) longestSequence: the longest
	 * 				 sequence in the array
	 **************************************************/
	private static int lengthOfLIS(int[] nums) {
		int sequence = 1;
		int longestSequence = 0;
		
		for (int i = 0; i < nums.length - 1; i++) {
	
			if (nums[i] < nums[i+1])
				sequence++;
			
			if (nums[i] > nums[i+1] && sequence > 1) {
				if (sequence > longestSequence)
					longestSequence = sequence;
				
				sequence = 1;
			}
		
			if (sequence > 1 && (sequence > longestSequence))
				longestSequence = sequence;
		}
				
		return longestSequence;
		
	}
	
	/**************************************************
	 * 19. Longest Common Subsequence
	 * ************************************************
	 * Given two strings, return the length of their
	 * longest common subsequence, or 0
	 * 
	 * @param (String) text1: the first String to be
	 * 				   searched
	 * 
	 * @param (String) text2: the second String to be
	 * 				   searched
	 *  
	 * @return (int) length: the length of the longest
	 * 				 common subsequence
	 **************************************************/
	private static int longestCommonSubsequence(String text1, String text2) {
		int sequence = 0, longestSequence = 0;
		
		int commonSubLength = (text1.length() < text2.length()) ? text1.length() : text2.length();
		
		for (int i = 0; i < commonSubLength - 1; i++) {
			if (text1.charAt(i) == text2.charAt(i)) {
				sequence++;
			}
			
			if (text1.charAt(i) != text2.charAt(i) && sequence > 0) {
				if (sequence > longestSequence)
					longestSequence = sequence;
				
				sequence = 1;
			}
		}
		
		if (sequence > 1 && (sequence > longestSequence))
			longestSequence = sequence;
				
		return longestSequence;
		
	}
	
	/**************************************************
	 * 20. Word Break
	 * ************************************************
	 * Given a String, and a dictionary of Strings, 
	 * return true is the String can be segmented into
	 * a space-separated sequence of one or more
	 * dictionary words
	 * 
	 * @param (String) str: the String to be compared
	 * 
	 * @param (List<String>) wordDict: the dictionary
	 * 						 to be searched
	 *  
	 * @return (int) length: the length of the longest
	 * 				 common subsequence
	 **************************************************/
	private static boolean wordBreak(String str, List<String> wordDict) {
		boolean canBeSegmented = false;
		for (String s : wordDict) {
			if (str == s)
				canBeSegmented = true;
		}
		
		return canBeSegmented;
		
	}
	
	/**************************************************
	 * 21. Combination Sum
	 * ************************************************
	 * Given a String, and a dictionary of Strings, 
	 * return true is the String can be segmented into
	 * a space-separated sequence of one or more
	 * dictionary words
	 * 
	 * @param (int[]) candidates: array of distinct
	 * 				  integers
	 * 
	 * @param (int) target: the number to be summed to
	 *  
	 * @return (List<List<Integer>>) uniqueCombinations: 
	 * 						the unique combination of
	 * 						candidates
	 **************************************************/
	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> uniqueCombinations = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < candidates.length - 2; i++)
			for (int j = i + 1; j < candidates.length - 1; j++)
				for (int k = i + 2; k < candidates.length; k++) 
					if (candidates[i] + candidates[j] + candidates[k] == target) {
						List<Integer> combination = new ArrayList<Integer>();
						combination.add(candidates[i]);
						combination.add(candidates[j]);
						combination.add(candidates[k]);
						uniqueCombinations.add(combination);
					}
		
		for (int i = 0; i < candidates.length - 1; i++)
			for (int j = i + 1; j < candidates.length; j++)
				if (candidates[i] + candidates[j] == target) {
					List<Integer> combination = new ArrayList<Integer>();
					combination.add(candidates[i]);
					combination.add(candidates[j]);
					uniqueCombinations.add(combination);
				}
		
		
		for (int i = 0; i < candidates.length; i++)
			if (candidates[i] == target) {
				List<Integer> combination = new ArrayList<Integer>();
				combination.add(candidates[i]);
				uniqueCombinations.add(combination);
			}
			
		return uniqueCombinations;
		
	}
	
	/**************************************************
	 * 22. House Robber
	 * ************************************************
	 * Given an array, return the maximum amount of
	 * money you can rob tonight without alerting
	 * the police
	 * 
	 * @param (int[]) nums: 
	 *  
	 * @return (int) moneyRobbed: the maximum amount of
	 * 				 money robbed
	 **************************************************/
	private static int rob(int[] nums) {
		int poolA = 0, poolB = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0 || i == 0) {
				poolA += nums[i];
			} else {
				poolB += nums[i];
			}
		}
		
		if (poolA > poolB)
			return poolA;
		else
			return poolB;
		
	}
	
	/**************************************************
	 * 23. House Robber II
	 * ************************************************
	 * Given an array, return the maximum amount of
	 * money you can rob tonight without alerting
	 * the police
	 * 
	 * @param (int[]) nums: 
	 *  
	 * @return (int) moneyRobbed: the maximum amount of
	 * 				 money robbed
	 **************************************************/
	private static int robII(int[] nums) {
		int poolA = 0, poolB = 0; 
		//[2, 3, 2, 3, 5]
		for (int i = 0, traversed = 0; traversed < nums.length; traversed++) {
			if (nums.length % 2 == 0) {
				if (i % 2 == 0 || i == 0) {
					poolA += nums[i];
					i += 1;
				} else {
					poolB += nums[i];
					i += 1;
				}
			}
			
			if (nums.length % 2 == 1) {
				System.out.println(poolA);
				if (i % 2 == 0 || i == 0) {
					if (i != nums.length - 1) {
						poolA += nums[i];
						i += 2;
					} else {
						i = 1;
					}
				} else {
					poolB += nums[i];
					i += 2;
				}
			}
			
			if (i > nums.length)
				i = (i - 1) % nums.length;
		}
		
		if (poolA > poolB)
			return poolA;
		else
			return poolB;
		
	}
	
	/**************************************************
	 * 24. Decode Ways
	 * ************************************************
	 * Given a String s containing only digits, return
	 * the number of ways to decode it
	 * 
	 * @param (String) s: the String to be searched
	 *  
	 * @return (int) decodes: the number of ways to 
	 * 				 decode the String
	 **************************************************/
	private static int numDecodings(String s) {
		int decodes = 0;
		int linked = 0;

		int i = 0;
		for (int j = i; j < s.length(); j++) {
			if (Integer.parseInt(s.substring(j, j+1)) == 0) {
				decodes = -1;
			}
			
			if (decodes == -1) {
				if (Integer.parseInt(s.substring(j, j+1)) != 0) {
					i = j;
					break;
				}
			}
		}
		
		if (decodes == 0) 
			i = 0;
		
		for (int j = i; j < s.length() - 1; j++) {
			if ((Integer.parseInt(s.substring(j, j+1)) > 0 && Integer.parseInt(s.substring(j, j+1)) < 3) && Integer.parseInt(s.substring(i+1, i+2)) < 7) {
				linked += 1;
			} else if (Integer.parseInt(s.substring(j, j+1)) >= 0) {
				decodes += 1;
			}
		}
		
		if (s.length() % 2 == 1) {
			decodes += linked * 2 - 1;
		} else
			decodes += linked * 2;
		
		return decodes;
		
	}
	
	/**************************************************
	 * 25. Unique Paths
	 * ************************************************
	 * Given two integers, return the number of possible
	 * unique paths that the robot can take to reach
	 * the bottom-right corner. Can only move right or
	 * down
	 * 
	 * @param (int) m: one axis of the grid
	 * 
	 * @param (int) n: the second axis of the grid
	 *  
	 * @return (int) uniquePaths: the number of ways to 
	 * 				 reach the bottom-right corner
	 **************************************************/
	private static int uniquePaths(int m , int n) {
		int uniquePaths = 0;
		int copyM = m, copyN = n;
		
		int lastIndex = (m < n) ? m : n;
		
		for (int i = 0; i < lastIndex; i++) {
			if (i == 0)
				copyM++;
			
			copyM -= 1;
			copyN -= 1;
			
			if (!(copyM == 1 || copyN == 1))
				uniquePaths += (copyM) * (copyN);
		}
		
		return uniquePaths;
		
	}
	
	/**************************************************
	 * 26. Jump Game
	 * ************************************************
	 * Return true if you can treach the last index of 
	 * an array, false otherwise
	 * 
	 * @param (int[]) nums: the array to be searched
	 *  
	 * @return (boolean) canReachLastIndex: whether or
	 * 					 not you can reach the last
	 * 					 index
	 **************************************************/
	private static boolean canJump(int[] nums) {
		boolean canReachLastIndex = false;
		
		for (int i = 0; i < nums.length - 1; i = i) {
			if (i + nums[i] > nums.length - 1)
				canReachLastIndex = false;
			
			if (i + nums[i] == nums.length - 1)
				canReachLastIndex = true;
			
			i += nums[i];

		}
		
		return canReachLastIndex;
		
	}
	
	/**************************************************
	 * 27. Clone Graph
	 * ************************************************
	 * Return a deep copy of a connected undirected
	 * graph
	 * 
	 * @param (Node) node: the graph to be cloned
	 *  
	 * @return (Node) clonedNode: a deep copy of the
	 * 				  graph
	 **************************************************/
	/*// make Node class implement the Cloneable interface
	 * //create a constructor that takes in an object 
	 *   of the class
	 * private static Node cloneGraph(Node node) {
	 *    //Node clonedNode = new Node(node);
	 *    
	 * // make copy of obj properties in new obj
	 *    Node clonedNode = new Node();
	 *    clonedNode.val = node.val;
	 *    clonedNode.neighbors = node.neighbors;
	 *    
	 *    return clonedNode;
	 * }
	 */
		
	/**************************************************
	 * 28. Course Schedule
	 * ************************************************
	 * Return true if you can finish all courses, false
	 * otherwise
	 * 
	 * @param (int) numCourses: the number of courses
	 * 
	 * @param (int[][]) prerequisites: the courses to be
	 * 					completed first
	 *  
	 * @return (boolean) canComplete: whether or not you
	 * 					 can complete all the courses
	 **************************************************/
	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean canComplete = false;
		int courses = 0;
		
		for (int i = 0; i < prerequisites.length; i++) {
			if (prerequisites[i][0] > prerequisites[i][1])
				courses += 2;
			
			if (prerequisites[i][0] <= prerequisites[i][1])
				canComplete = false;
		}
		
		if (courses == numCourses)
			canComplete = true;
		
		return canComplete;
		
	}
	
	/**************************************************
	 * 29. Pacific Atlantic Water Flow
	 * ************************************************
	 * Return a 2D list of grid coordinates where 
	 * a coordinate denotes that rain water can flow
	 * from the cell to both the Pacific and Atlantic
	 * oceans
	 * 
	 * @param (int[][]) heights: the courses to be
	 * 					completed first
	 *  
	 * @return (List<List<Integer>>) canComplete: whether or not you
	 * 					 can complete all the courses
	 **************************************************/
	private static List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		boolean northFlow = false;
		
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[i].length; j++) {
				for (int north = 1; north < heights[i].length; north++) {
					if (i > 0) {
						if (heights[i-north][j] < heights[i][j]) {
							northFlow = true;
							//List<Integer> coordinate = new ArrayList<Integer>();
							//coordinate.add(heights[i][j]);
						}
							
					}
				}
			}
		}
		
		return output;
		
	}
	
	/**************************************************
	 * 30. Number of Islands
	 * ************************************************
	 * Return the number of islands in a binary grid
	 * 
	 * @param (int[][]) grid: the map which represents
	 * 					the islands 1s and water 0s
	 *  
	 * @return (int) nIslands: the number of islands
	 **************************************************/
	private static int numIslands(int[][] grid) {
		int nIslands = 0;
		boolean hasNorth = false;
		boolean hasEast = false;
		boolean hasWest = false;
		boolean hasSouth = false;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					if (i - 1 >= 0) {
						if (!(hasNorth || hasEast || hasWest || hasSouth))
							if (grid[i-1][j] == 1)
								hasNorth = true;
					}
					
					if (i + 1 < grid.length) {
						
					}
					
					if (j - 1 >= 0) {
						
					}
					
					if (hasNorth || hasSouth || hasEast || hasWest)
						nIslands++;
				}
			}
		}
		
		return nIslands;
		
	}
	
	/**************************************************
	 * 31. Longest Consecutive Sequence
	 * ************************************************
	 * Given an unsorted array, return the length of the
	 * largest consecutive elements sequence
	 * 
	 * @param (int[]) nums: array to be searched
	 *  
	 * @return (int) sequence: the largest sequence
	 **************************************************/
	private static int longestConsecutive(int[] nums) {
		int sequence = 0, maxSequence = 0;
		
		int[] sortedNums = nums;
		Arrays.sort(sortedNums);

		for (int i = 0; i < sortedNums.length - 1; i++) {
			if (sortedNums[i+1] - sortedNums[i] == 1) {
				sequence++;
			}  else {
				if (sequence > maxSequence)
					maxSequence = sequence + 1;
				
				sequence = 0;
			}
			
		}
		
		if (sequence > maxSequence)
			maxSequence = sequence + 1;
		
		return maxSequence;
		
	}
	
	/**************************************************
	 * 32. Alien Dictionary
	 * ************************************************
	 * Return a String of unique letters in the new
	 * alien language sorted in lexicographically 
	 * increasing order
	 * 
	 * @param (String[]) words: sorted lexicographical
	 * alien language
	 *  
	 * @return (String) uniqueLetters: the String of 
	 * 					unique letters
	 **************************************************/
	private static String alienOrder(String[] words) {
		String uniqueLetters = "";
		int[] indegree = new int[26];
		//Map<Character, Set<Character>> g = new HashMap<>();
		// buildGraph();
		//uniqueLetters = bfs(g, indegree);
		return uniqueLetters;
		
	}
	
	/**************************************************
	 * 33. Graph Valid Tree
	 * ************************************************
	 * Return whether the edges of a given graph make 
	 * up a valid tree, false otherwise
	 * 
	 * @param (int) n: number of nodes
	 * 
	 * @param (List<List<Integer>>) edges: the graph 
	 * to be searched
	 *  
	 * @return (boolean) isValidTree: whether the tree
	 * 					 is valid or not
	 **************************************************/
	private static boolean validTree(List<List<Integer>> edges, int n) {
		boolean isValidTree = false;
		
		// left binary search to determine roots and children
		
		return isValidTree;
		
	}
	
	/**************************************************
	 * 34. Number of Connected Components in an 
	 *     Undirected Graph
	 * ************************************************
	 * Return number of connected components in the
	 * graph
	 * 
	 * @param (int) n: number of nodes
	 * 
	 * @param (List<List<Integer>>) edges: the graph 
	 * to be searched
	 *  
	 * @return (int) connectedComponents: the number of
	 * 				 connected components
	 **************************************************/
	private static int countComponents(List<List<Integer>> edges, int n) {
		int connectedComponents = 0;
		
		// create binary trees to map edges
		// count trees
		
		return connectedComponents;
		
	}
	
	/**************************************************
	 * 35. Insert Interval
	 * ************************************************
	 * Return number of connected components in the
	 * graph
	 * 
	 * @param (int[][]) intervals: array of intervals
	 * 
	 * @param (int[]) newInterval: the array to be 
	 * 				  inserted
	 *  
	 * @return (int[][]) returnedIntervals: intervals
	 * 					 after the insert
	 **************************************************/
	private static int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] merged = new int[intervals.length + 1][];
		int c = 0;
		
		for (int[] i : intervals) {
			merged[c++] = i;
		}
		
		merged[intervals.length] = newInterval;
		//Arrays.sort(merged, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> l1 = new ArrayList<int[]>();
		
		for (int[] arr : merged) {
			if (l1.size() == 0)
				l1.add(arr);
			else {
				int[] prevArr = l1.get(l1.size() - 1);
				if (arr[0] <= prevArr[1]) {
					prevArr[1] = Math.max(prevArr[1], arr[1]);
				} else
					l1.add(arr);
			}
		}
		
		return l1.toArray(new int[l1.size()][]);
		
	}
	
	/**************************************************
	 * 36. Merge Intervals
	 * ************************************************
	 * Return an array of the non-overlapping intervals
	 * that cover all the intervals in the given array
	 * 
	 * @param (int[][]) intervals: array of intervals
	 *  
	 * @return (int[][]) mergedIntervals: intervals
	 * 					 after the insert
	 **************************************************/
	private static int[][] merge(int[][] intervals) {
		int[][] mergedIntervals;
		
		Arrays.sort(intervals);
		List<int[]> list = new ArrayList<int[]>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		for (int i = 1; i < intervals.length; i++) {
			if (end >= intervals[i][0]) {
				if (end < intervals[i][1]) {
					end = intervals[i][1];
				}
				
				continue;
			}
			
			list.add(new int[] {start, end});
			start = intervals[i][0];
			end = intervals[i][1];
		}
		
		list.add(new int[] {start, end});
		
		mergedIntervals = new int[list.size()][2];
		
		int j = 0;
		
		for (int[] i : list) {
			mergedIntervals[j][0] = i[0];
			mergedIntervals[j][1] = i[1];
		}
		
		return mergedIntervals;
		
	}
	
	/**************************************************
	 * 37. Non-overlapping Intervals
	 * ************************************************
	 * Return the minimum number of intervals you need
	 * top remove to make the rest of the intervals
	 * non-overlapping
	 * 
	 * @param (int[][]) intervals: array of intervals
	 *  
	 * @return (int) erasedOverlapsIntervals: intervals
	 * 					 after the insert
	 **************************************************/
	private static int eraseOverlapIntervals(int[][] intervals) {
		int erasedOverlappedIntervals = 0, prev = 0, count = 1;;
		
		Arrays.sort(intervals);
		
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= intervals[prev][1]) {
				prev = 1;
				count++;
			}
		}

		erasedOverlappedIntervals = intervals.length - count;
		
		return erasedOverlappedIntervals;
		
	}
	
	/**************************************************
	 * 38. Meeting Rooms
	 * ************************************************
	 * Determine if a person could attend all meetings
	 * in given array of meeting time intervals
	 * 
	 * @param (int[][]) intervals: array of intervals
	 *  
	 * @return (boolean) canAttendAll: whether a person
	 * 					 could attend all meetings
	 **************************************************/
	private static boolean canAttendMeetings(int[][] intervals) {
		boolean canAttendAll = false;
		
		if (intervals.length == 0)
			canAttendAll = true;
		
		Arrays.sort(intervals);
		
		try {
			List<int[]> meeting1 = new ArrayList<int[]>();
			List<int[]> meeting2 = new ArrayList<int[]>();
			
			for (int i = 0; i < intervals.length - 1; i++) {
				meeting1.add(intervals[i]);
				meeting2.add(intervals[i+1]);
				
				if (meeting1.get(i)[1] > meeting2.get(i)[0])
					canAttendAll = false;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return canAttendAll;
		
	}
	
	/**************************************************
	 * 39. Meeting Rooms II
	 * ************************************************
	 * Return the minimum number of conference rooms
	 * required given an array of meeting time intervals
	 * 
	 * @param (int[][]) intervals: array of intervals
	 *  
	 * @return (int) minRooms: the minimum number of 
	 * 				 conference rooms required
	 **************************************************/
	private static int minMeetingRooms(int[][] intervals) {
		int minRooms = 0;
		
		if (intervals.length == 0)
			minRooms = 0;
		
		Arrays.sort(intervals);
		
		try {
			List<int[]> conferences = new ArrayList<int[]>();
			List<int[]> cur = new ArrayList<int[]>();
			
			conferences.add(intervals[0]);
			
			for (int i = 1; i < intervals.length; i++) {
				cur.add(intervals[i]);
				if (conferences.get(0)[0] <= cur.get(i)[0]) {
					conferences.remove(0);
				}
				conferences.add(cur.get(0));
			}
			
			minRooms = conferences.size();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return minRooms;
		
	}
	
	/**************************************************
	 * 40. Reverse Linked List
	 * ************************************************
	 * Reverse the list, and return the reversed list
	 * 
	 * @param (ListNode) head: the head of the singly
	 * 					 linked list
	 *  
	 * @return (ListNode) reversed: the reversed linked
	 * 					  list
	 **************************************************/
/*	public ListNode reverseList(ListNode head) {
 * 		Node reversed = new Node();
 * 
 * 		try {
 * 			Node temp = new Node();
 * 
 * 			while (head) {
 * 				temp = head.next;
 * 				head.next() = reversed;
 * 				reversed.next = head;
 * 				head = temp;
 * 			}
 * 
 * 		} catch (Exception e) {
 * 			System.err.println(e);
 * 		}
 * 		
 * 
 * 		return reversed;
 * 	}
 * 
 */
	
	/**************************************************
	 * 41. Linked List Cycle
	 * ************************************************
	 * Return true if a linked list has a cycle, false
	 * otherwise
	 * 
	 * @param (ListNode) head: the head of the singly
	 * 					 linked list
	 *  
	 * @return (boolean) hasCycle: whether the linked
	 * 					 list has a cycle
	 **************************************************/
/*	public static boolean hasCycle(ListNode head) {
 * 		boolean containsCycle = false;
 * 
 * 		try {
 * 			ListNode fast = new ListNode();
 * 			ListNode slow = new ListNode();
 * 
 * 			while (fast && fast.next()) {
 * 				fast = fast.next.next;
 * 				slow = fast.next;
 * 
 * 				if (fast == slow)
 * 					containsCycle = true;
 * 			}
 * 		} catch (Exception e) {
 * 			System.err.println(e);
 * 		}
 * 		
 * 		return containsCycle;
 * 	}
 * 
 */
	
	/**************************************************
	 * 42. Merge Two Sorted Lists
	 * ************************************************
	 * Return the head of the merged linked list
	 * 
	 * @param (ListNode) list1: the first linked list
	 * 
	 * @param (ListNode) list2: the second linked list
	 *  
	 * @return (ListNode) merged: the merged linked list
	 **************************************************/
   /*	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	* 		ListNode merged = new ListNode();
	* 
	* 		try {
	* 			ListNode cur = new ListNode();
	* 
	* 			while (list1 and list2) {
	* 				if (list1.val > list2.val) {
	* 					cur.next = list2;
	* 					list2 = list2.next;
	* 				} else {
	* 					cur.next() = list1;
	* 					list1 = list1.next;
	* 				}
	* 
	* 				cur = cur.next();
	* 			}
	* 
	* 			if (list1)
	* 				cur.next() = list1;
	* 			else
	* 				cur.next() = list2;
	* 		} catch (Exception e) {
	* 			System.err.println(e);
	* 		}
	* 		
	* 		merged = cur;
	* 		return merged;
	* 
	* 	}
	* 
	*/

	
	/**************************************************
	 * 43. Merge K Sorted Lists
	 * ************************************************
	 * Merge all linked-lists into one sorted
	 * linked-list
	 * 
	 * @param (ListNode[]) lists: the list of linked
	 * 					   lists
	 *  
	 * @return (ListNode) merged: the merged linked lists
	 **************************************************/
   /*	public static ListNode mergeKLists(ListNode[] lists) {
	* 		ListNode merged = new ListNode();
	* 
	* 		try {
	* 			HashMap<Integer, Integer> map = new HashMap<>();
	* 			PriorityQueue<Integer> pq = new PriorityQueue<>();
	* 
	* 			for (ListNode head : lists) {
	* 				while (head != null) {
	* 					pq.add(head.val);
	* 					map.put(head.val, map.getOrDefault(head.val, 0) + 1);
	* 					head = head.next;
	* 				}
	* 			}
	* 
	* 			ListNode cur = new ListNode();
	* 			int val = 0;
	* 
	* 			while (!pq.isEmpty()) {
	* 				val = pq.poll();
	* 				ListNode newNode = new ListNode(val);
	* 				cur.next = newNode;
	* 				cur = cur.next;	
	* 
	* 				Integer count = map.get(val);
	* 
	* 				if (count != null && count > 0) {
	* 					map.put(val, count - 1);
	* 				} else {
	* 					map.remove(val);
	* 				}	
	* 			}
	* 		} catch (Exception e) {
	* 			System.err.println(e);
	* 		}
	* 		
	* 		merged = cur;
	* 		return merged;
	* 	}
	* 
	*/
	
	/**************************************************
	 * 44. Remove Nth Node from End of List
	 * ************************************************
	 * Remove the nth node from the end of the list and
	 * return its head
	 * 
	 * @param (ListNode) head: the head of the singly
	 * 					 linked list
	 * 
	 * @param (n) head: the nth node from the end of the
	 * 			  list
	 *  
	 * @return (boolean) hasCycle: whether the linked
	 * 					 list has a cycle
	 **************************************************/
   /*	public static ListNode removeNthFromEnd(ListNode head, int n) {
	* 		ListNode resultNode = new ListNode(0, head);
	* 		ListNode copyHead = head;
	* 
	* 		try {
	* 			ListNode dummyNode = resultNode;
	* 
	* 			for (int i = 0; i < n; i++)
	* 				copyHead = copyHead.next;
	* 
	* 			while (copyHead) {
	* 				copyHead = copyHead.next;
	* 				dummyNode = dummyNode.next;
	* 			}
	* 
	* 			dummyNode.next = deummyNode.next.next;
	* 			resultNode = dummyNode;
	* 		}
	* 
	* 		} catch (Exception e) {
	* 			System.err.println(e);
	* 		}
	* 		
	* 		return resultNode.next;
	* 	}
	* 
	*/
	
	/**************************************************
	 * 45. Reorder List
	 * ************************************************
	 * Reorder a singly linked-list to fit the pattern
	 * 
	 * @param (ListNode) head: the head of the singly
	 * 					 linked list
	 *  
	 * @return (void) _: the reordered linked list
	 **************************************************/
   /*	public static void reorderList(ListNode head) {
	* 		try {
	* 			ListNode fast = head;
	* 			ListNode slow = head;
	* 
	* 			while (fast != null && fast.next != null) {
	* 				slow = slow.next;
	* 				fast = fast.next.next;
	* 			}
	* 
	* 			ListNode prev = null;
	* 			ListNode next = null;
	* 
	* 			while (slow != null) {
	* 				next = slow.next;
	* 				slow.next = prev;
	* 				prev = slow;
	* 				slow = next;
	* 			}
	* 
	* 			ListNode firsthf = head;
	* 			ListNode secondhf = prev;
	* 
	* 			while (secondhf.next != null) {
	* 				next = firsthf.next;
	* 				prev = secondhf.next;
	* 				
	* 				firsthf.next = secondhf;
	* 				secondhf.next = next;
	* 
	* 				firsthf = next;
	* 				secondhf = prev;
	* 			}
	* 		} catch (Exception e) {
	* 			System.err.println(e);
	* 		}
	* 
	* 	}
	* 
	*/
	
	/**************************************************
	 * 46. Set Matrix Zeroes
	 * ************************************************
	 * If an element is 0, set entire row and column
	 * to 0s
	 * 
	 * @param (int[][]) matrix: the matrix to be searched
	 *  
	 * @return (void) _: the matrix with zeroes set
	 **************************************************/
	public static void setZeroes(int[][] matrix) {
		boolean rowZero = false;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					if (i > 0)
						matrix[i][0] = 0;
					else
						rowZero = true;
				} else {
					rowZero = false;
				}
			}
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if (matrix[0][0] == 0)
			for (int i = 1; i < matrix.length; i++)
				matrix[i][0] = 0;
		
		if (rowZero)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 0;
	
	}
	
	/**************************************************
	 * 47. Spiral Matrix
	 * ************************************************
	 * Return all elements of the matrix in spiral order
	 * 
	 * @param (int[][]) matrix: the matrix to be searched
	 *  
	 * @return (List<Integer>) spiralMatrix: the matrix 
	 * 						   in spiral order
	 **************************************************/
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (matrix.length == 0)
			return result;
		
		int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
		
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			
			for (int i = colBegin; i <= rowEnd; i++) {
				result.add(matrix[rowBegin][i]);
			}
			
			rowBegin++;
			
			for (int i = rowBegin; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			
			colEnd--;
			
			if (rowBegin <= rowEnd) {
				for (int i = colEnd; i >= colBegin; i--) {
					result.add(matrix[rowEnd][i]);
				}
			}
			
			rowEnd--;
			
			if (colBegin <= colEnd) {
				for (int i = rowEnd; i>= rowBegin; i--) {
					result.add(matrix[i][colBegin]);
				}
			}
			
			colBegin++;
		}
		
		return result;
		
	}
	
	/**************************************************
	 * 48. Rotate Image
	 * ************************************************
	 * Rotate the image by 90 degrees, clockwise
	 * 
	 * @param (int[][]) matrix: the matrix to be searched
	 *  
	 * @return (void) _: the rotated matrix
	 **************************************************/
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		
		for (int i = 0; i < ((n + 1) / 2); i++) { 
			for (int j = 0; j < (n / 2); j++) {
				
				// temp = bottom left
				int temp = matrix[n - 1 - j][i];
				
				// bottom left = bottom right
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				
				// bottom right = top right
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				
				// top right = top left
				matrix[j][n - 1 - i] = matrix[i][j];
				
				// top left = temp [bottom left]
				matrix[i][j] = temp;
			}
		}
		
	}
	
	/**************************************************
	 * 49. Word Search
	 * ************************************************
	 * Return true if a word exists in the board
	 * 
	 * @param (char[][]) board: the matrix to be searched
	 * 
	 * @param (String) word: the word to be found
	 *  
	 * @return (boolean) containsWord: whether or not 
	 * 					 the word is on the board
	 **************************************************/
	public static boolean exist(char[][] board, String word) {
		boolean containsWord = false;
		
		int m = board.length;
		int n = board[0].length;
		
		//boolean[][] visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					// containsWord = backtrack(board, word, visited, i, j, 0);
					//if (containsWord) {
					//	containsWord = true;
					//} else {
					//	containsWord = false;
					//}
				}
			}
		}
		
		return containsWord;
	}
	
	/**************************************************
	 * 50. Longest Substring Without Repeating 
	 * 	   Characters
	 * ************************************************
	 * Find the longest substring without repeating 
	 * characters
	 * 
	 * @param (String) s: the string to be searched
	 *  
	 * @return (int) longestSubstring: the longest substring
	 **************************************************/
	public static int lengthOfLongestSubstring(String s) {
		int longestSubstring = 0;
		
		int a_pointer = 0;
		int b_pointer = 0;
		
		HashSet<Character> hashSet = new HashSet();
		
		while(b_pointer < s.length()) {
			if(!hashSet.contains(s.charAt(b_pointer))) {
				hashSet.add(s.charAt(b_pointer));
				b_pointer++;
				longestSubstring = Math.max(hashSet.size(), longestSubstring);
			} else {
				hashSet.remove(s.charAt(a_pointer));
				a_pointer++;
			}
		}
		
		return longestSubstring;
		
	}
	
	/**************************************************
	 * 51. Longest Repeating Character Replacement
	 * ************************************************
	 * Return the length of the longest substring 
	 * containing the same letter you can get after 
	 * performing operations
	 * 
	 * @param (String) s: the String to be searched
	 * 
	 * @param (int) k: the number of times to perform 
	 * 				the operation
	 *  
	 * @return (int) longestSubstring: the longest substring
	 **************************************************/
	public static int characterReplacement(String s, int k) {
		int longestSubstring = 0;
		
		int n = s.length();int[] charCounts = new int[26];
		
		int windowStart = 0, maxCount = 0;
		
		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			charCounts[s.charAt(windowStart) - 'A']--;
			int currCharCount = charCounts[s.charAt(windowEnd) - 'A'];
			maxCount = Math.max(maxCount,  currCharCount);
			
			while (windowEnd - windowStart - maxCount + 1 > k) {
				charCounts[s.charAt(windowStart) - 'A']--;
				windowStart++;
			}
			
			longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
		}
		
		return longestSubstring;
	}
	
	/**************************************************
	 * 52. Minimum Window Substring
	 * ************************************************
	 * Return the minimum window substring of a string
	 * where every character is included in the window
	 * 
	 * @param (String) s: the String window of length m
	 * 
	 * @param (String) t: the characters to search for 
	 * 				   in the window
	 *  
	 * @return (String) minWindowSubstring: the minimum
	 *  				window substring
	 **************************************************/
	public static String minWindow(String s, String t) {
		String minWindowSubstring = "";

		if (s == null || s.isEmpty() || t == null || t.isEmpty())
			return minWindowSubstring;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			map.put(c,  map.getOrDefault(c, 0) + 1);
		}
		
		int i = 0, j = 0, count = map.size();
		int left = 0, right = s.length() - 1, min = s.length();
		
		boolean found = false;
		
		while (j < s.length()) {
			char endChar = s.charAt(j++);
			if (map.containsKey(endChar)) {
				map.put(endChar,  map.get(endChar) - 1);
				if (map.get(endChar) == 0)
					count -= 1;
			}
			
			if (count > 0) continue;
			
			while (count == 0) {
				char startChar = s.charAt(i++);
				if (map.containsKey(startChar)) {
					map.put(startChar,  map.get(startChar) + 1);
					if (map.get(startChar) > 0)
						count += 1;
				}
			}
			
			if ((j - 1) < min) {
				left = i;
				right = j;
				min = j - i;
				
				found = true;
			}			
		}
		
		if (!found) {
			minWindowSubstring = "";
		} else {
			minWindowSubstring = s.substring(left - 1, right);;
		}
		
		return minWindowSubstring;
		
	}
	
	/**************************************************
	 * 53. Valid Anagram
	 * ************************************************
	 * Return whether a string is an anagram of another
	 * string
	 * 
	 * @param (String) s: the String to be searched
	 * 
	 * @param (String) t: the String to be compared
	 *  
	 * @return (boolean) isAnAnagram: whether or not 
	 * 					 there is an anagram
	 **************************************************/
	public static boolean isAnagram(String s, String t) {
		boolean isAnAnagram = true;
		
		if (s.length() != t.length())
			isAnAnagram = false;
		
		int[] charCounts = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			charCounts[s.charAt(i) - 'a']++;
			charCounts[t.charAt(i) - 'a']--;
		}
		
		for (int count : charCounts) {
			if (count != 0)
				isAnAnagram = false;
		}

		return isAnAnagram;
		
	}
	
	/**************************************************
	 * 54. Group Anagrams
	 * ************************************************
	 * Return the length of the longest substring 
	 * containing the same letter you can get after 
	 * performing operations
	 * 
	 * @param (String[]) strs: the array of Strings to 
	 * 					 be searched
	 *  
	 * @return (List<List<String>>) groupedAnagrams: the 
	 * 				grouped anagrams
	 **************************************************/
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String curr : strs) {
			char[] characters = curr.toCharArray();
			Arrays.sort(characters);
			String sorted = new String(characters);
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<String>());
			}
			
			map.get(sorted).add(curr);
		}
		
		groupedAnagrams.addAll(map.values());
		
		return groupedAnagrams;
		
	}
	
	/**************************************************
	 * 55. Valid Parentheses
	 * ************************************************
	 * Determine if the input String is valid
	 * - open brackets must be closed by same bracket
	 *   type
	 * - open brackets must be closed in the correct 
	 *   order
	 * - every bracket has a corresponding open bracket
	 *  of the same type
	 *  
	 * @param (String) s: the String to be searched
	 *  
	 * @return (boolean) isValidString: whether the 
	 * 					 string is valid
	 **************************************************/
	public static boolean isValid(String s) {
		boolean isValidString = false;
		
		if (s.length() % 2 != 0)
			return isValidString;
		
		Stack<Character> stack = new Stack();
		
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}
		}
		
		isValidString = stack.isEmpty();
		
		return isValidString;
		
	}
	
	/**************************************************
	 * 56. Valid Palindrome
	 * ************************************************
	 * Return true is the string is a valid palindrome
	 * 
	 * @param (String) s: the String to be searched
	 *  
	 * @return (boolean) isValid: whether the String 
	 * 					 is a Palindrome
	 **************************************************/
	public static boolean isPalindrome(String s) {
		boolean isValid = true;
		
		String fixedString = "";
		
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c) || Character.isLetter(c)) {
				fixedString += c;
			}
		}
		
		fixedString = fixedString.toLowerCase();
		
		int a_pointer = 0;
		int b_pointer = fixedString.length() - 1;
		
		while (a_pointer <= b_pointer) {
			if (fixedString.charAt(a_pointer) != fixedString.charAt(b_pointer)) {
				isValid = false;
			}
			
			a_pointer += 1;
			b_pointer -= 1;
		}
		
		return isValid;
	}
	
	/**************************************************
	 * 57. Longest Palindromic Substring
	 * ************************************************
	 * Return the longest palindromaic substring in a 
	 * given String
	 * 
	 * @param (String) s: the String to be searched
	 *  
	 * @return (String) longestPalindrome: the longest 
	 * 					Palindrome in the String
	 **************************************************/
	public static String longestPalindrome(String s) {
		String longestPalindrome = "";
		
		if (s == null || s.length() < 1)
			return longestPalindrome;
		
		int start = 0, end = 0;
		int len1 = 0, len2 = 0, len = 0;
		for (int i = 0; i < s.length(); i++) {
			//len1 = expandFromMiddle(s, i , i);
			//len2 = expandFromMiddle(s, i, i+1);
			len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}
		}
		
		longestPalindrome = s.substring(start, end + 1);
		
		return longestPalindrome;
	}
	
	/**************************************************
	 * 58. Encode and Decode Strings
	 * ************************************************
	 * Encode and decode a list of strings that is sent
	 * over the network
	 * 
	 * @param (List<String) strs: the list of Strings to
	 * be encoded
	 * 
	 * @returned (String) encoded: the encoded list 
	 * 					  of Strings
	 * ************************************************
	 * @param (String) s: the encoded list of Strings
	 * 
	 * @return (List<String>) decoded: the decoded list
	 * 						  of Strings
	 **************************************************/
	public static String encode(List<String> strs) {
		String encoded = "";
		
		final char DELIMITER = '#';
		
		try {
			StringBuilder sb = new StringBuilder();
			
			for (String str : strs) {
				sb.append(str.length());
				sb.append(DELIMITER);
				sb.append(str);
			}
			
			encoded = sb.toString();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return encoded;
		
	}
	
	public static List<String> decode(String s) {
		List<String> decoded = new ArrayList<String>();
		
		final char DELIMITER = '#';
		
		char[] arr = s.toCharArray();
		
		int numOfChars = 0, end = 0;
		
		try {
			StringBuilder sb;
			
			for (int i = 0; i < arr.length; i++) {
				sb = new StringBuilder();
				
				while (arr[i] != DELIMITER) {
					sb.append(arr[i++]);
				}
				
				i++;
				
				numOfChars = Integer.valueOf(sb.toString());
				end = i + numOfChars;
				
				sb = new StringBuilder();
				
				while (i < end) {
					sb.append(arr[i++]);
				}
				
				decoded.add(sb.toString());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return decoded;
		
	}
	
	/**************************************************
	 * 59. Maximum Depth of Binary Tree
	 * ************************************************
	 * Return the maximum depth of the root of a given
	 * binary tree
	 * 
	 * @param (String) s: the String to be searched
	 * 
	 * @param (TreeNode) root: the root of a binary tree
	 *  
	 * @return (int) maximumDepth: the maximum depth of
	 * 				 the binary tree
	 **************************************************/
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return Math.max(left,  right) + 1;
	
	}
	
	/**************************************************
	 * 60. Same Tree
	 * ************************************************
	 * Given two binary tree roots, check if they are
	 * the same or not
	 * 
	 * @param (TreeNode) p: the first binary tree
	 * 
	 * @param (TreeNode) q: the second binary tree
	 *  
	 * @return (boolean) isSame: whether the trees are 
	 * 					 the same or not
	 **************************************************/
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		boolean isSame = false;
		
		if (p == null && q == null)
			return true;
		
		if (p == null || q == null)
			return false;
		
		if (p.val == q.val) {
			isSame = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
		return isSame;
		
	}
	
	/**************************************************
	 * 61. Invert Binary Tree
	 * ************************************************
	 * Given the root of a binary tree, invert the tree,
	 * and return its root
	 * 
	 * @param (TreeNode) root: the root of the given 
	 * 					 binary tree
	 *  
	 * @return (TreeNode) invertedTree: the inverted 
	 * 					  binary tree
	 **************************************************/
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.right = left;
		root.left = right;
		
		return root;
		
	}
	
	/**************************************************
	 * 62. Binary Tree Maximum Path Sum
	 * ************************************************
	 * Given the root of a binary tree, return the 
	 * maximum path sum of any non-empty path
	 * 
	 * @param (TreeNode) root: the root of the given 
	 * 					 binary tree
	 *  
	 * @return (int) maximumPathSum: maximum path sum of
	 * 				 the tree
	 **************************************************/
	public static int maxPathSum(TreeNode root) {
		int maximumPathSum = Integer.MIN_VALUE;
		
		//pathSum(root);
		
		return maximumPathSum;
		
	}
	
	/**************************************************
	 * 63. Binary Tree Level Order Traversal
	 * ************************************************
	 * Return the level order traversal of a tree's 
	 * values
	 * 
	 * @param (TreeNode) root: the root of the given 
	 * 					 binary tree
	 *  
	 * @return (List<List<Integer>>) traversalValues: 
	 * 				the level order traversal values 
	 **************************************************/
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> traversalValues = new ArrayList<List<Integer>>();
		
		if (root == null)
			return traversalValues;
		
		//traverse(root, 0);
		
		return traversalValues;
		
	}
	
	/**************************************************
	 * 64. Serialize and Deserialize Binary Tree
	 * ************************************************
	 * Serialize and deserialize a binary tree
	 * 
	 * @param (TreeNode) root: the root of the given 
	 * 					 binary tree
	 *  
	 * @return (String) serializedTree: the converted 
	 * 					tree
	 * ************************************************
	 * 
	 * @param (String) root: the serialized binary tree
	 *  
	 * @return (TreeNode) deserializedTree: the 
	 * 					  converted tree
	 **************************************************/
	final String X = "X";
	String[] arr;
	int index = 0;
	
	public String serialize(TreeNode root) {
		if (root == null)
			return X;
		String left = serialize(root.left);
		String right = serialize(root.right);
		
		return root.val + "," + left + "," + right;
		
	}
	
	public TreeNode deserialize(String data) {
		arr = data.split(",");
		// return dfs();
		return null;
		
	}
	
	/**************************************************
	 * 65. Subtree of Another Tree
	 * ************************************************
	 * Return whether there is a subtree of root with 
	 * the same structure and node values of subRoot, 
	 * false otherwise
	 * 
	 * @param (TreeNode) root: the root of the main 
	 * 					 binary tree
	 * 
	 * @param (TreeNode) subRoot: the root of the second
	 * 					 binary tree
	 *  
	 * @return (boolean) containsSubTree: whether the 
	 * 					 second tree is a subtree
	 **************************************************/
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		boolean containsSubTree = false;
		
		if (root == null) {
			return containsSubTree;
		}
		
		if (subRoot == null) {
			containsSubTree = true;
			return containsSubTree;
		}
		
		if (root.val == subRoot.val) {
			containsSubTree = (isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right));
		}
		
		return containsSubTree;
		
	}
	
	/**************************************************
	 * 66. Construct Binary Tree from Preorder and 
	 * 	   Inorder Traversal
	 * ************************************************
	 * Construct and return the binary tree from an 
	 * integer array of preorder, and integer array of
	 * inorder traversed values
	 * 
	 * @param (int[]) preorder: the preorder traversal
	 * 				  values
	 * 
	 * @param (int[]) inorder: the preorder traversal
	 * 				  values
	 *  
	 * @return (TreeNode) constructedTree: the 
	 * 					  constructed binary tree
	 **************************************************/
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode constructedTree = new TreeNode();
		
		// return helper(0, 0, inorder.length - 1, preorder, inorder);
		return constructedTree;
		
	}
	
	/**************************************************
	 * 67. Validate Binary Search Tree
	 * ************************************************
	 * Determine if a binary tree is a valid binary 
	 * search tree (BST)
	 * 
	 * @param (TreeNode) root: the root of the binary
	 * 					 tree
	 *  
	 * @return (boolean) isValid: whether the tree is a 
	 * 					 valid BST
	 **************************************************/
	public static boolean isValidBST(TreeNode root) {
		boolean isValid = true;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		double leftChildVal = - Double.MAX_VALUE;
		
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			
			if (root.val <= leftChildVal)
				return false;
			
			leftChildVal = root.val;
			root = root.right;
		}
		
		return isValid;
		
	}
	
	/**************************************************
	 * 68. Kth Smallest Element in a BST
	 * ************************************************
	 * Return the kth smallest value (1-indexed) of all
	 * all the values of the nodes in the tree
	 * 
	 * @param (TreeNode) root: the root of the binary
	 * 					 tree
	 * 
	 * @param (int) k: the targeted smallest value
	 *  
	 * @return (int) kthValue: the kth smallest value
	 **************************************************/
	public static int kthSmallest(TreeNode root, int k) {
		int kthValue = 0;
		
		int[] nums = new int[2];
		//inorder(root, nums, k);
		
		return kthValue;
		
	}
	
	/**************************************************
	 * 69. Lowest Common Ancestor of a Binary Search
	 *     Tree
	 * ************************************************
	 * Find the lowest common ancestor (LCA) node of two
	 * given nodes in the BST
	 * 
	 * @param (TreeNode) root: the root of the binary
	 * 					 tree
	 *
	 * @param (TreeNode) p: the first node selected
	 * 
	 * @param (TreeNode) q: the second node selected
	 *  
	 * @return (TreeNode) lcaNode: the LCA node
	 **************************************************/
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lcaNode = root;
		
		if ((p.val < lcaNode.val) && (q.val < lcaNode.val)) {
			return lowestCommonAncestor(lcaNode.left, p, q);
		}
	
		if ((p.val > lcaNode.val) && (q.val > lcaNode.val)) {
			return lowestCommonAncestor(lcaNode.right, p, q);
		}
		
		return lcaNode;
		
	}
	
	/**************************************************
	 * 70. Implement Trie (Prefix Tree)
	 * ************************************************
	 * Implement the Trie class
	 * - A tree data structure used to effeciently 
	 *   store and retrieve keys in a dataset of 
	 *   Strings
	 * 
	 * @param (Trie) _: initializes the object
	 *
	 * @param (void) insert(String word): inserts the
	 * 				 String [word] into the trie
	 * 
	 * @param (boolean) search(String word): returns true
	 * 					if the String [word] is in the trie
	 * 					[inserted before], false otherwise 
	 * 
	 * @param (boolean) startsWith(String prefix): returns
	 * 					true if there is a previously 
	 * 					inserted String [word] that has the
	 * 					prefix, false otherwise
	 **************************************************/
	/*
	public class Trie {
		class TrieNode {
			TrieNode[] children;
			boolean isWord;
			String word;
			
			public TrieNode() {
				children = new TrieNode[26];
				isWord = false;
				word = "";
			}
		}
		
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			try {
				TrieNode node = root;
			
				for (int i = 0; i < word.length(); i++) {
					int index = word.charAt(i) - 'a';
					
					if (node.children[index] == null) {
						node.children[index] = new TrieNode();
				}
				
				node = node.children[index];
				root = node;
			}
			
			node.isWord = true;
			
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		
		public boolean search(String word) {
			boolean containsWord = false;
			
			try {
				TrieNode node = root;
				
				for (int i = 0; i < word.length(); i++) {
					int index = word.charAt(i) - 'a';
					
					if (node.children[index] == null) 
						containsWord = false;
					
					node = node.children[index];
				}
				
				containsWord = node.isWord;
				
			} catch (Exception e) {
				System.err.println(e);
			}
			
			
			return containsWord;
		}
		
		public boolean startsWith(String prefix) {
			boolean startsWith = true;
			try {
				TrieNode node = root;
				
				for (int i = 0; i < prefix.length(); i++) {
					int index = prefix.charAt(i) - 'a';
					
					if (node.children[index] == null) 
						startsWith = false;
					
					node = node.children[index];
				}
				
			} catch (Exception e) {
				System.err.println(e);
			}
			
			return startsWith;
		}
	}
	*/
	
	/**************************************************
	 * 71. Design Add and Search Words Data Structure
	 * ************************************************
	 * Design a data structure that supports adding new
	 * words and finding if a String matches any 
	 * previously added String
	 * 
	 * @param (WordDictionary) _: initializes the object
	 *
	 * @param (void) addWord(String word): adds the String
	 * 				 [word] into the data structure
	 * 
	 * @param (boolean) search(String word): returns true
	 * 					if the String [word] is in the data
	 * 					structure, false otherwise
	 * 					- word can contain dots '.' where 
	 * 					  dots can be matched with any letter
	 * 
	 * @param (boolean) startsWith(String prefix): returns
	 * 					true if there is a previously 
	 * 					inserted String [word] that has the
	 * 					prefix, false otherwise
	 **************************************************/
	/*
	public class WordDictionary {
		
		class TrieNode {
			TrieNode[] children;
			boolean isWord;
			String word;
			
			public TrieNode() {
				children = new TrieNode[26];
				isWord = false;
				word = "";
			}
		}
		
		private TrieNode root;
		
		public WordDictionary() {
			root = new TrieNode();
		}
		
		public void addWord(String word) {
			TrieNode cur = root;
			
			for (char c : word.toCharArray()) {
				int index = (int) (c - 'a');
				
				if (cur.children[index] == null) {
					cur.children[index] = new TrieNode();
				}
				
				cur = cur.children[index];
			}
			
			cur.isWord = true;
		}
		
		public boolean search(String word) {
			//return find();
			
			return false;
		}
	}
	*/
	
	/**************************************************
	 * 72. Word Search II
	 * ************************************************
	 * Return all words on the board
	 * 
	 * @param (char[][]) board: the board to be searched
	 *
	 * @param (String[]) words: the list of words to find
	 * 
	 * @return (List<String>) foundWords: the list of 
	 * 						  found words
	 **************************************************/
	/*
	//TrieNode class
	//TrieNode trie = new TrieNode();
	static List<String> foundWords = new ArrayList<String>();
	static int m = 0, n = 0;
	static char[][] copyBoard;
	static boolean[][] visited;
	public static List<String> findWords(char[][] board, String[] words) {
		
		
		for (String word : words) {
			//insertAWord(word);
		}
		
		m = board.length;
		n = board[0].length;
		copyBoard = board;
		
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				char curChar = board[row][col];
				visited = new boolean[m][n];
				//dfs(row, col, new StringBuilder(), trie)
			}
		}
		
		return foundWords;
		
	}
	*/
	
	/**************************************************
	 * 73. Merge K Sorted Lists
	 * ************************************************
	 * Merge all linked-lists into one sorted linked-list
	 * 
	 * @param (ListNode[]) lists: array of linked-lists
	 *
	 * @return (ListNode) mergedLists: the merged 
	 * 					  linked-lists
	 **************************************************/
	/*
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode mergedLists = new ListNode();
		
		try {
			if (lists == null || lists.length == 0)
				return mergedLists;
			
			ListNode head = new ListNode(0);
			ListNode temp = head;
			
			while (true) {
				int p = 0;
				
				for (int i = 0; i < lists.length; i++) {
					if (lists[p] == null || (lists[i] != null && lists[p].val > lists[i].val)) {
						p = i;
					}
				}
				
				if (lists[p] == null) {
					break;
				}
				
				temp.next = lists[p];
				temp = temp.next;
				lists[p] = lists[p].next;
				
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return mergedLists;
		
	}
	*/
	
	/**************************************************
	 * 74. Top K Frequent Elements
	 * ************************************************
	 * Return the k most frequent elemtns of an integer 
	 * array. Can be returned in any order
	 * 
	 * @param (int[]) nums: the array to be searched
	 *
	 * @param (int) k: the minimum frequency to search
	 * 
	 * @return (int[]) mostFrequentElements: the k most
	 * 				   frequent elements
	 **************************************************/
	/*
	public static int[] topKFrequent(int[] nums, int k) {
		int[] mostFrequentElements;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		//PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
		
		for (map.Entry entry : map.entrySet()) {
			pq.add(entry);
		}
		
		mostFrequentElements = new int[k];
		
		for (int i = 0; i < k; i++) {
			mostFrequentElements[i] = pq.poll().getKey();
		}
		
		return mostFrequentElements;
		
	}
	*/
	
	/**************************************************
	 * 75. Find Median from Data Stream
	 * ************************************************
	 * Implement the MedianFinder class
	 * 
	 * @param (MedianFinder) _: initializes the object
	 *
	 * @param (void) addNum(int num): add tehs integer 
	 * 				 [num] from the data stream to the
	 * 				 data structure
	 * 
	 * @param (double) findMedian(): returns the median of
	 * 				   all elements so far
	 * 				   - answers within 10^-5 acceptable
	 **************************************************/
	/*
	class MedianFinder {
		
		PriorityQueue<Integer> minHeap;
		PriorityQueue<Integer> maxHeap;
		
		public MedianFinder() {
			minHeap = new PriorityQueue<Integer>();
			maxHeap = new PriorityQueue<Integer>();
		}
		
		public void addNum(int num) {
			if (maxHeap.isEmpty() || num < maxHeap.peek()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			
			if (maxHeap.size() == minHeap.size() + 2) {
				minHeap.add(maxHeap.poll());
			}
			
			if (minHeap.size() == maxHeap.size() + 1) {
				maxHeap.add(minHeap.poll());
			}
		}
		
		public double findMedian() {
			double median = 0.0;
			
			if (maxHeap.size() == minHeap.size()) {
				median = (maxHeap.peek() + minHeap.peek()) / 2.0;
			} else {
				median = maxHeap.peek();
			}
			
			return median;
		}
		
	}
	*/
}



