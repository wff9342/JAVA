package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class onesum {
	public static void haha(int a[],int b[]) {
		
	}
	public static void main(String[] args) {
//		String[] newNums = Arrays.copyOf(nums, nums.length+1);
//		copyOf : 根据新的长度创建了一个新数组，将老数组中的内容copy进去
//		Arrays.toString(nums)打印数组[a,b,c]
//		newNums[newNums.length-1] = "78";赋值：数组名[下标]=值
//		Arrays.copyOfRange(data, 2, 7);截取data数组下标第2个到第6个元素
		
		
		
//歌手打分
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
		
		
//采用数组求斐波那契数列前10个数的和
//样本：1 1 2 3 5 8 13 21 34 55 
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
		
		
		
//将a、b两个数组中不同的数字保存到一个新的数组中。
		int[]a={10,20,30,40,50};   
		int[]b={10,20,60};
		
		int[] c=new int[4];
		int x=0;
		//将a种不同的数字与b比较
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
		//将b种不同的数字与a比较
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

//判断数组是否对称，例如int[] nums = {1,2,3,2,1};或int[] nums = {1,2,3,3,2,1}
//		int[] nums = {1,2,3,2,1};
//		Arrays.sort(nums);
//		if(nums.length%2==0) {
//			for(int i=0;i<nums.length;i+=2) {
//				if(nums[i]!=nums[i+1]) {
//					System.out.println("该数组不是对称数组");
//				}else {
//					System.out.println("该数组是对称数组");
//				}
//			}
//		}else {
//			for(int i=0;i<nums.length-1;i+=2) {
//				if(nums[i]!=nums[i+1]) {
//					System.out.println("该数组不是对称数组");
//				}else {
//					System.out.println("该数组是对称数组");
//				}
//			}
//		}
		
		
//统计一个数组中每个数字出现的个数，
//例如 int[] nums = {1,2,3,1,1,4,5,3};
//这个数组中，1出现了3次，2出现了1次，3出现了2次，4出现了1次，
//5出现了一次
//		int[] nums = {1,2,3,1,1,4,5,3};
        //总循环的次数
//		for(int i=0;i<nums.length;i++) {
		//默认没有重复的值
//			boolean flag = false;
		//将循环的数字之前的数字进行比对，若有重复则flag变为true；
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
//				System.out.println(nums[i]+"出现了"+tmp+"次");
//			}	
//		}
//		
		
		
		
//拆分一个数字，将其每一位上的数字按顺序放入一个同等长度的数组中，
//例如：int i = 45276327;   转化为  int nums = {4,5,2,7,6,3,2,7};
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
