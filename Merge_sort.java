package plus_3_15;

import java.util.Arrays;

public class Merge_sort {
	public static void main(String[] args) {
		int a[]= {3,6,1,7,9,4,5,8,2};
		mergesort(a);
		System.out.println("�����" + Arrays.toString(a));
	}
	
	private static void mergesort(int[] arr) {
        mergesort(arr, new int[arr.length], 0, arr.length - 1);
    }
	
	private static void mergesort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergesort(arr, temp, left, center); // ���
            mergesort(arr, temp, center + 1, right); // �ұ�
            merge(arr, temp, left, center + 1, right); // �ϲ���������
        }
	}
	
	private static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1; // ��߽����±�
        int tempPos = leftPos; // ����߿�ʼ��
        int numEle = rightEnd - leftPos + 1; // Ԫ�ظ���
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos])
                temp[tempPos++] = arr[leftPos++];
            else
                temp[tempPos++] = arr[rightPos++];
        }
        while (leftPos <= leftEnd) {  // ��������ʣ��
            temp[tempPos++] = arr[leftPos++];
        }
        while (rightPos <= rightEnd) { // �ұ������ʣ��
            temp[tempPos++] = arr[rightPos++];
        }
        // ��temp���Ƶ�arr
        for (int i = 0; i < numEle; i++) {
            arr[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
    }
	
}

