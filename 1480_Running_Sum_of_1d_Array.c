
int* runningSum(int* nums, int numsSize, int* returnSize)
{
	*returnSize = numsSize;
	int sum = 0;

	for (int i = 1; i < numsSize; i++)
		nums[i] += nums[i - 1];
	return (nums);
}
