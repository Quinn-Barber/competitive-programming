class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[] = new int[n + m];
        int i, j;
        i = j = 0;

        for (int idx = 0; idx < (n + m); idx++) {
            if (n == 0) {
                arr[idx] = nums2[j];
                j++;
                continue;
            } else if (m == 0) {
                arr[idx] = nums1[i];
                i++;
                continue;
            } else if (i >= n) {
                arr[idx] = nums2[j];
                j++;
                continue;
            } else if (j >= m) {
                arr[idx] = nums1[i];
                i++;
                continue;
            } else if (nums2[j] < nums1[i]) {
                arr[idx] = nums2[j];
                j++;
                continue;
            } else {
                arr[idx] = nums1[i];
                i++;
                continue;
            }
        }

        if ((m + n) % 2 == 0) {
            double ret = (arr[(m + n) / 2] + arr[((m + n) / 2) - 1]) / 2.0;
            return ret;
        } else {
            double ret = arr[(m + n) / 2];
            return ret;
        }
    }
}