package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class onesum {
	public static void haha(int a[],int b[]) {
		
	}
	public static void main(String[] args) {
//		String[] newNums = Arrays.copyOf(nums, nums.length+1);
//		copyOf : �����µĳ��ȴ�����һ�������飬���������е�����copy��ȥ
//		Arrays.toString(nums)��ӡ����[a,b,c]
//		newNums[newNums.length-1] = "78";��ֵ��������[�±�]=ֵ
//		Arrays.copyOfRange(data, 2, 7);��ȡdata�����±��2������6��Ԫ��
		
		
		
//���ִ��
//		double x=0;
//		double[]num= {2,8,6,9,7,3,5,6,8,7};
//		Arrays.sort(num);
//		double[] newnum=Arrays.copyOfRange(num,1,num.length-1);
////		System.out.println(Arrays.toString(newnum));
//		for(int i=0;i<newnum.length;i++) {
//			x+=newnum[i];
//		}
//		double ave=(double)(x/newnum.length);
//		System.out.println(ave);
//		
		
		
//����������쳲���������ǰ10�����ĺ�
//������1 1 2 3 5 8 13 21 34 55 
//		int[] arr=new int[10];
//		arr[0]=arr[1]=1;
//		int sum=0;
//		for(int i=2;i<arr.length;i++) {
//			arr[i]=arr[i-1]+arr[i-2];
//		}
////		System.out.println(Arrays.toString(arr));
//		for(int i=0;i<arr.length;i++) {
//			sum+=arr[i];		
//		}
//		System.out.println(sum);
		
		
		
//��a��b���������в�ͬ�����ֱ��浽һ���µ������С�
		int[]a={10,20,30,40,50};   
		int[]b={10,20,60};
		
		int[] c=new int[4];
		int x=0;
		//��a�ֲ�ͬ��������b�Ƚ�
		for(int i=0;i<a.length;i++) {
			boolean flag=false;
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				boolean flag2=false;
				for(int k=0;k<x;k++) {
					if(a[i]==c[k]) {
						flag2=true;
						break;
					}
				}
				if(!flag2) {
					c[x]=a[i];
					x++;
				}
				
			}
		}
		//��b�ֲ�ͬ��������a�Ƚ�
		for(int i=0;i<b.length;i++) {
			boolean flag=false;
			for(int j=0;j<a.length;j++) {
				if(b[i]==a[j]) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				boolean flag2=false;
				for(int k=0;k<x;k++) {
					if(b[i]==c[k]) {
						flag2=true;
						break;
					}
				}
				if(!flag2) {
					c[x]=b[i];
					x++;
				}
				
			}
		}
		System.out.println(Arrays.toString(c));

//�ж������Ƿ�Գƣ�����int[] nums = {1,2,3,2,1};��int[] nums = {1,2,3,3,2,1}
//		int[] nums = {1,2,3,2,1};
//		Arrays.sort(nums);
//		if(nums.length%2==0) {
//			for(int i=0;i<nums.length;i+=2) {
//				if(nums[i]!=nums[i+1]) {
//					System.out.println("�����鲻�ǶԳ�����");
//				}else {
//					System.out.println("�������ǶԳ�����");
//				}
//			}
//		}else {
//			for(int i=0;i<nums.length-1;i+=2) {
//				if(nums[i]!=nums[i+1]) {
//					System.out.println("�����鲻�ǶԳ�����");
//				}else {
//					System.out.println("�������ǶԳ�����");
//				}
//			}
//		}
		
		
//ͳ��һ��������ÿ�����ֳ��ֵĸ�����
//���� int[] nums = {1,2,3,1,1,4,5,3};
//��������У�1������3�Σ�2������1�Σ�3������2�Σ�4������1�Σ�
//5������һ��
//		int[] nums = {1,2,3,1,1,4,5,3};
        //��ѭ���Ĵ���
//		for(int i=0;i<nums.length;i++) {
		//Ĭ��û���ظ���ֵ
//			boolean flag = false;
		//��ѭ��������֮ǰ�����ֽ��бȶԣ������ظ���flag��Ϊtrue��
//			for(int k=0;k<i;k++) {
//				if(nums[i]==nums[k]) {
//					flag = true;
//					break;
//				}
//			}		
//			if(!flag) {
//				int tmp=0;
//				for(int j=0;j<nums.length;j++) {
//					if(nums[i]==nums[j]) {
//						tmp++;
//					}			
//				}
//				System.out.println(nums[i]+"������"+tmp+"��");
//			}	
//		}
//		
		
		
		
//���һ�����֣�����ÿһλ�ϵ����ְ�˳�����һ��ͬ�ȳ��ȵ������У�
//���磺int i = 45276327;   ת��Ϊ  int nums = {4,5,2,7,6,3,2,7};
//		int i = 45276327;
//		int [] nums=new int[8];
//		nums[7]=i%10;
//		nums[6]=i%100/10;
//		nums[5]=i%1000/100;
//		nums[4]=i%10000/1000;
//		nums[3]=i%100000/10000;
//		nums[2]=i%1000000/100000;
//		nums[1]=i%10000000/1000000;
//		nums[0]=i%100000000/10000000;
//		System.out.println(Arrays.toString(nums));
		
		
	}
}
