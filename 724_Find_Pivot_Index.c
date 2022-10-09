
int pivotIndex(int* nums, int numsSize)
{
	int	res;
	int	index;
	int	left_sum;
	int	right_sum;

	res = -1;
	index = 0;
	while (index < numsSize && res == -1)
	{
		left_sum = 0;
		right_sum = 0;

		for (int left = 0; left < index; left++)
			left_sum += nums[left];
		for (int right = index + 1; right < numsSize; right++)
			right_sum += nums[right];
		if (left_sum == right_sum)
			res = index;
		index += 1;
	}
	return (res);
}
